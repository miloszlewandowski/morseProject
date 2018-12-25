package com.example.milosz.morseproject.controller;

import com.example.milosz.morseproject.model.Character;

public class WordInputController {
    private  String word;
    private short index = 0;
    private CharacterInputController characterInputController;

    public WordInputController (String word) {
        this.word = word;
        this.assignCharacterController();
    }

    private void assignCharacterController () {
        Character character = Character.fromCharacter(this.word.charAt(this.index));
        this.characterInputController = new CharacterInputController(character);
    }

    public boolean acceptRawSignal(long signalLength) {
        boolean out = this.characterInputController.acceptRawSignal(signalLength);
        if (this.characterInputController.isFinished()) {
            this.index++;
            if (!isFinished()) {
                this.assignCharacterController();
            }
        }

        return out;
    }

    public boolean isFinished() {
        return this.index == this.word.length();
    }

}
