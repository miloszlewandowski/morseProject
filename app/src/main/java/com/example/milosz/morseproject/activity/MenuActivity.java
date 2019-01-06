package com.example.milosz.morseproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.milosz.morseproject.R;
import com.example.milosz.morseproject.component.HelpDialog;

public class MenuActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.findViewById(R.id.alphabet_picture).setOnClickListener(this::onAlphabetClick);
        this.findViewById(R.id.tutorial_button).setOnClickListener(this::onTutorialClick);
        this.findViewById(R.id.easy_button).setOnClickListener(this::onEasyModeClick);
        this.findViewById(R.id.difficult_button).setOnClickListener(this::onDifficultModeClick);
        this.findViewById(R.id.best_scores_button).setOnClickListener(this::onBestScoreClick);
        this.findViewById(R.id.help_button).setOnClickListener(this::onHelpClick);
    }

    private void onAlphabetClick(View v) {
        Intent intent = new Intent(this,AlphabetActivity.class);
        this.startActivity(intent);
    }

    private void onTutorialClick(View v) {
        Intent intent = new Intent(this,TutorialActivity.class);
        this.startActivity(intent);
    }

    private void onEasyModeClick(View v) {
        Intent intent = new Intent(this,EasyActivity.class);
        this.startActivity(intent);
    }

    private void onDifficultModeClick(View v) {
        Intent intent = new Intent(this,DifficultActivity.class);
        this.startActivity(intent);
    }

    private void onBestScoreClick(View v) {
        Intent intent = new Intent(this,BestScoreActivity.class);
        this.startActivity(intent);
    }

    private void onHelpClick(View v) {
        new HelpDialog(this);
    }
}
