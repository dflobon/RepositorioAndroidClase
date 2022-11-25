package com.example.planetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadPlanetListThread downloadPlanetListThread = new DownloadPlanetListThread();
        Thread th = new Thread(downloadPlanetListThread);
        th.start();

    }
}