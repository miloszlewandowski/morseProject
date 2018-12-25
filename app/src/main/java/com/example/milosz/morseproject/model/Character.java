package com.example.milosz.morseproject.model;

public enum Character {
    A('a', new SignalLength[] { SignalLength.SHORT, SignalLength.LONG }),
    B('b', new SignalLength[] { SignalLength.LONG, SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT }),
    UNDEFINED(' ', null);

    private char character;
    private SignalLength[] signals;

    Character(char character, SignalLength[] signals) {

        this.character = character;
        this.signals = signals;



    }

    public static Character fromCharacter(char character) {
        if (character == 'a') {
            return Character.A;
        } else if (character == 'b') {
            return Character.B;
        } else {
            return Character.UNDEFINED;
        }
    }

    public SignalLength[] getSignals() {
        return signals;
    }

}
