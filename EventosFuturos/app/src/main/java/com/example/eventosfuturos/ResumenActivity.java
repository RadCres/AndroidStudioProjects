package com.example.eventosfuturos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eventosfuturos.OM.OM_Eventos;
import com.example.eventosfuturos.adapter.MiAdaptador;
import com.example.eventosfuturos.model.dto.Evento;
import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;

import java.util.List;

public class ResumenActivity extends AppCompatActivity implements TaskCompleted<Usuario>, MiAdaptador.IntemClickListener{
    private Button buttonMisGrupos, buttonCalendario;
    private RecyclerView recicler;
    private MiAdaptador miAdaptador;
    private List<Evento> listaEventos = new OM_Eventos().ListaEventos();
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

        miAdaptador = new MiAdaptador(this, listaEventos);
        recicler = findViewById(R.id.recicler);
        recicler.setLayoutManager(new LinearLayoutManager(this));
        recicler.setAdapter(miAdaptador);
        miAdaptador.setClickListener(this);

    }


    @Override
    public void onTaskCompleted(Usuario usuario) {

    }

    @Override
    public void onClickSelected(View vista, int position) {

    }
}