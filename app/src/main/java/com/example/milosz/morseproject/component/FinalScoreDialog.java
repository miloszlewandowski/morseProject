package com.example.milosz.morseproject.component;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.milosz.morseproject.R;

public class FinalScoreDialog {

    public FinalScoreDialog(Context context, int score, Runnable r) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

        dialogBuilder.setTitle("mikusie");
        dialogBuilder.setMessage(String.format("Your score is: %d", score));
        dialogBuilder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               r.run();
            }
        });
        dialogBuilder.setCancelable(false);
        dialogBuilder.create().show();
    }
}
