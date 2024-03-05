package com.example.eventosfuturos;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventosfuturos.adapter.MiAdaptadorGrupos;
import com.example.eventosfuturos.model.dto.Grupo;
import com.example.eventosfuturos.service.TaskCompleted;

import java.util.ArrayList;
import java.util.List;

public class MainActivityGrupos extends AppCompatActivity implements TaskCompleted<List<Grupo>>, MiAdaptadorGrupos.IntemClickListener {
    private Context context = this;
    private RecyclerView recicler;
    private MiAdaptadorGrupos miAdaptadorGrupos;
    private List<Grupo> listaGrupos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_grupos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        miAdaptadorGrupos = new MiAdaptadorGrupos(context, listaGrupos);
        recicler= findViewById(R.id.reciclerGrupos);
        recicler.setLayoutManager(new LinearLayoutManager(context));
        recicler.setAdapter(miAdaptadorGrupos);
        miAdaptadorGrupos.setClickListener(this);

        //Hacer get eventos
    }

    @Override
    public void onClickSelected(View vista, int position) {

    }

    @Override
    public void onTaskCompleted(List<Grupo> grupos) {
    listaGrupos.clear();
    listaGrupos.addAll(grupos);
    miAdaptadorGrupos.notifyDataSetChanged();
    }
}