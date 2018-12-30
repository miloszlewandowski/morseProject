package com.example.milosz.morseproject.controller;

import com.example.milosz.morseproject.model.Character;
import com.example.milosz.morseproject.model.SignalLength;

public class WordInputController {
    private  String word;
    private short index = 0;
    private CharacterInputController characterInputController;
    private OnNewCharacterListener onNewCharacterListener;

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
                this.onNewCharacterListener.onNewCharacter(this.signalToSign());
            }
        }

        return out;
    }

    public SignalLength[] signalToSign() {
        Character character = Character.fromCharacter(this.word.charAt(this.index));
        return character.getSignals();
    }

    public boolean isFinished() {
        return this.index == this.word.length();
    }

    public interface OnNewCharacterListener {
        void onNewCharacter(SignalLength[] signalLength);
    }

    public void setOnNewCharacterListener(OnNewCharacterListener onNewCharacterListener) {
        this.onNewCharacterListener = onNewCharacterListener;
        this.onNewCharacterListener.onNewCharacter(this.signalToSign());
    }

}
