package com.example.mycalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

public class twoFra extends Fragment {
    TextView textView;
    ImageButton imageButton1,imageButton2;
    private String file="myfile";
    private String filecontents , ttt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.f,container,false);

       textView=view.findViewById(R.id.textid_e);
       Bundle bundle=this.getArguments();
       final String d=bundle.getString("data");

        try {
            FileInputStream fin=getContext().openFileInput(file);
            int c;
            String temp="";
            while ((c=fin.read())!=-1){
                temp=temp+Character.toString((char)c);
            }
           ttt=temp;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(d.isEmpty()){
            ttt=ttt.concat(d);
        }
        else{
        ttt=ttt.concat("\n\n");
                ttt=ttt.concat(d);}
        try {
            FileOutputStream fout=getContext().openFileOutput(file,MODE_PRIVATE);
            fout.write(ttt.getBytes());
            fout.close();
            File filederectory=new File(getContext().getFilesDir(),file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileInputStream fin=getContext().openFileInput(file);
            int c;
            String temp="";
            while ((c=fin.read())!=-1){
                temp=temp+Character.toString((char)c);
            }
            textView.setText(temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


       imageButton1=view.findViewById(R.id.imagebutn1);
       imageButton1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               standard ff=new standard();
               getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       ff).commit();
           }
       });
       imageButton2=view.findViewById(R.id.imagebutn2);
       imageButton2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String ppp="";
               try {
                   FileOutputStream fout=getContext().openFileOutput(file,MODE_PRIVATE);
                   fout.write(ppp.getBytes());
                   fout.close();
                   File filederectory=new File(getContext().getFilesDir(),file);


                   try {
                       FileInputStream fin=getContext().openFileInput(file);
                       int c;
                       String temp="";
                       while ((c=fin.read())!=-1){
                           temp=temp+Character.toString((char)c);
                       }
                       textView.setText(temp);
                   } catch (FileNotFoundException e) {
                       e.printStackTrace();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }

               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       });

       return view;

    }


}
