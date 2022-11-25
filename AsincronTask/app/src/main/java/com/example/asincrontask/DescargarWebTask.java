package com.example.asincrontask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.asincrontask.net.NetUtils;

public class DescargarWebTask extends AsyncTask<String, Integer, String> {

    private Activity activity;

    private ProgressDialog dialog;

    public DescargarWebTask (Activity activity){
        this.activity = activity;
        dialog = new ProgressDialog(activity);
        dialog.setCancelable(false);
        dialog.setMessage("Descargando pagina ...");

    }

    // Para actualizar la vista
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        TextView tv = activity.findViewById(R.id.lbl_html);
        tv.setText("" + values[0]);
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        dialog.show();
    }
    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);
        dialog.dismiss();
        TextView tv = activity.findViewById(R.id.lbl_html);
        tv.setText(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        String html = "";
        publishProgress(50);
        try {
            Thread.sleep(2000);
            html = NetUtils.getURLText(strings[0]);
            Log.i("DescargarWebTask", html);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;
    }
}
