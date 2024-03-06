package com.example.eventosfuturos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.example.eventosfuturos.service.impl.GetGrupos;

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
        GetGrupos getGrupos = new GetGrupos(this);
        String[] nombre = {getIntent().getStringExtra("nombre")};
        getGrupos.execute(nombre);
    }

    @Override
    public void onClickSelected(View vista, int position) {

    }

    @Override
    public void onTaskCompleted(List<Grupo> grupos) {
    listaGrupos.clear();
    listaGrupos.addAll(grupos);
    miAdaptadorGrupos.notifyDataSetChanged();
        Log.d("Grupos",listaGrupos.size()+"");
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemCerrar:
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}