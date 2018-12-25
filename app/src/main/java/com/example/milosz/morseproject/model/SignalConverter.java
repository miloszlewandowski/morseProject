package com.example.milosz.morseproject.model;


import android.util.Log;

public class SignalConverter {

    public SignalLength convert(long length) {

        if(length >= 500 && length < 1500) {
            Log.i("mikolaj","long");
            return SignalLength.LONG;
        }

        else if(length < 500) {
            Log.i("mikolaj","short");
            return SignalLength.SHORT;
        }

        else {
            Log.i("mikolaj","undefined");
            return SignalLength.UNDEFINED;
        }
    }
}
