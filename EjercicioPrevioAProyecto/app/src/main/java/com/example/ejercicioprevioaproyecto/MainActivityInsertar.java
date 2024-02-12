package com.example.ejercicioprevioaproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityInsertar extends AppCompatActivity {
    private EditText dni, nombre, email, telefono;
    private Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        dni = findViewById(R.id.editTextDNI);
        nombre = findViewById(R.id.editTextNombre);
        email = findViewById(R.id.editTextEmail);
        telefono = findViewById(R.id.editTextTelefono);
        guardar = findViewById(R.id.buttonGuardar);

        guardar.setOnClickListener(v -> {

        });
    }
}