package com.example.ejerciciobdalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText Nombre;
    private EditText Email;
    private EditText Edad;
    private Button botonAceptar;

    private BDAdaptador bdAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Nombre = findViewById(R.id.editTextNombre);
        Email = findViewById(R.id.editTextEmail);
        Edad = findViewById(R.id.editTextEdad);
        botonAceptar = findViewById(R.id.buttonAceptar);

        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            bdAdaptador.insertar(Nombre.getText().toString(),Edad.getText().toString(),Email.getText().toString());
                Toast.makeText(MainActivity2.this, "Insertado", Toast.LENGTH_SHORT).show();
            }
        });
    }

}