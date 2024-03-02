package com.example.eventosfuturos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.eventosfuturos.service.TaskCompleted;

public class MainActivityMenuInicioSesion extends AppCompatActivity implements TaskCompleted<Boolean> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_inicio_sesion);
    }

    @Override
    public void onTaskCompleted(Boolean aBoolean) {

    }
}