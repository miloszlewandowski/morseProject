package com.example.milosz.morseproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.milosz.morseproject.R;

public class MenuActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.findViewById(R.id.alphabet_picture).setOnClickListener(this::onAlphabetClick);
        this.findViewById(R.id.tutorial_button).setOnClickListener(this::onTutorialClick);
        this.findViewById(R.id.easy_button).setOnClickListener(this::onEasyModeClick);
        this.findViewById(R.id.difficult_button).setOnClickListener(this::onDifficultModeClick);
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
}
