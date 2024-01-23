package com.example.recuperacionraul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MainActivity3 extends AppCompatActivity implements MiAdaptador.IntemClickListener {
    private RecyclerView recicler;
    private MiAdaptador miAdapterRecicler;
    private List<String> listaLibros;
    private EditText libroNuevo;
    private Button agregarLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listaLibros = new ArrayList<String>();

        miAdapterRecicler = new MiAdaptador(this, listaLibros);
        recicler = findViewById(R.id.recycler);
        recicler.setLayoutManager(new LinearLayoutManager(this));
        recicler.setAdapter(miAdapterRecicler);
        miAdapterRecicler.setClickListener(this);
        libroNuevo = findViewById(R.id.editTextLibro);
        agregarLibro = findViewById(R.id.buttonanadir);

        listaLibros.add("Harry Potter");
        listaLibros.add("El señor de los anillos");
        listaLibros.add("El Rey Leon");
        listaLibros.add("DAM");
        listaLibros.add("Android");
        listaLibros.add("Por fin apruebo");


        anadirLibroALista();
    }


    public void anadirLibroALista() {
        agregarLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nuevoLibro = libroNuevo.getText().toString();
                if (!nuevoLibro.isEmpty()) {
                    listaLibros.add(nuevoLibro);
                    miAdapterRecicler.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onClickSelected(View vista, int position) {

    }
}