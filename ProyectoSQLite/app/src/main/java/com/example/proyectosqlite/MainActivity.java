package com.example.proyectosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.proyectosqlite.Model.Planet;
import com.example.proyectosqlite.database.PlanetDatabaseHelper;
import com.example.proyectosqlite.database.PlanetManagerDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PlanetDatabaseHelper dbHelper;
    private List<Planet> planetList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new PlanetDatabaseHelper(this);

        ListView lst = findViewById(R.id.list_planetas);
        lst.setAdapter(new ArrayAdapter<Planet>(this, android.R.layout.simple_list_item_1, planetList));

        Button btn = findViewById(R.id.btn_sql);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new UpdateUIPlanetsFromDB(planetList, MainActivity.this, dbHelper);
                ((ArrayAdapter)lst.getAdapter()).notifyDataSetChanged();
            }
        });

    }
}