package com.example.primerejerciciotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button botonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonGuardar = findViewById(R.id.buttonGuardar);

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarpreferencias();
            }
        });
    }

    private void guardarpreferencias() {
        // Guardar preferencias, animal
        SharedPreferences settings = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("mi_animal", "Perro");
        editor.commit();
        //Recuperacion de preferencias
        String animal = settings.getString("mi_animal","");
        Toast.makeText(getApplicationContext(), animal, Toast.LENGTH_SHORT).show();
    }
}