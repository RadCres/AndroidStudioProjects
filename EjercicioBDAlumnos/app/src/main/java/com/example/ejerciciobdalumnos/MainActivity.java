package com.example.ejerciciobdalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button botonInsertar;
    private Button botonConsultar;
    private Context context=this;
    private BDAdaptador bdAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdAdaptador = new BDAdaptador(getApplicationContext());
        botonInsertar = findViewById(R.id.botonInsertar);
        botonConsultar = findViewById(R.id.buttonConsultar);
        botonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        botonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdAdaptador.consultar(1);

                Toast.makeText(context, "Consultando", Toast.LENGTH_SHORT).show();
            }
        });
    }
}