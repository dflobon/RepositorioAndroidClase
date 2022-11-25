package com.example.asincrontask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.asincrontask.net.NetUtils;

public class DescargarWebThread implements Runnable{

    private Activity activity;
    private String url;
    private ProgressBar progressBar;


    public DescargarWebThread(Activity activity, String url) {
        this.activity = activity;
        this.url = url;
        this.progressBar = activity.findViewById(R.id.pb_btn_1);
    }

    @Override
    public void run() {
        String html = "";
        try {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(50);
                }
            });
            Thread.sleep(2000);
            html = NetUtils.getURLText(this.url);
            Log.i("DescargarWebTask", html);
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
