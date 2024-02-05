package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio4.bbdd.AdapterEmpleados;
import com.example.ejercicio4.model.Empleado;

public class MainActivity extends AppCompatActivity {

    EditText inputID;
    AdapterEmpleados baseDatos;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadElements();

        loadBd();

        setEvents();
    }

    private void setEvents() {
        this.btnIngresar.setOnClickListener(e -> {
            try {
                Long id = Long.valueOf(inputID.getText().toString());
                Empleado resultado = baseDatos.find(id);

                if(resultado == null) {
                    Toast.makeText(this, "Error, empleado no encontrado", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(resultado.getId() == 1) openActivity(
                        new Intent(MainActivity.this, AdminActivity.class));
                else openActivity(
                        new Intent(MainActivity.this, EmpleadoActivity.class)
                                .putExtra("empleado", resultado));
            } catch (Exception err){
                Toast.makeText(getApplicationContext(), err.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void openActivity(Intent intent){
        startActivity(intent);
    }

    private void loadBd() {
        this.baseDatos = new AdapterEmpleados(this);
    }

    private void loadElements() {
        this.inputID = findViewById(R.id.editTextIdEmpleado);
        this.btnIngresar = findViewById(R.id.btnIngresar);
    }


}