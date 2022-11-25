package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(this,"Creando actividad",Toast.LENGTH_SHORT);
        toast.show();

        Button btn_1 = this.findViewById(R.id.button1);
        TextView text = this.findViewById(R.id.lay_1);
        EditText editText = this.findViewById(R.id.txt_input_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Pulsando el boton",Toast.LENGTH_SHORT).show();
                count++;
                String str = "Contador : " + count;
                text.setText(str);
                String text = editText.getText().toString();
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Comenzando actividad",Toast.LENGTH_SHORT).show();
    }
}