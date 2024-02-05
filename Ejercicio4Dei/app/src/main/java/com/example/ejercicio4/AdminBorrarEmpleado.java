package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejercicio4.bbdd.AdapterEmpleados;

public class AdminBorrarEmpleado extends AppCompatActivity {

    private EditText inputID;
    private Button btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_borrar_empleado);

        loadElements();

        setEvents();
    }

    private void setEvents() {
        this.btnBorrar.setOnClickListener(e -> {
            new AdapterEmpleados(this).delete(Long.valueOf(inputID.getText().toString()));
        });
    }

    private void loadElements() {
        this.inputID = findViewById(R.id.borrarEmpleadoID);
        this.btnBorrar = findViewById(R.id.btnBorrarEmpleado);
    }
}