package com.example.ejercicio4tema4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements MiAdaptador.IntemClickListener {
    private AdapterBaseDatos bdAdapter;
    private Context context = this;
    private List<String> listaEmpelados = new ArrayList<>();
    private MiAdaptador miAdaptador;
    private RecyclerView recyclerView;
    private EditText editTextDepart;
    private Spinner spinner;
    private List<String> listaNombresDepart = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bdAdapter = AdapterBaseDatos.getInstance(context);
        recyclerView = findViewById(R.id.recycler);
        editTextDepart = findViewById(R.id.editTextDepartamento);
        spinner = findViewById(R.id.spinner);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.EliminarEmpleado:
                return true;
            case R.id.NombreSalario:
                recyclerView.setVisibility(View.VISIBLE);
                nombreSalarioEmpleados();
                return true;
            case R.id.NombrePorDepartamento:
                editTextDepart.setVisibility(View.VISIBLE);
                nombrePorDepart();
                return true;
            case R.id.IncrementarSalario:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void nombreSalarioEmpleados(){
        try {
            List<String> nombresSalarios = AdapterBaseDatos.getInstance(context).consultarNombreSalario();
            listaEmpelados.addAll(nombresSalarios);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            miAdaptador = new MiAdaptador(this, listaEmpelados);
            miAdaptador.setClickListener(this);
            recyclerView.setAdapter(miAdaptador);

        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Error al consultar", Toast.LENGTH_SHORT).show();
        }
    }

    public void nombrePorDepart(){
        try {
        List<String> nombreEmpleados = AdapterBaseDatos.getInstance(context).consultarNombrePorDepartamento(Integer.parseInt(editTextDepart.getText().toString()));
        listaNombresDepart.addAll(nombreEmpleados);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClickSelected(View vista, int position) {

    }
}