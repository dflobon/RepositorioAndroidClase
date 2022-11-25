package com.example.sharedprepared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final String NOMBRE_ATRIBUTO_CAJA = "texto_caja";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String NOMBRE_PREFERENCIAS_TEXTO_CAJA = "fichero";
        SharedPreferences sharedPreferences = getSharedPreferences(NOMBRE_PREFERENCIAS_TEXTO_CAJA, Context.MODE_PRIVATE);
        String valor_prefencia = sharedPreferences.getString(NOMBRE_ATRIBUTO_CAJA,"");
        EditText editText = findViewById(R.id.editText_1);
        editText.setText(valor_prefencia);
        Button btn = findViewById(R.id.btn_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                EditText editText = findViewById(R.id.editText_1);
                editor.putString(NOMBRE_ATRIBUTO_CAJA,editText.getText().toString());
                editor.apply();
            }
        });
        btn = findViewById(R.id.btn_2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(Environment.getExternalStorageState(), Environment.MEDIA_MOUNTED)) {
                    File path = Environment.getDataDirectory();
                    File file = new File(path.getAbsolutePath() + "/fichero.txt");
                    try {
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
                        outputStreamWriter.write(valor_prefencia);
                        outputStreamWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        });
    }
}