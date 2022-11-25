package com.example.intens;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public static final String PARAMETRO_INTENT_1 = "Hola";
    private static final int REQUEST_CODE_OPEN_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // TODO hacer la parte de que envie el extra al hacer el intent
                intent.putExtra(MainActivity.PARAMETRO_INTENT_1, "Hasta luego lucas");
                startActivity(intent);

            }
        });
        Button btn_llamar =findViewById(R.id.btn_llamar);
        btn_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String num = ((EditText) findViewById(R.id.edit_phone)).getText().toString();
                intent.setData(Uri.parse("tel:" + num));
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                else Toast.makeText(MainActivity.this, "No tienes instalado ninguna aplicacion para llamar",Toast.LENGTH_SHORT).show();
            }
        });
        ActivityResultLauncher<Intent> launcher =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null){
                                    try {
                                        InputStream is = getContentResolver().openInputStream(result.getData().getData());
                                        Bitmap b = BitmapFactory.decodeStream(is);
                                        ImageView iv = findViewById(R.id.img_1);
                                        iv.setImageBitmap(b);
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Acción cancelada por el usuario", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
        Button btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image/");
            //startActivityForResult(intent,REQUEST_CODE_OPEN_IMAGE);
            launcher.launch(intent);
        });
        FloatingActionButton btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "login", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "logout", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });





    }
}