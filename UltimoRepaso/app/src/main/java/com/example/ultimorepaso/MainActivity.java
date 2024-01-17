package com.example.ultimorepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity{
    private Context context = this;
    private Spinner spinnerBanderas;
    private EditText nombre;
    private Button pasarActivityDos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBanderas = findViewById(R.id.spinnerBanderas);
        nombre = findViewById(R.id.editTextNombre);
        pasarActivityDos = findViewById(R.id.buttonPasarActivityDos);

        pasarActivityDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity2.class);
                intent.putExtra("nombre", nombre.getText().toString());
                startActivity(intent);
            }
        });
    }
}