package com.example.mycalculator;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class add_subtract_c extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    DatePickerDialog.OnDateSetListener setListener1;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText eyear,emonth,eday;
    TextView date_show,result;
    Button button1,button2;
    int x=0;
    int a=0;
    int b=0;
    int c=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.add_subtract,container,false);

        spinner=view.findViewById(R.id.spinnerID2);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),R.array.spinner_items2,R.layout.colorspinner);

        adapter.setDropDownViewResource(R.layout.spinnercolor_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        date_show=view.findViewById(R.id.date1id_add);
        eyear=view.findViewById(R.id.year_edId);
        emonth=view.findViewById(R.id.month_edID);
        eday=view.findViewById(R.id.day_edID);
        result=view.findViewById(R.id.showdateid_add);

        button1=view.findViewById(R.id.addbutton);
        button2=view.findViewById(R.id.subbutton);

       Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        String date=simpleDateFormat.format(Calendar.getInstance().getTime());

        date_show.setText(date);

        result.setText(date);

        eyear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                eyear.setText("");
                return false;
            }
        });
        emonth.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                emonth.setText("");
                return false;
            }
        });
        eday.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                eday.setText("");
                return false;
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eday.getText().toString().isEmpty()){
                    eday.setText("0");
                }
                if(emonth.getText().toString().isEmpty()){
                    emonth.setText("0");
                }
                if(eyear.getText().toString().isEmpty()){
                    eyear.setText("0");
                }
                a=Integer.parseInt(eday.getText().toString());
                b=Integer.parseInt(emonth.getText().toString());
                c=Integer.parseInt(eyear.getText().toString());
                if(eday.getText().toString().isEmpty()){
                    a=0;
                }
                else if(emonth.getText().toString().isEmpty()){
                    b=0;
                }
                else if(eyear.getText().toString().isEmpty()){
                    c=0;
                }else{
                addday(a,b,c);}

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eday.getText().toString().isEmpty()){
                    eday.setText("0");
                }
                if(emonth.getText().toString().isEmpty()){
                    emonth.setText("0");
                }
                if(eyear.getText().toString().isEmpty()){
                    eyear.setText("0");
                }
                a=Integer.parseInt(eday.getText().toString());
                b=Integer.parseInt(emonth.getText().toString());
                c=Integer.parseInt(eyear.getText().toString());
                if(eday.getText().toString().isEmpty()){
                    a=0;
                }
                else if(emonth.getText().toString().isEmpty()){
                    b=0;
                }
                else if(eyear.getText().toString().isEmpty()){
                    c=0;
                }else{
                    addday((-a),(-b),(-c));}

            }
        });

       /* radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addday((-a),(-b),(-c));
            }
        });*/
        /*radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(radioGroup.getCheckedRadioButtonId()==-1){

                }
                else if(radioGroup.getCheckedRadioButtonId()==R.id.addradio){
                    addday(a,b,c);
                }
                else if(radioGroup.getCheckedRadioButtonId()==R.id.subradio){
                    addday((-a),(-b),(-c));
                }
            }
        });*/


        return view;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position==1){
            date_calculation ff = new date_calculation();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    ff).commit();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
   void addday(int n,int n2,int n3){
        DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,n);
        cal.add(Calendar.MONTH,n2);
        cal.add(Calendar.YEAR,n3);
        String result_fubd=dateFormat.format(cal.getTime());
        result.setText(result_fubd);

    }
}
