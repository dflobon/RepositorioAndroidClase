package com.example.proyectosqlite;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.proyectosqlite.Model.Planet;
import com.example.proyectosqlite.database.PlanetDatabaseHelper;
import com.example.proyectosqlite.database.PlanetManagerDB;

import java.util.ArrayList;
import java.util.List;

public class UpdateUIPlanetsFromDB implements Runnable{

    private List<Planet> planetList = new ArrayList<>();
    private MainActivity mainActivity;
    private PlanetDatabaseHelper dbHelper;
    public UpdateUIPlanetsFromDB (List<Planet> planetList, MainActivity mainActivity, PlanetDatabaseHelper dbHelper){
        this.planetList = planetList;
        this.mainActivity = mainActivity;
        this.dbHelper = dbHelper;
    }
    @Override
    public void run() {
        planetList.clear();
        planetList.addAll(PlanetManagerDB.getAll(dbHelper));
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
        Log.i("SQLQuery", "Size: "+ planetList.size());
    }
}
