package com.example.proyectosqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectosqlite.MainActivity;

public class PlanetDatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION_BASE_DATOS = 1;
    private static final String NOMBRE_BASE_DATOS = "db_planetas.sqlite";


    public PlanetDatabaseHelper(@Nullable Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE planetas (nombre TEXT, diametro INT, gravedad INT);");
        sqLiteDatabase.execSQL("INSERT INTO planetas (nombre, diametro, gravedad) values ('Tierra', 123456, -9.8)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
