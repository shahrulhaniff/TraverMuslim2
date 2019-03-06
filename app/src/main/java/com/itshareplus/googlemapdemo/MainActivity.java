package com.itshareplus.googlemapdemo;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton imgBtnTravelMuslim = (ImageButton) findViewById(R.id.imgBtnTravelMuslim);
        ImageButton imgBtnHalalRes = (ImageButton) findViewById(R.id.imgBtnHalalRes);

        imgBtnTravelMuslim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTravelMuslim();
            }
        });
        imgBtnHalalRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHalalRes();
            }
        });
    }

    public void goTravelMuslim(){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void goHalalRes(){
        Intent intent = new Intent(this, HalalRestaurant.class);
        startActivity(intent);
    }
}
