package com.example.ejercicio4tema3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SumarActivity extends AppCompatActivity {
    private EditText numeroUno;
    private EditText numeroDos;
    private EditText numeroTres;
    private TextView resultado;
    private Button botonSuma;
    private Button botonVolver;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumar);

        numeroUno = findViewById(R.id.editTextNumeroUno);
        numeroDos = findViewById(R.id.editTextNumeroDos);
        numeroTres = findViewById(R.id.editTextNumeroTres);
        resultado = findViewById(R.id.textViewResultado);
        botonSuma = findViewById(R.id.buttonSuma);
        botonVolver = findViewById(R.id.buttonVolver);

        botonSuma.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double resultadoSuma = (
                    Double.valueOf(numeroUno.getText().toString())+
                    Double.valueOf(numeroDos.getText().toString())+
                    Double.valueOf(numeroTres.getText().toString())) ;
            resultado.setText(String.valueOf(resultadoSuma));

        }
    });
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasarActivityPrincipal = new Intent(v.getContext(), MainActivity.class);
                startActivity(pasarActivityPrincipal);
                finish();
            }
        });
    }
}