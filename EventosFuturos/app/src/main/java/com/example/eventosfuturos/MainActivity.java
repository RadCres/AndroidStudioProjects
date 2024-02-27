package com.example.eventosfuturos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText usuario,contrasena,email;
    private Button iniciarSesion;
    private TextView contrasenaOlvidada;
    private Switch switchBoxSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.editTextUsuario);
        email = findViewById(R.id.EditTextEmail);
        contrasena = findViewById(R.id.editTextPassword);
        iniciarSesion = findViewById(R.id.buttonIniciarSesion);
        switchBoxSesion = findViewById(R.id.switchInicio);
        contrasenaOlvidada = findViewById(R.id.textViewContraseñaOlvidada);

        iniciarSesion.setOnClickListener(v -> {
            contrasenaOlvidada.setVisibility(View.INVISIBLE);
            iniciarSesion.setVisibility(View.INVISIBLE);

            //Hacer los clausulas de guarda para pasar al activity de menus
        });


    }
    private boolean checkSwitch(){
        if (switchBoxSesion.isChecked()){
            switchBoxSesion.setText("Registrarse");
            usuario.setVisibility(View.VISIBLE);
            iniciarSesion.setText("Registrarse");
        }
        usuario.setVisibility(View.INVISIBLE);

        return false;
    }
}