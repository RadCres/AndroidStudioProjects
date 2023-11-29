package com.example.examenrauldurancrespo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView nombreEdadMostrado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombreEdadMostrado = findViewById(R.id.textNombreMostrado);
        Intent intent = getIntent();
        String mensajeNombre = intent.getStringExtra("nombre");
        Intent intent2 = getIntent();
        String edad = intent2.getStringExtra("edad");

        nombreEdadMostrado.setText("Hola "+mensajeNombre+ " tienes "+ edad+ " años");
    }
}