package com.example.mycalculator;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date_calculation extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextView getdate1,getdate2,result;

    DatePickerDialog.OnDateSetListener setListener1,setListener2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.date_calculation_cal,container,false);

        spinner=view.findViewById(R.id.spinnerID);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),R.array.spinner_items,R.layout.colorspinner);

        adapter.setDropDownViewResource(R.layout.spinnercolor_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        getdate1=view.findViewById(R.id.date1id);
        getdate2=view.findViewById(R.id.date2id);
        result=view.findViewById(R.id.showdateid);

        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);


        /*Date currenttime=Calendar.getInstance().getTime();
        String formateddate= DateFormat.getDateInstance(DateFormat.FULL).format(currenttime);

        String[] spiltdate=formateddate.split(",");

        final String fday_name=spiltdate[0].trim();
        final String fmonth=spiltdate[1].trim();
        final String fday=spiltdate[2].trim();
        final String fyear=spiltdate[3].trim();*/

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        String date=simpleDateFormat.format(Calendar.getInstance().getTime());

        getdate1.setText(date);
        getdate2.setText(date);

        getdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        getContext()
                        ,android.R.style.Theme_Holo_Dialog_MinWidth
                        ,setListener1,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new
                        ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener1=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date=""+day+"-"+month+"-"+year;
                getdate1.setText(date);

                String sDate=getdate1.getText().toString();
                String eDate=getdate2.getText().toString();
                SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date1=simpleDateFormat1.parse(sDate);
                    Date date2=simpleDateFormat1.parse(eDate);
                    long startdate=date1.getTime();
                    long enddate=date2.getTime();


                    if(startdate<=enddate){
                        org.joda.time.Period period=new org.joda.time.Period(startdate,enddate, PeriodType.yearMonthDay());
                        int years=period.getYears();
                        int months=period.getMonths();
                        int days=period.getDays();

                        result.setText(years+" Years || "+months+" Months || "+days+" Days");
                    }
                    else{
                        Toast.makeText(getContext(), "Birth Date should not be larger than today's Date. ", Toast.LENGTH_SHORT).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        };

        getdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        getContext()
                        ,android.R.style.Theme_Holo_Dialog_MinWidth
                        ,setListener2,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new
                        ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener2=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date=""+day+"-"+month+"-"+year;
                getdate2.setText(date);

                String sDate=getdate1.getText().toString();
                String eDate=getdate2.getText().toString();
                SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date1=simpleDateFormat1.parse(sDate);
                    Date date2=simpleDateFormat1.parse(eDate);
                    long startdate=date1.getTime();
                    long enddate=date2.getTime();

                    if(startdate<=enddate){
                        org.joda.time.Period period=new org.joda.time.Period(startdate,enddate, PeriodType.yearMonthDay());
                        int years=period.getYears();
                        int months=period.getMonths();
                        int days=period.getDays();

                        result.setText(years+" Years | "+months+" Months | "+days+" Days");
                    }
                    else{
                        Toast.makeText(getContext(), "Birth Date should not be larger than today's Date. ", Toast.LENGTH_SHORT).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        };



        return view;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position==1){
            add_subtract_c ff = new add_subtract_c();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    ff).commit();

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
