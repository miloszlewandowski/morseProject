package com.example.milosz.morseproject.component;

import android.app.AlertDialog;
import android.content.Context;

import com.example.milosz.morseproject.R;

public class HelpDialog  {

    public HelpDialog(Context context) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

        dialogBuilder.setTitle(R.string.help_dialog_title);
        dialogBuilder.setMessage(R.string.help_dialog_body);

        dialogBuilder.setCancelable(true);
        dialogBuilder.create().show();
    }
}
