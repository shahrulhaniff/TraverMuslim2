package com.itshareplus.googlemapdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void maklumat1(View view) {
        Intent intent =  new Intent(this, maklumat1.class);
        startActivity(intent);
    }

    public void maklumat2(View view) {
        Intent intent =  new Intent(this, maklumat2.class);
        startActivity(intent);
    }
}
