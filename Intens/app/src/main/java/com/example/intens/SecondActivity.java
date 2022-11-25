package com.example.intens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String etiqueta = getIntent().getStringExtra(MainActivity.PARAMETRO_INTENT_1);
    }
}