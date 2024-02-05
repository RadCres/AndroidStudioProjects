package com.example.ejercicio4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejercicio4.bbdd.AdapterEmpleados;
import com.example.ejercicio4.model.Empleado;

import java.util.List;

public class AdminActivity extends AppCompatActivity {

    private RecyclerView listaEmpleados;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        loadElements();

        setRecyclerView(new AdapterEmpleados(this).findAll());

        setEvents();

    }

    private void setEvents() {
        Menu menu = this.toolbar.getMenu();

        menu.findItem(R.id.menu_borrarEmpleado).setOnMenuItemClickListener(e -> {
            startActivity(new Intent(AdminActivity.this, AdminBorrarEmpleado.class));
            return true;
        });

        menu.findItem(R.id.menu_incrementarSalario).setOnMenuItemClickListener(e -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Estas seguro que deseas aumentar un 10%")
                    .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                    .setPositiveButton("Si", (dialog, which) -> {
                        new AdapterEmpleados(getApplicationContext()).increase10percent();
                        setRecyclerView(new AdapterEmpleados(getApplicationContext()).findAll());
                        dialog.dismiss();
                    })
                    .create().show();


            return true;
        });

        menu.findItem(R.id.menu_filtrarBtn).setOnMenuItemClickListener(e -> {
            final Dialog dialog = new Dialog(this);
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.dialog_departamento);
            dialog.setTitle("Filtrar por departamento");

            EditText idBorrar = dialog.findViewById(R.id.dialogIDdepartamento);

            Button btnYes = dialog.findViewById(R.id.btnFilterYes);
            Button btnNo = dialog.findViewById(R.id.btnFilterNo);

            btnYes.setOnClickListener(r -> {
                Log.i("dialogod de mierad", idBorrar.getText().toString());
                if(idBorrar.getText().toString()!=null){
                    setRecyclerView(new AdapterEmpleados(getApplicationContext()).findAllByDepartamento(Long.valueOf(idBorrar.getText().toString())));
                    dialog.dismiss();
                }
            });

            btnNo.setOnClickListener(r -> {
                dialog.dismiss();
            });

            dialog.show();

            return true;
        });
    }

    private void setRecyclerView(List<Empleado> lista) {
        this.listaEmpleados.setLayoutManager(new LinearLayoutManager(this));
        this.listaEmpleados.setAdapter(new AdapterEmpleadosRecycle(this, lista));

    }

    private void loadElements() {
        this.toolbar = findViewById(R.id.toolbar);
        this.listaEmpleados = findViewById(R.id.listaEmpleados);
    }
}