package com.example.milosz.morseproject.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Words {
    private ArrayList<String> wordList = new ArrayList<String>();
    private String abba = "abba";
    private int index = 0;

    public Words() {
        wordList.add(abba);
    }
    public List<String> getWordList() {
        return Arrays.asList(
                "abba",
                "baba",
                "baca"
        );
    }

    public String getRandomWord() {
        SecureRandom r = new SecureRandom();
        int index = r.nextInt(getWordList().size());
        return getWordList().get(index);
    }

}
