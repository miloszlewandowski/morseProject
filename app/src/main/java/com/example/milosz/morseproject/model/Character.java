package com.example.milosz.morseproject.model;

public enum Character {
    A('a', new SignalLength[] { SignalLength.SHORT, SignalLength.LONG }),
    B('b', new SignalLength[] { SignalLength.LONG, SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT }),
    C('c',new SignalLength[] { SignalLength.LONG, SignalLength.SHORT, SignalLength.LONG, SignalLength.SHORT }),
    D('d',new SignalLength[] { SignalLength.LONG, SignalLength.SHORT, SignalLength.SHORT}),
    E('e',new SignalLength[] { SignalLength.SHORT }),
    F('f', new SignalLength[] { SignalLength.SHORT, SignalLength.LONG }),
    G('g', new SignalLength[] { SignalLength.SHORT, SignalLength.SHORT, SignalLength.LONG, SignalLength.SHORT }),
    H('h',new SignalLength[] { SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT }),
    I('i',new SignalLength[] { SignalLength.SHORT, SignalLength.SHORT }),
    J('j',new SignalLength[] { SignalLength.SHORT, SignalLength.LONG, SignalLength.LONG, SignalLength.LONG }),
    K('k', new SignalLength[] { SignalLength.LONG, SignalLength.SHORT, SignalLength.LONG }),
    L('l',new SignalLength[] { SignalLength.SHORT, SignalLength.LONG, SignalLength.SHORT, SignalLength.SHORT }),
    M('m',new SignalLength[] { SignalLength.LONG, SignalLength.LONG }),
    N('n',new SignalLength[] { SignalLength.LONG, SignalLength.SHORT }),
    O('o', new SignalLength[] { SignalLength.LONG, SignalLength.LONG, SignalLength.LONG }),
    P('p',new SignalLength[] { SignalLength.SHORT, SignalLength.LONG, SignalLength.LONG, SignalLength.SHORT }),
    Q('q',new SignalLength[] { SignalLength.LONG, SignalLength.LONG, SignalLength.SHORT, SignalLength.LONG }),
    R('r',new SignalLength[] { SignalLength.SHORT, SignalLength.LONG, SignalLength.SHORT }),
    S('s', new SignalLength[] { SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT }),
    T('t',new SignalLength[] { SignalLength.LONG }),
    U('u',new SignalLength[] { SignalLength.SHORT, SignalLength.SHORT, SignalLength.LONG }),
    V('v',new SignalLength[] { SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT, SignalLength.LONG }),
    W('w', new SignalLength[] { SignalLength.SHORT, SignalLength.LONG, SignalLength.LONG }),
    X('x', new SignalLength[] { SignalLength.LONG, SignalLength.SHORT, SignalLength.SHORT, SignalLength.LONG }),
    Y('y',new SignalLength[] { SignalLength.LONG, SignalLength.SHORT, SignalLength.LONG, SignalLength.LONG }),
    Z('z',new SignalLength[] { SignalLength.LONG, SignalLength.LONG, SignalLength.SHORT, SignalLength.SHORT }),
    ZERO('0',new SignalLength[] { SignalLength.LONG, SignalLength.LONG, SignalLength.LONG, SignalLength.LONG, SignalLength.LONG, }),
    ONE('1', new SignalLength[] { SignalLength.SHORT,SignalLength.LONG, SignalLength.LONG, SignalLength.LONG, SignalLength.LONG, }),
    TWO('2',new SignalLength[] { SignalLength.SHORT, SignalLength.SHORT, SignalLength.LONG, SignalLength.LONG, SignalLength.LONG, }),
    THREE('3',new SignalLength[] { SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT, SignalLength.LONG, SignalLength.LONG }),
    FOUR('4',new SignalLength[] {  SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT,SignalLength.LONG }),
    FIVE('5',new SignalLength[] { SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT }),
    SIX('6', new SignalLength[] { SignalLength.LONG, SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT }),
    SEVEN('7',new SignalLength[] { SignalLength.LONG, SignalLength.LONG, SignalLength.SHORT, SignalLength.SHORT, SignalLength.SHORT }),
    EIGHT('8',new SignalLength[] { SignalLength.LONG, SignalLength.LONG, SignalLength.LONG, SignalLength.SHORT, SignalLength.SHORT }),
    NINE('9',new SignalLength[] { SignalLength.LONG, SignalLength.LONG, SignalLength.LONG, SignalLength.LONG, SignalLength.SHORT }),

    UNDEFINED(' ', null);

    private char character;
    private SignalLength[] signals;

    Character(char character, SignalLength[] signals) {
        this.character = character;
        this.signals = signals;
    }

    public static Character fromCharacter(char character) {
        character = java.lang.Character.toString(character).toLowerCase().toCharArray()[0];
        for (Character c : Character.values()) {
            if (character == c.character) {
                return c;
            }
        }
        throw new RuntimeException("Could not convert char to Character");
    }

    public SignalLength[] getSignals() {
        return signals;
    }

    public char getCharacter() {
        return this.character;
    }
}
