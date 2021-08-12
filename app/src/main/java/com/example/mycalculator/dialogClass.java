package com.example.mycalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class dialogClass extends AppCompatDialogFragment {
    EditText editText;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.alart_dialog_layout,null);
editText=view.findViewById(R.id.feedback_editid);
        builder.setView(view)
                .setTitle("Feedback")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(editText.getText().toString().isEmpty()){
                            Toast.makeText(getContext(), "Feedback is empty!!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            try {
                                Intent it = new Intent(Intent.ACTION_SEND);
                                it.putExtra(Intent.EXTRA_EMAIL, new String[]{"rhrifat940279@gmail.com"});
                                it.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                                it.putExtra(Intent.EXTRA_TEXT, "" + editText.getText().toString());
                                it.setType("message/rfc822");

                                startActivity(it);
                            } catch (Exception e) {
                                Toast.makeText(getContext(), "Error occurred", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                });
        return builder.create();
    }
}
