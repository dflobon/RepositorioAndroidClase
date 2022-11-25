package com.example.jobs.util;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

public class MyJobScheduler {

    public static void schedulePeriodicJob(Context ctx){
        ComponentName miServicio = new ComponentName(ctx, MyTestJob.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, miServicio);
        builder.setMinimumLatency(3000);
        builder.setOverrideDeadline(3000);
        JobScheduler scheduler = ctx.getSystemService(JobScheduler.class);
        scheduler.schedule(builder.build());
    }
}
