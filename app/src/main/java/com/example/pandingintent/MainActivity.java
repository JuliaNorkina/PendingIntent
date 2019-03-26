package com.example.pandingintent;

import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        findViewById(R.id.bCalculate).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    }
}
