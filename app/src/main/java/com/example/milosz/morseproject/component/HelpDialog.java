package com.example.milosz.morseproject.component;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.example.milosz.morseproject.R;

public class HelpDialog  {

    public HelpDialog(Context context, int score, Runnable r) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

        dialogBuilder.setTitle(R.string.help_dialog_title);
        dialogBuilder.setMessage(R.string.help_dialog_body);
        dialogBuilder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                r.run();
            }
        });
        dialogBuilder.setCancelable(true);
        dialogBuilder.create().show();
    }
}
