package com.example.madaim.ex13;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyDialog extends DialogFragment
{
    public final static String data="ItemData";
    public final static int ADD_NUMBER_DIALOG = -1;
    private int reqCode;
    private ResultListener listener;
    private static MyDialog dlg=null;


    static MyDialog newInstance(int requetCode)
    {
        if(dlg == null)
            dlg = new MyDialog();
        Bundle args = new Bundle();
        args.putInt("rc", requetCode);
        dlg.setArguments(args);
        return dlg;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if(ADD_NUMBER_DIALOG == getArguments().getInt("rc"))
            return buildAddContactDialog().create();
        else{
         }

        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(),"Closing dialog",Toast.LENGTH_SHORT).show();
    }


    private AlertDialog.Builder buildAddContactDialog()
    {
        final View view = getActivity().getLayoutInflater().inflate(R.layout.dialog,null);

        final Button red = view.findViewById(R.id.red);
        final Button green = view.findViewById(R.id.green);
        final Button blue = view.findViewById(R.id.blue);
        final EditText ed = view.findViewById(R.id.inputNum);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed.setBackground(red.getBackground());
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed.setBackground(blue.getBackground());
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed.setBackground(green.getBackground());
            }
        });
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dismiss();
                            }
                        })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface  dialogInterface, int i) {
                        Item it=new Item();
                        it.setColor(((ColorDrawable)ed.getBackground()).getColor());
                        it.setNum(Integer.parseInt(ed.getText().toString()));
                        listener.onFinishedDialog(it);
                        dismiss();
                    }
                });
    }
    public void onAttach(Context context) {
         super.onAttach(context);
        try {
            this.listener = (ResultListener) context;
        } catch (ClassCastException e) {
            //Toast.makeText(context, "hosting activity must implements ResultListener", Toast.LENGTH_LONG).show();
            throw new ClassCastException("hosting activity must implements ResultListener");
        }
    }


    public interface ResultListener {
        void onFinishedDialog(Object results);
    }

}
