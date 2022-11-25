package com.example.asincrontask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.btn_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DescargarWebTask task = new DescargarWebTask(MainActivity.this);
                //task.execute("https://www.google.es");
                DescargarWebThread descargarWebThread = new DescargarWebThread(MainActivity.this, "https://google.es");
                Thread th = new Thread(descargarWebThread);
                th.start();
            }
        });
    }
}