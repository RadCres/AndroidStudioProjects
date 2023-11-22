package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView got;
    private ImageView vendetta;
    private ImageView mando;
    private ImageView avengers;
    private Button boton;
    private Button botonColor;
    private ImageView imagenInvisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        got=findViewById(R.id.gow);
        vendetta=findViewById(R.id.vendetta);
        mando=findViewById(R.id.mando);
        avengers=findViewById(R.id.avengers);
        imagenInvisible= findViewById(R.id.imagenInvisible);
        boton = findViewById(R.id.button);
        botonColor = findViewById(R.id.botonColores);

        mando.setOnClickListener(e->{
            mando.setImageResource(R.mipmap.mando_round);
        });
        vendetta.setOnClickListener(e->{
            vendetta.setImageResource(R.mipmap.ic_launcher_round);
        });
        got.setOnClickListener(e->{
            got.setImageResource(R.mipmap.got_round);
        });
        avengers.setOnClickListener(e->{
            avengers.setImageResource(R.mipmap.avengers_round);
        });
        boton.setOnClickListener(e->{
            imagenInvisible.setVisibility(View.VISIBLE);
        });
        imagenInvisible.setOnClickListener(e->{
            imagenInvisible.setVisibility(View.INVISIBLE);
        });
        botonColor.setOnClickListener(e->{
            botonColor.setBackgroundColor(Color.parseColor("#404040"));
        });

           }
}