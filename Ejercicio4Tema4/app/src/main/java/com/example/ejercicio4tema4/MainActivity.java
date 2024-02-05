package com.example.ejercicio4tema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumb;
    private Button buttonConsult;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConsult = findViewById(R.id.buttonConsultar);
        editTextNumb = findViewById(R.id.editTextNumber);

        buttonConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNumb.getText().toString().isEmpty()){
                    Toast.makeText(context, "Por favor, ingrese una id", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    int idConsulta = Integer.valueOf(editTextNumb.getText().toString());
                    String name = AdapterBaseDatos.getInstance(context).consultar(idConsulta);
                    Toast.makeText(context, "Hola " + name, Toast.LENGTH_SHORT).show();
                    if (idConsulta == 1){
                        Intent intentActivity2 = new Intent(v.getContext(),MainActivity2.class);
                        startActivity(intentActivity2);
                    }else{
                        Intent intentActivity3 = new Intent(v.getContext(), MainActivity3.class);
                        String numeroEmpleado = editTextNumb.getText().toString();
                        intentActivity3.putExtra("nombreEmpleado", numeroEmpleado);
                        startActivity(intentActivity3);

                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(context, "Error al consultar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}