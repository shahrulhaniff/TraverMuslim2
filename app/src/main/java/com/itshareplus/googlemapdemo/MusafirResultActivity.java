package com.itshareplus.googlemapdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MusafirResultActivity extends AppCompatActivity {

    TextView tarikhPergi, tarikhBaik, masaPergi, masaBalik;
    private DatePickerDialog.OnDateSetListener mDateSetListerner, mDateSetListerner2;
    String masa1, masa2;
    Date tarikh1,tarikh2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musafirresult);

        tarikhPergi = (TextView) findViewById(R.id.tv_tarikhPergi);
        tarikhBaik = (TextView) findViewById(R.id.tv_tarikhBalik);

        masaPergi = (TextView) findViewById(R.id.tv_masaPergi);
        masaBalik = (TextView) findViewById(R.id.tv_masaBalik);

        mDateSetListerner = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String date = day + "/" + month + "/" + year;
                try {
                    tarikh1 = sdf.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tarikhPergi.setText(date);
            }
        };

        mDateSetListerner2 = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String date = day + "/" + month + "/" + year;
                try {
                    tarikh2 = sdf.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tarikhBaik.setText(date);
            }
        };
    }

    public void setTarikhPergi(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(MusafirResultActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListerner,
                year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
        dialog.show();
    }

    public void setTarikhBalik(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(MusafirResultActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListerner2,
                year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
        dialog.show();
    }

    public void setMasaPergi(View view) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(android.widget.TimePicker timePicker, int hour, int minutes) {
                masaPergi.setText(String.format("%02d:%02d", hour, minutes));
                masa1 = masaPergi.getText().toString();
            }
        }, hour, minute, true);

        timePickerDialog.show();
    }

    public void setMasaBalik(View view) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(android.widget.TimePicker timePicker, int hour, int minutes) {
                masaBalik.setText(String.format("%02d:%02d", hour, minutes));
                masa2 = masaBalik.getText().toString();
            }
        }, hour, minute, true);

        timePickerDialog.show();
    }

    public void checkDateTime(View view) {

        if (tarikhPergi.getText().toString().equals("Select Date") || tarikhBaik.getText().toString().equals("Select Date") ) {
            Toast.makeText(this, "Please Enter Your Date", Toast.LENGTH_LONG).show();
        }
        else if(masaPergi.getText().toString().equals("Select Time") || masaBalik.getText().toString().equals("Select Time") ){
            Toast.makeText(this, "Please Enter Your Travel Time", Toast.LENGTH_LONG).show();
        }
        else{
            String dateStart = tarikhPergi.getText().toString()+" "+masa1;
            String dateStop = tarikhBaik.getText().toString()+" "+masa2;

            Date date1 =  null, date2 = null;

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            try {
                date1 = format.parse(dateStart);
                date2 = format.parse(dateStop);

                //in milliseconds
                long diff = date2.getTime() - date1.getTime();

                long diffHour = diff / ( 60 * 60 * 1000); //jam
                long diffMinutes = diff / (60 * 1000) % 60; //minit

                if ((diffHour-24) <= 84){
                    Intent intent = new Intent(this, Result.class);
                    intent.putExtra("data", "1");
                    startActivity(intent);
                    //Toast.makeText(this, "You Can Jamak Dan Qasar On Your Travel", Toast.LENGTH_LONG).show();
                }
                else if ((diffHour-24) > 84){
                    Intent intent = new Intent(this, Result.class);
                    intent.putExtra("data", "2");
                    startActivity(intent);
                    //Toast.makeText(this, "You Can Jamak Dan Qasar While Traveling And Returning Travel Only", Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
