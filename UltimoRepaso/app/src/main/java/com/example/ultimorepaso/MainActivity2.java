package com.example.ultimorepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Context context = this;
    private TextView textViewNombreMostrado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewNombreMostrado=findViewById(R.id.textViewNombreRecibido);


        Intent intent = getIntent();

        String nombre = intent.getStringExtra("nombre");
        textViewNombreMostrado.setText("Tu nombre es :" +nombre);
    }
}