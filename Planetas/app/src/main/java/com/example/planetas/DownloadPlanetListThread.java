package com.example.planetas;

import android.util.Log;

import com.example.planetas.model.Planeta;
import com.example.planetas.net.NetUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DownloadPlanetListThread implements Runnable{
    public DownloadPlanetListThread(){}
    @Override
    public void run() {
        try {
            String jsonStringList = NetUtils.getURLText("http://sanger.dia.fi.upm.es/pmd-task/public/list-example/planets.php");
            Log.i("DownloadPlanetListThread",jsonStringList);
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            List<Planeta> planetas = Arrays.asList(gson.fromJson(jsonStringList, Planeta[].class));
            for (Planeta p : planetas){
                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url = "http://sanger.dia.fi.upm.es/pmd-task/public/list-example/" + p.getImagePath();
                        try {
                            p.setFoto(NetUtils.getUrlImage(url));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
                th.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
