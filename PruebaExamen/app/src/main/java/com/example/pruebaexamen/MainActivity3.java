package com.example.pruebaexamen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
        listaLibros = new ArrayList<>();
        listaLibros = IntStream.rangeClosed(1, 6).boxed().map(String::valueOf).collect(Collectors.toList());
//        IntStream.rangeClosed(1, 6).boxed().map(String::valueOf).collect(Collectors.toList());


        miAdapterRecicler = new MiAdaptador(this, listaLibros);
        recicler = findViewById(R.id.recicler);
        recicler.setLayoutManager(new LinearLayoutManager(this));
        recicler.setAdapter(miAdapterRecicler);
        miAdapterRecicler.setClickListener(this);
        libroNuevo = findViewById(R.id.editTextTextLIBRO);
        agregarLibro = findViewById(R.id.buttonanadir);

        anadirLibroALista();
    }

    @Override
    public void onClickSelected(View vista, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alerta");
        builder.setMessage("¿Seguro que deseas borrar?");
        builder.setPositiveButton("Aceptar", (dialog, which) -> {
                    miAdapterRecicler.removeItem(position);
                    miAdapterRecicler.notifyDataSetChanged();
                    dialog.dismiss();
                }
        );
        builder.setNegativeButton("Cancelar", (dialog, which) -> {
                    dialog.dismiss();
                }
        );
        builder.create().show();
    }
//    public void anadirLibroALista() {
//        agregarLibro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String nuevoLibro = libroNuevo.getText().toString();
//                miAdapterRecicler.addLibro(nuevoLibro);
//                miAdapterRecicler.notifyDataSetChanged();
////            }
//        });
//    }
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
}