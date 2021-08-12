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

public class scientific extends Fragment {
    ArrayList<Float> number = new ArrayList<>();
    ArrayList<String> number2 = new ArrayList<>();
    Float num1, num2, ans;
    String oldOperator = "";
    int counter = 0;
    int counter2 = 0,counter3=0;
    int kp;
    String po,po2,po3;

    String bttnType = "";

    private TextView value,result;
    private ImageButton history,clear;
    private Button ac,module,divide,seven,eight,nine,one,two,three,four,five,six,multi,sub,add,equal,zero,dot,plus_minus,factorial,power,pi,mod;
    private Button root,braket1,breket2,sin_inverse,cos_inverse,tan_inverse,sin,cos,tan,log,e;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.scientific_cal,container,false);

        //declaration_id

        value=view.findViewById(R.id.valutxt_scientific);
        result=view.findViewById(R.id.resultTxt_scientific);
        ac=view.findViewById(R.id.btn_scientific1);
        clear=view.findViewById(R.id.btn_scientific2);
        module=view.findViewById(R.id.btn_scientific3);
        divide=view.findViewById(R.id.btn_scientific4);
        seven=view.findViewById(R.id.btn_scientific5);
        eight=view.findViewById(R.id.btn_scientific6);
        nine=view.findViewById(R.id.btn_scientific7);
        multi=view.findViewById(R.id.btn_scientific8);
        four=view.findViewById(R.id.btn_scientific9);
        five=view.findViewById(R.id.btn_scientific10);
        six=view.findViewById(R.id.btn_scientific11);
        sub=view.findViewById(R.id.btn_scientific12);
        one=view.findViewById(R.id.btn_scientific13);
        two=view.findViewById(R.id.btn_scientific14);
        three=view.findViewById(R.id.btn_scientific15);
        add=view.findViewById(R.id.btn_scientific16);
        plus_minus=view.findViewById(R.id.btn_scientific17);
        zero=view.findViewById(R.id.btn_scientific18);
        dot=view.findViewById(R.id.btn_scientific19);
        equal=view.findViewById(R.id.btn_scientific20);
        factorial=view.findViewById(R.id.st_factorial);
        power=view.findViewById(R.id.st_power);
        pi=view.findViewById(R.id.st_pi);
        mod=view.findViewById(R.id.st_mod);
        root=view.findViewById(R.id.st_root);
        braket1=view.findViewById(R.id.st_brackt1);
        breket2=view.findViewById(R.id.st_brackt2);
        sin=view.findViewById(R.id.st_sin);
        cos=view.findViewById(R.id.st_cos);
        tan=view.findViewById(R.id.st_tan);
        sin_inverse=view.findViewById(R.id.st_sin_inverse);
        cos_inverse=view.findViewById(R.id.st_cos_inverse);
        tan_inverse=view.findViewById(R.id.st_tan_inverse);

        result.setText("0");

        log=view.findViewById(R.id.st_bt_log);
        e=view.findViewById(R.id.st_btn_e);

        //logical work_start (on click)

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText("");
                result.setText("0");
                kp=0;
                number.clear();
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
        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=1;
                scientific_logic();

            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=2;
                scientific_logic();

            }
        });

        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=3;
                scientific_logic();

            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=4;
                scientific_logic();

            }
        });
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=5;
                scientific_logic();

            }
        });
        braket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=6;
                scientific_logic();

            }
        });
        breket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=7;
                scientific_logic();

            }
        });
        sin_inverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=8;
                scientific_logic();

            }
        });
        cos_inverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=9;
                scientific_logic();

            }
        });
        tan_inverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=10;
                scientific_logic();

            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=11;
                scientific_logic();

            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=12;
                scientific_logic();

            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=13;
                scientific_logic();

            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=14;
                scientific_logic();


            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kp=15;
                scientific_logic();

            }
        });


        //last onclick listener

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
        if(result.getText().length()>=14){
            Toast.makeText(getContext(), "Maximum 14 digits are acceptable.", Toast.LENGTH_SHORT).show();
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
    void scientific_logic(){
try {
    if (kp == 1) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains(".") || result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter Integer number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else if (result.getText().length() >= 8) {
            Toast.makeText(getContext(), "Maximum 8 digits are acceptable for this method.", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            int p = Integer.parseInt(result.getText().toString());
            value.setText("Fact(" + p + ")");
            double tt2 = 0, pp2 = 1;
            while (tt2 != p) {
                tt2 = tt2 + 1;
                pp2 = pp2 * tt2;
            }
            String sr = "" + pp2;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);
            kp = 0;
        }
    }
    if (kp == 2) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText(result.getText().toString() + "^");
            po = result.getText().toString();
            result.setText("0");
        }
    }
    if (kp == 3) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            double p2 = Double.parseDouble(result.getText().toString());
            value.setText(p2 + " × 3.1416");
            p2 = p2 * 3.1416;

            result.setText(Double.toString(p2));
            kp = 0;
        }
    }
    if (kp == 4) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText(result.getText().toString() + " Mod ");
            po2 = result.getText().toString();
            result.setText("0");
        }
    }
    if (kp == 5) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText("√( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = Math.sqrt(d_value);
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);
            kp = 0;
        }
    }
    if (kp == 6) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText("sqr( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = d_value * d_value;
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);
            kp = 0;
        }
    }
    if (kp == 7) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText("1/( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = 1 / d_value;
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);
            kp = 0;
        }
    }
    if (kp == 8) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {

            value.setText("sin¯¹( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = Math.sin(1 / d_value);
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);
            kp = 0;
        }
    }
    if (kp == 9) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {

            value.setText("cos¯¹( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = Math.cos(1 / d_value);
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);
            kp = 0;
        }
    }
    if (kp == 10) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText("tan¯¹( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = Math.tan(1 / d_value);
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);
            kp = 0;
        }
    }
    if (kp == 11) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText("sin( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = Math.sin(d_value);
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);
            kp = 0;
        }
    }
    if (kp == 12) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText("cos( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = Math.cos(d_value);
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);
            kp = 0;
        }
    }
    if (kp == 13) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText("tan( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = Math.tan(d_value);
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);
            kp = 0;
        }
    }
    if (kp == 14) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText("e( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = Math.E * d_value;
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);

            kp = 0;
        }
    }
    if (kp == 15) {
        if (result.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Firstly, Enter value.", Toast.LENGTH_SHORT).show();
        } else if (result.getText().toString().contains("Infinity")) {
            Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
            result.setText("0");
            value.setText("");

        } else {
            value.setText("log( " + result.getText().toString() + " )");
            double d_value = Double.parseDouble(result.getText().toString());
            d_value = Math.log10(d_value);
            String sr = "" + d_value;
            if (sr.length() > 12) {
                sr = sr.substring(0, 12);
            }
            result.setText(sr);

            kp = 0;
        }

    }
}catch (Exception ex){
    Toast.makeText(getContext(), "Invalid Operation.", Toast.LENGTH_SHORT).show();
    value.setText("");
    result.setText("0");
}


    //last code



    }

    void bttn_numberclick(String rr){
        dot.setEnabled(true);
        try {
            if(kp==2){
                value.setText(value.getText().toString()+result.getText());
                double tt=0,pp=1;
                double dr=Double.parseDouble(po);
                if(result.getText().toString().contains(".")){
                    Toast.makeText(getContext(), "Enter Integer number", Toast.LENGTH_SHORT).show();
                    result.setText("");
                }
                else{
                    int loop_value=Integer.parseInt(result.getText().toString());
                while(tt!=loop_value){
                    tt=tt+1;
                    pp=pp*dr;
                }
                result.setText(Double.toString(pp));
                    kp=0;
                }

            }
            else if(kp==4){
                double tt;
                double pp=Double.parseDouble(result.getText().toString());
                value.setText(value.getText().toString().concat(result.getText().toString()));
                double dr=Double.parseDouble(po2);

                    tt=dr%pp;
                    result.setText(Double.toString(tt));
                    kp=0;

            }
            else{

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
        } }catch (StringIndexOutOfBoundsException | NumberFormatException e) {

        }
    }
}
