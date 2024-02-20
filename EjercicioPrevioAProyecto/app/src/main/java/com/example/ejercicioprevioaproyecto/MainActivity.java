package com.example.ejercicioprevioaproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TaskCompleted{
    private Button botonInsertar, botonConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonConsultar = findViewById(R.id.buttonConsultar);
        botonInsertar = findViewById(R.id.buttonInsertar);

        botonConsultar.setOnClickListener(v -> {
//            Intent intent = new Intent(v.getContext(),MainActivityConsultar.class);
//            startActivity(intent);

            Log.i("Test", "listener activo ");
            Consultar consultar = new Consultar(MainActivity.this);
            consultar.execute();
        });
        botonInsertar.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(),MainActivityInsertar.class);
            startActivity(intent);
        });
    }

    @Override
    public void onTaskCompleted(String s) {
        Log.i("AAAA", "Resultado: "+s);
    }
}