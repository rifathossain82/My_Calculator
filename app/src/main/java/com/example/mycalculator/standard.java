package com.example.mycalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class standard extends Fragment{
    ArrayList<Float> number = new ArrayList<>();
    ArrayList<String> number2 = new ArrayList<>();
    Float num1, num2, ans;
    String oldOperator = "";
    int counter = 0;
    int counter2 = 0,counter3=0;
    String d;

    public int i=1;

    String bttnType = "";

    private TextView value,result;
   private ImageButton history,clear;
   private Button ac,module,divide,seven,eight,nine,one,two,three,four,five,six,multi,sub,add,equal,zero,dot,plus_minus;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.standard_cal,container,false);

        value=view.findViewById(R.id.valutxt);
        result=view.findViewById(R.id.resultTxt);
        history=view.findViewById(R.id.history_id);
        ac=view.findViewById(R.id.st_btu1);
        clear=view.findViewById(R.id.st_btu2);
        module=view.findViewById(R.id.st_btu3);
        divide=view.findViewById(R.id.st_btu4);
        seven=view.findViewById(R.id.st_btu5);
        eight=view.findViewById(R.id.st_btu6);
        nine=view.findViewById(R.id.st_btu7);
        multi=view.findViewById(R.id.st_btu8);
        four=view.findViewById(R.id.st_btu9);
        five=view.findViewById(R.id.st_btu10);
        six=view.findViewById(R.id.st_btu11);
        sub=view.findViewById(R.id.st_btu12);
        one=view.findViewById(R.id.st_btu13);
        two=view.findViewById(R.id.st_btu14);
        three=view.findViewById(R.id.st_btu15);
        add=view.findViewById(R.id.st_btu16);
        plus_minus=view.findViewById(R.id.st_btu17);
        zero=view.findViewById(R.id.st_btu18);
        dot=view.findViewById(R.id.st_btu19);
        equal=view.findViewById(R.id.st_btu20);
        result.setText("0");

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText("");
                result.setText("0");
                number.clear();
                dot.setEnabled(true);

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str =result.getText().toString();

                if(counter3==1){
                    result.setText("0");
                    counter3=0;
                }
                else {
                    if (str.length() > 0) {
                        String str1 = str.substring(0, str.length() - 1);
                        result.setText(str1);
                    }
                    if (str.length() <= 1) {
                        result.setText("0");
                    }
                    if (result.getText().toString().contains(".")) {
                        dot.setEnabled(false);
                    } else {
                        dot.setEnabled(true);
                    }
                }
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
        plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double ops = Double.parseDouble(String.valueOf(result.getText()));
                    ops = ops * (-1);
                    result.setText(String.valueOf(ops));
                } catch (StringIndexOutOfBoundsException | NumberFormatException e) {

                }
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = number2.size();
                String text = "";
                int x = 2;
                for (int i = 0; i != n; i++) {
                    if (i == x) {
                        text = text.concat("\n\n");
                        x = x + 2;
                    }
                    text = text.concat("" + number2.get(i));
                }
                    if(text.contains("×")){
                        text=text.replace("×","*");
                    }
                    if(text.contains("÷")){
                        text=text.replace("÷","/");
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("data", text);

                    twoFra ff = new twoFra();
                    ff.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            ff).commit();

                }


                //Toast.makeText(getContext(), ""+text, Toast.LENGTH_LONG).show();
                /*int i = JOptionPane.showConfirmDialog(this, text + "\n\n\n" + "Are you want to Delete History?", "Confim message", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    number2.clear();
                } else {

                }*/
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttn_numberclick(divide.getText().toString());
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttn_numberclick(multi.getText().toString());
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttn_numberclick(sub.getText().toString());
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttn_numberclick(add.getText().toString());
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttn_numberclick(equal.getText().toString());
            }
        });

        module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttn_numberclick(module.getText().toString());
            }
        });






        return view;

    }
    void numberClickmethod(String ss){
        counter3=0;
        if(result.getText().toString().contains(".")){

        }
        else if(Double.parseDouble(result.getText().toString())<=0.0){
            result.setText("");
            String nump = ss;
            if(nump.contains(".")){
                result.setText("0");
            }
        }
            counter2++;
            if (bttnType.equals("opr")) {
                result.setText("");
            }
        if(result.getText().length()>=16){
            Toast.makeText(getContext(), "Maximum 16 digits are acceptable.", Toast.LENGTH_SHORT).show();
        }
        else {
            String num = ss;
            String oldnum = result.getText().toString();

            result.setText(oldnum + num);

            bttnType = "num";
            counter = 0;
            String numTEs = result.getText().toString();
            if (numTEs.contains(".")) {
                dot.setEnabled(false);
            }
        }
    }
    void bttn_numberclick(String rr){
        dot.setEnabled(true);
        try {
            bttnType = "opr";
            counter++;
            String opr =rr;
            if (counter == 1) {
                String str = value.getText().toString() + result.getText().toString() + opr;

                value.setText(str);

                number.add(Float.valueOf(result.getText().toString()));
                if (number.size() == 2) {
                    num1 = number.get(0);
                    num2 = number.get(1);
                    number.clear();

                    if (oldOperator.equals("+")) {
                        ans = num1 + num2;
                    } else if (oldOperator.equals("-")) {
                        ans = num1 - num2;
                    } else if (oldOperator.equals("×")) {
                        ans = num1 * num2;
                    } else if (oldOperator.equals("÷")) {
                        ans = num1 / num2;
                    }
                    else if (oldOperator.equals("%")) {
                        ans = (num1*num2)/100;
                    }
                    number.add(ans);
                    result.setText(ans + "");
                }

                oldOperator = opr;
                if (opr.equals("=")) {
                    number2.add(value.getText().toString());
                    number2.add(result.getText().toString());
                    value.setText("");
                    number.clear();
                    counter=0;
                    counter3=1;

                }
            } else {
                String str = value.getText().toString();
                String str1 = str.substring(0, str.length() - 1);
                value.setText(str1 + opr);

                oldOperator = opr;
            }
            counter2 = 0;
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {

        }
    }
}
