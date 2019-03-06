package com.itshareplus.googlemapdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String message = intent.getStringExtra("data");

        textView = (TextView) findViewById(R.id.tv_Result);

        if (message.equals("1")){
            textView.setText("Anda Boleh Jamak Dan Qasar Sepanjang Perjalanan Anda");
        }
        else if (message.equals("2")){
            textView.setText("Anda Boleh Jamak Dan Qasar Semasa Perjalanan Pergi Dan Perjalanan Pulang Sahaja");
        }
    }

    public void returnPage(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
