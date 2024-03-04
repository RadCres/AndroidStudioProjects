package com.example.eventosfuturos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eventosfuturos.adapter.MiAdaptador;
import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;

public class ResumenActivity extends AppCompatActivity implements TaskCompleted<Usuario>, MiAdaptador.IntemClickListener{
    private Button buttonMisGrupos, buttonCalendario;
    private MiAdaptador miAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        buttonMisGrupos = findViewById(R.id.buttonMisGrupos);
        buttonCalendario = findViewById(R.id.buttonCalendario);

        buttonMisGrupos.setOnClickListener(v -> {

        });
        buttonCalendario.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), MainActivityCalendario.class);
            startActivity(intent);
        });
    }


    @Override
    public void onTaskCompleted(Usuario usuario) {

    }

    @Override
    public void onClickSelected(View vista, int position) {

    }
}