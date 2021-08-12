package com.example.mycalculator;

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

public class programmer extends Fragment {
    ArrayList<Float> number = new ArrayList<>();
    ArrayList<String> number2 = new ArrayList<>();
    Float num1, num2, ans;
    String oldOperator = "";
    int counter = 0;
    int counter2 = 0,counter3=0;
    String d;

    String bttnType = "";

    private TextView value,result,dec,bin,oct,hex;
    private ImageButton history,clear;
    private Button ac,module,divide,seven,eight,nine,one,two,three,four,five,six,multi,sub,add,equal,zero,dot,plus_minus;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.programmer_cal,container,false);

        dec=view.findViewById(R.id.decimal_txt);
        bin=view.findViewById(R.id.binary_txt);
        oct=view.findViewById(R.id.octal_txt);
        hex=view.findViewById(R.id.hexa_txt);

        value=view.findViewById(R.id.valutxt_prog);
        result=view.findViewById(R.id.resultTxt_prog);
        ac=view.findViewById(R.id.prog_btu1);
        clear=view.findViewById(R.id.prog_btu2);
        module=view.findViewById(R.id.prog_btu3);
        divide=view.findViewById(R.id.prog_btu4);
        seven=view.findViewById(R.id.prog_btu5);
        eight=view.findViewById(R.id.prog_btu6);
        nine=view.findViewById(R.id.prog_btu7);
        multi=view.findViewById(R.id.prog_btu8);
        four=view.findViewById(R.id.prog_btu9);
        five=view.findViewById(R.id.prog_btu10);
        six=view.findViewById(R.id.prog_btu11);
        sub=view.findViewById(R.id.prog_btu12);
        one=view.findViewById(R.id.prog_btu13);
        two=view.findViewById(R.id.prog_btu14);
        three=view.findViewById(R.id.prog_btu15);
        add=view.findViewById(R.id.prog_btu16);
        plus_minus=view.findViewById(R.id.prog_btu17);
        zero=view.findViewById(R.id.prog_btu18);
        dot=view.findViewById(R.id.prog_btu19);
        equal=view.findViewById(R.id.prog_btu20);

        result.setText("0");
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText("");
                result.setText("0");
                dec.setText("DEC        0");
                bin.setText("BIN         0");
                oct.setText("OCT        0");
                hex.setText("HEX        0");
                number.clear();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter3==1){
                    result.setText("0");
                    counter3=0;
                }
                else {
                    String str = result.getText().toString();
                    if (str.length() > 0) {
                        String str1 = str.substring(0, str.length() - 1);
                        result.setText(str1);
                    }
                    if (str.length() == 1) {
                        result.setText("0");
                    }
                }

                int x=Integer.parseInt(result.getText().toString());

                dec.setText("DEC        "+x);
                bin.setText("BIN         "+Integer.toBinaryString(x));
                oct.setText("OCT        "+Integer.toOctalString(x));
                hex.setText("HEX        "+Integer.toHexString(x));
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
                Toast.makeText(getContext(), "Dot is disabled here", Toast.LENGTH_SHORT).show();
            }
        });
        plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double ops = Double.parseDouble(String.valueOf(result.getText()));
                    ops = ops * (-1);
                    result.setText(String.valueOf(ops));
                    int re=0;
                    String s=result.getText().toString();
                    if(s.contains(".")){
                        re=s.indexOf(".");
                    }
                    int x=Integer.parseInt(result.getText().toString().substring(0,re));

                    dec.setText("DEC        "+x);
                    bin.setText("BIN         "+Integer.toBinaryString(x));
                    oct.setText("OCT        "+Integer.toOctalString(x));
                    hex.setText("HEX        "+Integer.toHexString(x));
                } catch (StringIndexOutOfBoundsException | NumberFormatException e) {

                }
            }
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


        //last line onCreateView

        return view;

    }

    void numberClickmethod(String ss){
        counter3=0;
                    if(Double.parseDouble(result.getText().toString())<=0.0){
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
            if(result.getText().length()>=8){
                Toast.makeText(getContext(), "Maximum 8 digits are acceptable.", Toast.LENGTH_SHORT).show();
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

                int x = Integer.parseInt(result.getText().toString());

                dec.setText("DEC        " + x);
                bin.setText("BIN         " + Integer.toBinaryString(x));
                oct.setText("OCT        " + Integer.toOctalString(x));
                hex.setText("HEX        " + Integer.toHexString(x));
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

                    if(ans<1){
                        dec.setText("DEC        0");
                        bin.setText("BIN         0");
                        oct.setText("OCT        0");
                        hex.setText("HEX        0");
                        Toast.makeText(getContext(), "All value are 0 for this result.", Toast.LENGTH_SHORT).show();
                    }
                    else {int re=0;
                        String s=result.getText().toString();
                       if(s.contains(".")){
                            re=s.indexOf(".");
                       }
                        int x=Integer.parseInt(result.getText().toString().substring(0,re));

                        dec.setText("DEC        "+x);
                        bin.setText("BIN         "+Integer.toBinaryString(x));
                        oct.setText("OCT        "+Integer.toOctalString(x));
                        hex.setText("HEX        "+Integer.toHexString(x));}
                    Toast.makeText(getContext(), "Only Integer value has been used.", Toast.LENGTH_SHORT).show();

                }

                oldOperator = opr;
                if (opr.equals("=")) {
                    number2.add(value.getText().toString());
                    number2.add(result.getText().toString());
                    value.setText("");
                    number.clear();
                    counter=0;


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
        counter3=1;
    }
}
