package com.example.layaoutproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> datos = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            datos.add("" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        ListView listView = findViewById(R.id.list_view);
        Button button1 = findViewById(R.id.btn_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text = findViewById(R.id.et_1);
                String str = text.getText().toString();
                if (!str.trim().equals("")){
                    datos.add(str);
                    text.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                datos.remove(i);
                ((ArrayAdapter)((ListView) adapterView).getAdapter()).notifyDataSetChanged();
            }
        });
        // Ejemplo Spinner
        Spinner spinner = findViewById(R.id.spin_paises);
        String [] string_paises = getResources().getStringArray(R.array.paises);
        ArrayAdapter<String> spinerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, string_paises);
        spinner.setAdapter(spinerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("SeleccionPaises", "Has seleccionado la etiqueta: " + string_paises[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.i("SeleccionPaises", "No hay ninguno seleccionado");
            }
        });
    };

}