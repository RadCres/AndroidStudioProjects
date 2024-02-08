package com.example.examenraulsegundaeva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText id;
    private EditText nombre;
    private EditText numeroPlantas;
    private EditText grupo;
    private EditText idTipo;
    private AdapterBaseDatos adapterBaseDatos;
    private Button buttonAlta;
    private Context context= this;
    private TextView Titulo;
    private Button buttonPasarMod;
    private Button buttonVer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        id = findViewById(R.id.editTextNumberIdPlantacion);
        nombre = findViewById(R.id.editTextTextNombrePlanta);
        numeroPlantas = findViewById(R.id.editTextNumberNumPlantas);
        grupo = findViewById(R.id.editTextTextgrupoClase);
        idTipo = findViewById(R.id.editTextIdTipo);
        buttonAlta = findViewById(R.id.buttonDarAlta);
        Titulo = findViewById(R.id.textViewTitulo);
        buttonPasarMod = findViewById(R.id.buttonPasarModif);
        buttonVer = findViewById(R.id.buttonVerPlantas);


        buttonAlta.setOnClickListener(v -> {
            if (!id.getText().toString().isEmpty() && !nombre.getText().toString().isEmpty() &&
            !numeroPlantas.getText().toString().isEmpty() && !grupo.getText().toString().isEmpty()
            && !idTipo.getText().toString().isEmpty()) {
                Long longito = AdapterBaseDatos.getInstance(context).insertar(Integer.valueOf(id.getText().toString()),nombre.getText().toString(),
                        Integer.valueOf(numeroPlantas.getText().toString()),grupo.getText().toString(),Integer.valueOf(idTipo.getText().toString()));
                Toast.makeText(this, "Insertado", Toast.LENGTH_SHORT).show();
                id.setText("");
                nombre.setText("");
                numeroPlantas.setText("");
                grupo.setText("");
                idTipo.setText("");

                if (longito == -1)
                    Toast.makeText(context, "No se ha insertado nada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonPasarMod.setOnClickListener(v -> {
            Intent intentActivity3 = new Intent(v.getContext(),MainActivity3.class);
            startActivity(intentActivity3);
        });
        buttonVer.setOnClickListener(v -> {
            Intent intentActivity4 = new Intent(v.getContext(),MainActivity4.class);
            startActivity(intentActivity4);
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.Alta:
                id.setVisibility(View.VISIBLE);
                nombre.setVisibility(View.VISIBLE);
                numeroPlantas.setVisibility(View.VISIBLE);
                grupo.setVisibility(View.VISIBLE);
                idTipo.setVisibility(View.VISIBLE);
                buttonAlta.setVisibility(View.VISIBLE);
                Titulo.setVisibility(View.VISIBLE);
                return true;
            case R.id.Modificar:
                buttonPasarMod.setVisibility(View.VISIBLE);
                return true;
            case R.id.VerTotalPorTipo:
                buttonVer.setVisibility(View.VISIBLE);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}