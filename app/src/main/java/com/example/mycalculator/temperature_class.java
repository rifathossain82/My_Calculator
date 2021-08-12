package com.example.mycalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class temperature_class extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner1,spinner2;
    TextView textView1,textView2;
    ImageButton clear;
    Button ac,zero,dot,one,two,three,four,five,six,seven,eight,nine;

    ArrayList<Float> number = new ArrayList<>();
    int counter = 0;
    int counter2 = 0;

    int cal;

    String bttnType = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.temperature,container,false);

        spinner1=view.findViewById(R.id.spinner_tem1);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),R.array.temperature_names,R.layout.colorspinner);

        adapter.setDropDownViewResource(R.layout.spinnercolor_layout);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        spinner2=view.findViewById(R.id.spinner_tem2);
        ArrayAdapter adapter2=ArrayAdapter.createFromResource(getContext(),R.array.temperature_names,R.layout.colorspinner);

        adapter2.setDropDownViewResource(R.layout.spinnercolor_layout);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        ac=view.findViewById(R.id.tem_btu1);
        clear=view.findViewById(R.id.tem_btu2);
        seven=view.findViewById(R.id.tem_btu3);
        eight=view.findViewById(R.id.tem_btu4);
        nine=view.findViewById(R.id.tem_btu5);
        four=view.findViewById(R.id.tem_btu6);
        six=view.findViewById(R.id.tem_btu7);
        five=view.findViewById(R.id.tem_btu8);
        one=view.findViewById(R.id.tem_btu9);
        two=view.findViewById(R.id.tem_btu10);
        three=view.findViewById(R.id.tem_btu11);
        zero=view.findViewById(R.id.tem_btu12);
        dot=view.findViewById(R.id.tem_btu13);

        textView1=view.findViewById(R.id.tem_textviewid);
        textView2=view.findViewById(R.id.tem_textviewid2);

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("0");
                textView2.setText("0");
                ShowTest();
                number.clear();
                dot.setEnabled(true);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =textView1.getText().toString();
                if (str.length() > 0) {
                    String str1 = str.substring(0, str.length() - 1);
                    textView1.setText(str1);
                }
                if(str.length()<0){
                    textView1.setText("0");
                }
                if(textView1.getText().toString().contains(".")){
                    dot.setEnabled(false);
                }
                else{
                    dot.setEnabled(true);
                }
                ShowTest();
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClickmethod(zero.getText().toString());
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClickmethod(one.getText().toString());
            }

        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                numberClickmethod(two.getText().toString());
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClickmethod(three.getText().toString());
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClickmethod(four.getText().toString());
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClickmethod(five.getText().toString());
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClickmethod(six.getText().toString());
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClickmethod(seven.getText().toString());
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClickmethod(eight.getText().toString());
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClickmethod(nine.getText().toString());
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClickmethod(dot.getText().toString());
            }
        });

        return view;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ShowTest();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    void numberClickmethod(String ss){
        if(textView1.getText().toString().contains(".")){

        }
        else if(Double.parseDouble(textView1.getText().toString())<=0.0){
            textView1.setText("");
            String nump = ss;
            if(nump.contains(".")){
                textView1.setText("0");
            }
        }
        if (textView1.length()>=9){
            Toast.makeText(getContext(), "Maximum 9 digits are acceptable.", Toast.LENGTH_SHORT).show();
        }
        else {
            counter2++;
            if (bttnType.equals("opr")) {
                textView1.setText("");
            }

            String num = ss;
            String oldnum = textView1.getText().toString();

            textView1.setText(oldnum + num);

            bttnType = "num";
            counter = 0;
            String numTEs = textView1.getText().toString();
            if (numTEs.contains(".")) {
                dot.setEnabled(false);
            }


            ShowTest();
        }

    }
    void ShowTest(){
        int i=spinner1.getSelectedItemPosition();
        int i2=spinner2.getSelectedItemPosition();

        if(i==0 && i2==0 ){
            cal=1;
        }
        else if(i==0 && i2==1 ){
            cal=2;
        }
        else if(i==0 && i2==2 ){
            cal=3;
        }
        else if(i==1 && i2==0 ){
            cal=4;
        }
        else if(i==1 && i2==1 ){
            cal=5;
        }
        else if(i==1 && i2==2){
            cal=6;
        }
        else if(i==2 && i2==0 ){
            cal=7;
        }
        else if(i==2 && i2==1 ){
            cal=8;
        }
        else if(i==2 && i2==2 ){
            cal=9;
        }
        else{

        }
        Arithmethic();
    }
    public void Arithmethic(){
        if(textView1.getText().toString().isEmpty() || textView2.getText().toString().isEmpty()){
            textView1.setText("0");
            textView2.setText("0");
        }
        else {
            double num;
            switch (cal) {

                case 1:
                case 5:
                case 9:
                    num = Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 2:
                    num = 32 + 1.8 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 3:
                    num = 273.15 + Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 4:
                    num = 0.5555599999999998 * Double.parseDouble(textView1.getText().toString()) - 17.77778;
                    textView2.setText(Double.toString(num));
                    break;
                case 6:
                    num = 255.3722 + 0.5555999999999983 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 7:
                    num = Double.parseDouble(textView1.getText().toString()) - 273.15;
                    textView2.setText(Double.toString(num));
                    break;
                case 8:
                    num = 1.8000000000000114 * Double.parseDouble(textView1.getText().toString()) - 459.67;
                    textView2.setText(Double.toString(num));
                    break;


            }
        }
    }

}
