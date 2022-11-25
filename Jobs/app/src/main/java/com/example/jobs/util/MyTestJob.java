package com.example.jobs.util;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class MyTestJob  extends JobService {
    static int i = 0;
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.i("MyTestJob", "Ejecutando servicio " + i++);
        MyJobScheduler.schedulePeriodicJob(this);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
