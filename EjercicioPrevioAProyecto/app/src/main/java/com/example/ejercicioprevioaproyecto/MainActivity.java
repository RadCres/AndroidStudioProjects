package com.example.ejercicioprevioaproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
            Intent intent = new Intent(v.getContext(),MainActivityConsultar.class);
            startActivity(intent);
            Consultar consultar = new Consultar(MainActivityConsultar.class);
        });
        botonInsertar.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(),MainActivityInsertar.class);
            startActivity(intent);
        });
    }

    @Override
    public void onTaskCompleted(String s) {
        Toast.makeText(MainActivity.this, "Resultado: "+s, Toast.LENGTH_SHORT).show();
    }
}