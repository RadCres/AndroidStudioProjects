package com.example.eventosfuturos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;

public class ResumenActivity extends AppCompatActivity implements TaskCompleted<Usuario> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
    }


    @Override
    public void onTaskCompleted(Usuario usuario) {

    }
}