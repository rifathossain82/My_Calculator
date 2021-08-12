package com.example.mycalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class currency extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextView textView,result;
    ImageButton clear;
    Button ac,zero,dot,one,two,three,four,five,six,seven,eight,nine;

    ArrayList<Float> number = new ArrayList<>();
    ArrayList<String> number2 = new ArrayList<>();
    Float num1, num2, ans;
    String oldOperator = "";
    int counter = 0;
    int counter2 = 0;
    String d;

    public int i=1;

    String bttnType = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.currency_con,container,false);

        spinner=view.findViewById(R.id.spinner_currency);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),R.array.contries_name,R.layout.colorspinner);

        adapter.setDropDownViewResource(R.layout.spinnercolor_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ac=view.findViewById(R.id.cu_btu1);
        clear=view.findViewById(R.id.cu_btu2);
        seven=view.findViewById(R.id.cu_btu3);
        eight=view.findViewById(R.id.cu_btu4);
        nine=view.findViewById(R.id.cu_btu5);
        four=view.findViewById(R.id.cu_btu6);
        six=view.findViewById(R.id.cu_btu7);
        five=view.findViewById(R.id.cu_btu8);
        one=view.findViewById(R.id.cu_btu9);
        two=view.findViewById(R.id.cu_btu10);
        three=view.findViewById(R.id.cu_btu11);
        zero=view.findViewById(R.id.cu_btu12);
        dot=view.findViewById(R.id.cu_btu13);

        textView=view.findViewById(R.id.currency_textviewid);
        result=view.findViewById(R.id.currency_resultid);

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("0");
                result.setText("0");
                int s=spinner.getSelectedItemPosition();
                showresult(s);
                number.clear();
                dot.setEnabled(true);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =textView.getText().toString();
                if (str.length() > 0) {
                    String str1 = str.substring(0, str.length() - 1);
                    textView.setText(str1);
                }
                if(str.length()<0){
                    textView.setText("0");
                }
                if(textView.getText().toString().contains(".")){
                    dot.setEnabled(false);
                }
                else{
                    dot.setEnabled(true);
                }
                int s=spinner.getSelectedItemPosition();
                showresult(s);
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
        showresult(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    void numberClickmethod(String ss){
        if(textView.getText().toString().contains(".")){

        }
        else if(Double.parseDouble(textView.getText().toString())<=0.0){
            textView.setText("");
            String nump = ss;
            if(nump.contains(".")){
                textView.setText("0");
            }
        }
        if (textView.length()>=9){
            Toast.makeText(getContext(), "Maximum 9 digits are acceptable.", Toast.LENGTH_SHORT).show();
        }
        else {

            counter2++;
            if (bttnType.equals("opr")) {
                textView.setText("");
            }
            String num = ss;
            String oldnum = textView.getText().toString();

            textView.setText(oldnum + num);

            bttnType = "num";
            counter = 0;
            String numTEs = textView.getText().toString();
            if (numTEs.contains(".")) {
                dot.setEnabled(false);
            }

            int s = spinner.getSelectedItemPosition();
            showresult(s);
        }

    }
    void showresult(int position){
       if(position==0){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=224.26*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==1){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=20.58*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==2){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=11.92*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==3){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=1.19*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==4){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=0.78*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==5){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=0.07*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==6){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=20.20*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==7){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=22.53*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==8){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=57.39*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==9){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=64.03*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==10){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=93.32*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==11){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=0.06*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==12){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=53.58*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==13){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=0.54*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==14){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=1.32*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==15){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=61.57*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==16){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=5.71*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==17){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=2.78*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==18){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=84.63*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==19){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=110.37*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==20){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=23.04*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==21){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=0.02*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==22){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=0.46*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==23){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=219.88*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==24){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=0.72*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==25){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=0.07*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==26){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=5.49*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==27){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=277.29*value;
                result.setText(Double.toString(value));
            }
        }
        else if(position==28){
            if(textView.getText().toString().isEmpty()){
                textView.setText("0");
                result.setText("0");
            }
            else{
                double value=Double.parseDouble(textView.getText().toString());
                value=5.40*value;
                result.setText(Double.toString(value));
            }
        }
    }
}
