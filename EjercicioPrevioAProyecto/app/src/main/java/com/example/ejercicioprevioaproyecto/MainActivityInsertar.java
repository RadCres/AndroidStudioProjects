package com.example.ejercicioprevioaproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

            //String con los datos a enviar
            try {
                String datos = "dni=" + URLEncoder.encode(dni.getText().toString(),"UTF-8")+
                        "&"+"email="+URLEncoder.encode(email.getText().toString(),"UTF-8")+
                        "&"+"nombre"+URLEncoder.encode(nombre.getText().toString(),"UTF-8")+
                        "&"+"telefono"+URLEncoder.encode(telefono.getText().toString(),"UTF-8");
                Insertar insertar = new Insertar();
                insertar.execute(datos);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

        });
    }
}