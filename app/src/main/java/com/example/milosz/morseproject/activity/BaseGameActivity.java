package com.example.milosz.morseproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.milosz.morseproject.R;
import com.example.milosz.morseproject.component.TutorialFinishedDialog;
import com.example.milosz.morseproject.controller.WordInputController;
import com.example.milosz.morseproject.model.SignalLength;

import java.io.IOException;
import java.util.List;

public abstract class BaseGameActivity extends Activity {

    Button actionArea;
    private long start;
    private long end;
    private MediaPlayer beepSound;
    private LinearLayout renderedSignsLayout;
    private LinearLayout renderedTextLayout;
    private int wordIndex = 0;
    private String currentWord;
    private int highlightIndex = 0;
    private WordInputController wordInputController;
    private final Handler handler = new Handler();
    private final Runnable runnable = new Runnable() {
        public void run() {
            long result = end - start;
            wordInputController.acceptRawSignal(result);
            if (wordInputController.isFinished()) {
                Log.i("mikolaj","rozpoznano literkolaja");
                onWordFinsihed();
            }
        }
    };


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionArea = (Button)findViewById(R.id.actionArea);
        this.renderedTextLayout = (LinearLayout)findViewById(R.id.textView);
        this.renderedSignsLayout = (LinearLayout)findViewById(R.id.renderedSignals);
        beepSound = MediaPlayer.create(this,R.raw.beep);
        actionArea.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    BaseGameActivity.this.start = System.currentTimeMillis();
                    beepSound.start();
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    beepSound.stop();

                    try {
                        beepSound.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BaseGameActivity.this.end = System.currentTimeMillis();
                    BaseGameActivity.this.handler.post(runnable);

                }

                return false;
            }

        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        this.displayWord(this.getWords().get(0));
    }

    private void displayWord(String word) {
        this.currentWord = word;
        this.renderWord(word);
        this.wordInputController = new WordInputController(word);
        this.wordInputController.setOnNewCharacterListener(this::onNewLetter);
    }

    private void onWordFinsihed() {
        this.wordIndex++;
        this.highlightIndex = 0;
        if (this.wordIndex == this.getWords().size()) {
            new TutorialFinishedDialog(this, this::onTutorialFinished);
            return;
        }
        this.displayWord(this.getWords().get(this.wordIndex));
    }

    private void onTutorialFinished() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void onNewLetter(SignalLength[] signalsArray) {
        this.renderCharacterSignals(signalsArray);
        this.highlightLetter(this.highlightIndex);
        this.highlightIndex++;
    }
    private void renderCharacterSignals(SignalLength[] signalsArray) {
        while (this.renderedSignsLayout.getChildCount() > 0) {
            this.renderedSignsLayout.removeViewAt(0);
        }
        for (SignalLength signal : signalsArray) {
            ImageView imageView = new ImageView(this);
            switch (signal) {
                case SHORT: {
                    imageView.setImageResource(R.drawable.period_symbol);
                    break;
                }
                case LONG: {
                    imageView.setImageResource(R.drawable.minus_symbol);
                    break;
                }
                case UNDEFINED: {
                    assert(false);
                }
            }
            this.renderedSignsLayout.addView(imageView);
        }
    }

    private void renderWord(String word) {
        while (this.renderedTextLayout.getChildCount() > 0) {
            this.renderedTextLayout.removeViewAt(0);
        }

        for (char character : word.toCharArray()) {
            TextView textView = new TextView(this);
            textView.setText(Character.toString(character));
            textView.setTextSize(50);
            textView.setTextColor(Color.BLACK);
            this.renderedTextLayout.addView(textView);
        }
    }

    private void highlightLetter(int index) {
        for (int i = 0; i < this.renderedTextLayout.getChildCount(); i++) {
            TextView textView  = (TextView) this.renderedTextLayout.getChildAt(i);
            textView.setTextColor(Color.BLACK);
        }
        TextView textView  = (TextView) this.renderedTextLayout.getChildAt(index);
        textView.setTextColor(Color.RED);

    }

    protected abstract List<String> getWords();
}
