package com.example.milosz.morseproject.component;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.milosz.morseproject.R;

public class TutorialFinishedDialog {
    public TutorialFinishedDialog(Context context, Runnable onOkClickListener) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

        dialogBuilder.setTitle(R.string.tutorial_finished_dialog_title);
        dialogBuilder.setMessage(R.string.tutorial_finished_dialog_body);
        dialogBuilder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onOkClickListener.run();
            }
        });
        dialogBuilder.setCancelable(false);
        dialogBuilder.create().show();
    }

}
