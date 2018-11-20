package com.example.milosz.morseproject;

import android.annotation.SuppressLint;
import android.app.Activity;
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

import java.io.IOException;

public class MainActivity extends Activity {

    Button actionArea;
    private long start;
    private long end;
    private MediaPlayer beepSound;
    private final Handler handler = new Handler();
    private final Runnable runnable = new Runnable() {
        public void run() {

            long result = end - start;
            if(result >= 500) {
                Log.i("dlugi","dlugi");

            }
            else {
                Log.i("krotki","krotki");

            }
        }
    };


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionArea = (Button)findViewById(R.id.actionArea);

        beepSound = MediaPlayer.create(this,R.raw.beep);
        actionArea.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    MainActivity.this.start = System.currentTimeMillis();
                    beepSound.start();
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    beepSound.stop();

                    try {
                        beepSound.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    MainActivity.this.end = System.currentTimeMillis();
                    MainActivity.this.handler.post(runnable);

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
}
