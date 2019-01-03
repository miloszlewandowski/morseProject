package com.example.milosz.morseproject.activity;

import com.example.milosz.morseproject.model.Character;

import java.util.ArrayList;
import java.util.List;

public class TutorialActivity extends BaseGameActivity {
    @Override
    protected List<String> getWords() {
        List<String> words = new ArrayList<>();
        for (Character c : Character.values()) {
            words.add(java.lang.Character.toString(c.getCharacter()));
        }
        return words;
    }
}
