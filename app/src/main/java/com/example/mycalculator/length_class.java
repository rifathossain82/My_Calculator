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

public class length_class extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner1,spinner2;
    TextView textView1,textView2;
    ImageButton clear;
    Button ac,zero,dot,one,two,three,four,five,six,seven,eight,nine;

    ArrayList<Float> number = new ArrayList<>();
    ArrayList<String> number2 = new ArrayList<>();
    String oldOperator = "";
    int counter = 0;
    int counter2 = 0;
    String d;

    int cal;

    String bttnType = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.length,container,false);

        spinner1=view.findViewById(R.id.spinner_length1);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),R.array.length1,R.layout.colorspinner);

        adapter.setDropDownViewResource(R.layout.spinnercolor_layout);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        spinner2=view.findViewById(R.id.spinner_length2);
        ArrayAdapter adapter2=ArrayAdapter.createFromResource(getContext(),R.array.length2,R.layout.colorspinner);

        adapter2.setDropDownViewResource(R.layout.spinnercolor_layout);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        ac=view.findViewById(R.id.length_btu1);
        clear=view.findViewById(R.id.length_btu2);
        seven=view.findViewById(R.id.length_btu3);
        eight=view.findViewById(R.id.length_btu4);
        nine=view.findViewById(R.id.length_btu5);
        four=view.findViewById(R.id.length_btu6);
        six=view.findViewById(R.id.length_btu7);
        five=view.findViewById(R.id.length_btu8);
        one=view.findViewById(R.id.length_btu9);
        two=view.findViewById(R.id.length_btu10);
        three=view.findViewById(R.id.length_btu11);
        zero=view.findViewById(R.id.length_btu12);
        dot=view.findViewById(R.id.length_btu13);

        textView1=view.findViewById(R.id.length_textviewid);
        textView2=view.findViewById(R.id.length_textviewid2);

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
        else if(i==0 && i2==3 ){
            cal=4;
        }
        else if(i==0 && i2==4 ){
            cal=5;
        }
        else if(i==1 && i2==0 ){
            cal=6;
        }
        else if(i==1 && i2==1 ){
            cal=7;
        }
        else if(i==1 && i2==2 ){
            cal=8;
        }
        else if(i==1 && i2==3 ){
            cal=9;
        }
        else if(i==1 && i2==4 ){
            cal=10;
        }
        else if(i==2 && i2==0 ){
            cal=11;
        }
        else if(i==2 && i2==1 ){
            cal=12;
        }
        else if(i==2 && i2==2 ){
            cal=13;
        }
        else if(i==2 && i2==3 ){
            cal=14;
        }
        else if(i==2 && i2==4 ){
            cal=15;
        }
        else if(i==3 && i2==0 ){
            cal=16;
        }
        else if(i==3 && i2==1 ){
            cal=17;
        }
        else if(i==3 && i2==2 ){
            cal=18;
        }
        else if(i==3 && i2==3 ){
            cal=19;
        }
        else if(i==3 && i2==4 ){
            cal=20;
        }
        else if(i==4 && i2==0 ){
            cal=21;
        }
        else if(i==4 && i2==1 ){
            cal=22;
        }
        else if(i==4 && i2==2 ){
            cal=23;
        }
        else if(i==4 && i2==3 ){
            cal=24;
        }
        else if(i==4 && i2==4 ){
            cal=25;
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
                case 7:
                case 13:
                case 19:
                case 25:
                    num = Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 2:
                    num = 0.01 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 3:
                    num = 0.00001 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 4:
                    num = 0.393701 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 5:
                    num = 0.0328084 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 6:
                    num = 100 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 8:
                    num = 0.001 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 9:
                    num = 39.37008 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 10:
                    num = 3.28084 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 11:
                    num = 100000 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 12:
                    num = 1000 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 14:
                    num = 39370.08 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 15:
                    num = 3280.84 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 16:
                    num = 2.54 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 17:
                    num = 0.0254 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 18:
                    num = 0.0000254 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 20:
                    num = 0.0833333 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 21:
                    num = 30.48 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 22:
                    num = 0.3048 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 23:
                    num = 0.0003048 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;
                case 24:
                    num = 12 * Double.parseDouble(textView1.getText().toString());
                    textView2.setText(Double.toString(num));
                    break;


            }
        }
    }

}
