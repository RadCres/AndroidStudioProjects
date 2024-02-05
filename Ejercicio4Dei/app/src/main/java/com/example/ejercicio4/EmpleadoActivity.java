package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejercicio4.bbdd.AdapterDepartamentos;
import com.example.ejercicio4.bbdd.AdapterEmpleados;
import com.example.ejercicio4.model.Empleado;

public class EmpleadoActivity extends AppCompatActivity {

    private Button actualizarCampos;
    private EditText emailInput;
    private EditText telefonoInput;

    private TextView tvNombre;
    private TextView tvSalario;
    private TextView tvDepartamento;

    private Empleado empleado;
    private Toolbar toolbarEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);

        this.empleado = (Empleado)getIntent().getSerializableExtra("empleado");

        loadElements();

        setData();

        setEvents();

    }

    private void setEvents() {
        this.actualizarCampos.setOnClickListener(e -> {
            String newTLF = telefonoInput.getText().toString();
            String newEmail = emailInput.getText().toString();

            this.empleado.setTelefono(newTLF);
            this.empleado.setEmail(newEmail);

            new AdapterEmpleados(this).update(empleado);

            Toast.makeText(this, "Actualizando datos!!!!!", Toast.LENGTH_SHORT).show();
        });
    }

    private void setData() {
        String departamento = new AdapterDepartamentos(this).find(Integer.valueOf(empleado.getIdDepartamento().toString()));

        this.toolbarEmpleado.setTitle("Bienvenido " + empleado.getNombre());

        this.tvSalario.setText(empleado.getSalario().toString());
        this.tvNombre.setText(empleado.getNombre());
        this.tvDepartamento.setText((departamento!=null) ? departamento : "NA" );
        this.emailInput.setText(empleado.getEmail());
        this.telefonoInput.setText(empleado.getTelefono());
    }

    private void loadElements() {
        this.toolbarEmpleado = findViewById(R.id.toolbarEmpleado);
        this.tvDepartamento = findViewById(R.id.tv_departamento);
        this.tvNombre = findViewById(R.id.tv_nombre);
        this.tvSalario = findViewById(R.id.tv_salario);
        this.emailInput = findViewById(R.id.editTextTextEmailAddress);
        this.telefonoInput = findViewById(R.id.editTextTextTextTextTextTextText);

        this.actualizarCampos = findViewById(R.id.btnActualizar);
    }


}