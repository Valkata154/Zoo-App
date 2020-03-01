/*
 * DIALOG CLASS FOR FOOD ORDER
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogOrder extends AppCompatDialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        // Create the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.orderTitle))
                            .setMessage(getString(R.string.orderMessage1) + " " + ActivityFoodShop.numPrice + " " + getString(R.string.orderMessage2))
                            .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                        // Close dialog and return to main menu
                        dialog.dismiss();
                        ((ActivityFoodShop) getActivity()).finish();
                        // Reset the basket and total price
                        ActivityFoodShop.numBasket = 0;
                        ActivityFoodShop.numPrice = 0.0;
                    }
                });

        return builder.create();
    }
}