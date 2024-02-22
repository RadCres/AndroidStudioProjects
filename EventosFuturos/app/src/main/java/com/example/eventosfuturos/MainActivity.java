package com.example.eventosfuturos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText usuario,contrasena;
    private Button iniciarSesion, crearCuenta;
    private TextView contrasenaOlvidada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.editTextUsuario);
        contrasena = findViewById(R.id.editTextPassword);
        iniciarSesion = findViewById(R.id.buttonIniciarSesion);
        crearCuenta = findViewById(R.id.buttonCrearCuenta);
        contrasenaOlvidada = findViewById(R.id.textViewContraseñaOlvidada);

        crearCuenta.setOnClickListener(v -> {
            contrasenaOlvidada.setVisibility(View.INVISIBLE);
            crearCuenta.setVisibility(View.INVISIBLE);
            iniciarSesion.setText("Crear cuenta");
            //Hacer los clausulas de guarda para pasar al activity de menus
        });

    }
}