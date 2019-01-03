package com.example.milosz.morseproject.activity;

import com.example.milosz.morseproject.R;
import com.example.milosz.morseproject.model.Words;

import java.util.List;

public class EasyActivity extends TutorialActivity {

    @Override
    protected List<String> getWords() {
        return new Words().getWordList();
    }

    @Override
    protected int getTitleResId() {
        return R.string.easy_mode_dialog_title;
    }

    @Override
    protected int getBodyResId() {
        return R.string.easy_mode_dialog_body;
    }
}
