package com.example.proyectosqlite.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.proyectosqlite.Model.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetManagerDB {
    public static List<Planet> getAll(PlanetDatabaseHelper planetDatabaseHelper) {
        SQLiteDatabase dbConnetion = planetDatabaseHelper.getReadableDatabase();
        Cursor c = dbConnetion.rawQuery("SELECT * FROM planetas;",null);
        List<Planet> result = new ArrayList<>();
        c.moveToFirst();
        while (!c.isAfterLast()){
            Planet p = new Planet(c.getString(0),c.getInt(1), c.getInt(2));
            result.add(p);
            c.moveToNext();
        }
        return result;
    }
}
