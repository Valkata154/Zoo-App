/*
 * DIALOG CLASS FOR FEEDBACK
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        // Create the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.dialogThanks))
                .setMessage(getString(R.string.dialogMessage))
                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Close dialog and return to main menu
                        dialog.dismiss();
                        ((FeedbackActivity) getActivity()).finish();
                    }
                });

        return builder.create();
    }
}
