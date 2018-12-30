package com.example.milosz.morseproject.controller;


import com.example.milosz.morseproject.model.SignalConverter;
import com.example.milosz.morseproject.model.SignalLength;
import com.example.milosz.morseproject.model.Character;
public class CharacterInputController {

   private Character character;
   private short index = 0;
   private SignalConverter converter = new SignalConverter();

    public CharacterInputController(Character character) {
        this.character = character;
    }

    public boolean acceptRawSignal(long signalLength) {
        SignalLength length = this.converter.convert(signalLength);
        if (length == SignalLength.UNDEFINED) {
            return false;
        } else if (length == this.character.getSignals()[this.index]) {
            this.index++;
            return true;
        } else return false;


    }

    public boolean isFinished() {
        return this.index == this.character.getSignals().length;
    }

    public Character getCharacter() {
        return this.character;
    }

}
