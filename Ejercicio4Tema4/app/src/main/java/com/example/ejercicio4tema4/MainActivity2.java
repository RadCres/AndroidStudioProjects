package com.example.ejercicio4tema4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity2 extends AppCompatActivity implements MiAdaptador.IntemClickListener {
    private AdapterBaseDatos bdAdapter;
    private Context context = this;
    private List<String> listaEmpleados = new ArrayList<>();
    private MiAdaptador miAdaptador;
    private RecyclerView recyclerView;
    private EditText editTextDepart;
    private Button buttonCon;
    private List<String> listaNombresDepart = new ArrayList<>();
    private EditText editTextElim;
    private Button buttonElim;
    private Button buttonIncrem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bdAdapter = AdapterBaseDatos.getInstance(context);
        recyclerView = findViewById(R.id.recycler);
        editTextDepart = findViewById(R.id.editTextDepartamento);
        buttonCon = findViewById(R.id.buttonConsultarPorDep);
        editTextElim = findViewById(R.id.editTextEliminarId);
        buttonElim = findViewById(R.id.buttonEliminar);
        buttonIncrem = findViewById(R.id.buttonIncrementarSalario);

        nombreSalarioEmpleados();
        nombrePorDepart();
        eliminarEmpleado();
        buttonIncrem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdAdapter.incrementarSalario();
                listaEmpleados.clear();
                listaEmpleados.addAll(bdAdapter.consultarNombreSalario());
                miAdaptador.notifyDataSetChanged();
            }
        }
        );
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.EliminarEmpleado:
                editTextElim.setVisibility(View.VISIBLE);
                buttonElim.setVisibility(View.VISIBLE);

                return true;
            case R.id.NombreSalario:
                recyclerView.setVisibility(View.VISIBLE);
                nombreSalarioEmpleados();
                editTextDepart.setVisibility(View.VISIBLE);
                buttonCon.setVisibility(View.VISIBLE);
                return true;
            case R.id.NombrePorDepartamento:
                editTextDepart.setVisibility(View.VISIBLE);
                buttonCon.setVisibility(View.VISIBLE);
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
            listaEmpleados.addAll(nombresSalarios);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            miAdaptador = new MiAdaptador(this, listaEmpleados);
            miAdaptador.setClickListener(this);
            recyclerView.setAdapter(miAdaptador);

        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Error al consultar", Toast.LENGTH_SHORT).show();
        }
    }

    public void nombrePorDepart(){
        try {
            buttonCon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<String> nombreEmpleados = AdapterBaseDatos.getInstance(context).consultarNombrePorDepartamento(Integer.parseInt(editTextDepart.getText().toString()));
                    listaNombresDepart.addAll(nombreEmpleados);
                    listaEmpleados.clear();
                    listaEmpleados.addAll(nombreEmpleados);
                    miAdaptador.notifyDataSetChanged();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }
    }

      public void eliminarEmpleado() {
        try {
            int idEmpleado = Integer.valueOf(editTextElim.getText().toString());

           bdAdapter.eliminarEmpleado(idEmpleado);

           listaEmpleados = listaEmpleados.stream()
                    .filter(empleado -> !empleado.contains(String.valueOf(idEmpleado)))
                    .collect(Collectors.toList());

           listaNombresDepart = listaNombresDepart.stream()
                    .filter(empleado -> !empleado.contains(String.valueOf(idEmpleado)))
                    .collect(Collectors.toList());

           miAdaptador.notifyDataSetChanged();

           editTextElim.setText("");

           Toast.makeText(context, "Empleado eliminado con éxito", Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(context, "Por favor, ingrese una ID válida", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Error al eliminar empleado", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClickSelected(View vista, int position) {

    }
}