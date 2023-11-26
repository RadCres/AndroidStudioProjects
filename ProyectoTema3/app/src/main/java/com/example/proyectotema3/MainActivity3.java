package com.example.proyectotema3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.proyectotema3.model.NacionalidadOM;

public class MainActivity3 extends AppCompatActivity implements MiAdaptador.IntemClickListener{
    private MiAdaptador adaptador;
    private RecyclerView recicleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        displayNacionalidades();
    }
    private void displayNacionalidades() {
        // PASOS para el recicleView
        recicleView = findViewById(R.id.recicler);
        //creamos un layout vertical
        LinearLayoutManager linearMng = new LinearLayoutManager(this);
        // se lo insertamos al recicleview
        recicleView.setLayoutManager(linearMng);
        // Creamos ADAPTADOR
        this.adaptador = new MiAdaptador(this, NacionalidadOM.getList());
        //Hacemos listener del recicle antes del adapter
        this.adaptador.setClickListener(this);
        // Metemos nuestro adaptador
        recicleView.setAdapter(adaptador);
    }

    @Override
    public void onClickSelected(View vista, int position) {
        Toast.makeText(this, "HOLA", Toast.LENGTH_SHORT).show();
        Log.d("Adaptador", "onClickSelected: Escucho");
    }
}