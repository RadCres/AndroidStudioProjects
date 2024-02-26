package com.example.eventosfuturos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText usuario,contrasena;
    private Button iniciarSesion;
    private TextView contrasenaOlvidada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.editTextUsuario);
        contrasena = findViewById(R.id.editTextPassword);
        iniciarSesion = findViewById(R.id.buttonIniciarSesion);

        contrasenaOlvidada = findViewById(R.id.textViewContraseñaOlvidada);

        iniciarSesion.setOnClickListener(v -> {
            contrasenaOlvidada.setVisibility(View.INVISIBLE);
            iniciarSesion.setVisibility(View.INVISIBLE);

            //Hacer los clausulas de guarda para pasar al activity de menus
        });

    }
}