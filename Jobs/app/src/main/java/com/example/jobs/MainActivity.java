package com.example.jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jobs.util.MyJobScheduler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyJobScheduler.schedulePeriodicJob(this);
    }
}