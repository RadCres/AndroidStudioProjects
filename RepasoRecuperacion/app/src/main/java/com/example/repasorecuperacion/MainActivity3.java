package com.example.repasorecuperacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity implements MiAdaptador.IntemClickListener{
    private MiAdaptador miAdaptador;
    RecyclerView recycler;
    List<String> listaConsejos = new ArrayList<>();
    ImageView imagGuardar;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imagGuardar = findViewById(R.id.imageGuardar);

        recycler = findViewById(R.id.recicler);

        listaConsejos.add("Piensa antes de publicar");
        listaConsejos.add("Configurar las opcoines de privacidad");
        listaConsejos.add("Sé selectivo al aceptar nuevos contactos");
        listaConsejos.add("Piensa antes de compartir una imagen o video");

        recycler.setLayoutManager(new LinearLayoutManager(this));
        miAdaptador= new MiAdaptador(this, listaConsejos);
        miAdaptador.setClickListener(this);
        recycler.setAdapter(miAdaptador);

        imagGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText nuevoConsejo = new EditText(context);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Nuevo Comentario");
                builder.setView(nuevoConsejo); // Muestra el EditText en el diálogo

                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nuevoConsejoTexto = nuevoConsejo.getText().toString();
                        if (!nuevoConsejoTexto.isEmpty()) {
                            listaConsejos.add(nuevoConsejoTexto);
                            miAdaptador.notifyItemInserted(listaConsejos.size());
                        }
                    }
                });

                builder.setNeutralButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.create().show(); // Muestra el cuadro de diálogo después de configurarlo
            }
        });


    }


    @Override
    public void onClickSelected(View vista, int position) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setMessage("¿Borrar comentario?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listaConsejos.remove(position);
                        //Notificar al adapter el cambio
                        miAdaptador.notifyItemRemoved(position);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialogBuilder.create().show();
    }



}