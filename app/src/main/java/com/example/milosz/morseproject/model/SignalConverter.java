package com.example.milosz.morseproject.model;


import android.util.Log;

public class SignalConverter {

    public SignalLength convert(long length) {

        if(length >= 500 && length < 1500) {
            Log.e("mikolaj","long");
            return SignalLength.LONG;
        }

        else if(length < 500) {
            Log.e("mikolaj","short");
            return SignalLength.SHORT;
        }

        else {
            Log.e("mikolaj","undefined");
            return SignalLength.UNDEFINED;
        }
    }
}
