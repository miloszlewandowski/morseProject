package com.example.milosz.morseproject.activity;

import com.example.milosz.morseproject.R;
import com.example.milosz.morseproject.model.Words;

import java.util.List;

public class DifficultActivity extends BaseGameActivity {

    @Override
    protected boolean isProgressBarEnabled() {
        return true;
    }

    @Override
    protected boolean isSignalRenderingEnabled() {
        return false;
    }

    @Override
    protected List<String> getWords() {
        return new Words().getWordList();
    }

    @Override
    protected int getBodyResId() {
        return R.string.difficult_mode_dialog_body;
    }

    @Override
    protected int getTitleResId() {
        return R.string.difficult_mode_dialog_title;
    }
}
