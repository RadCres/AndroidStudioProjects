package com.example.examenraulsegundaeva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private EditText editTextID;
    private EditText editTextNombre;
    private EditText editTextNum;
    private EditText editTextGrupo;
    private EditText editTextIdTipo;
    private EditText editTextIDMODif;

    private Button buttonModif;
    private Button buttonConsultParaModif;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editTextIDMODif = findViewById(R.id.editTextID);
        editTextID = findViewById(R.id.editTextID3);
        editTextNombre = findViewById(R.id.editTextNombre3);
        editTextNum = findViewById(R.id.editTextNum3);
        editTextGrupo = findViewById(R.id.editTextGrupo3);
        editTextIdTipo = findViewById(R.id.editTextIDTIPO3);
        buttonModif = findViewById(R.id.buttonModif);
        buttonConsultParaModif = findViewById(R.id.buttonConsultParaModif);

        buttonConsultParaModif.setOnClickListener(v -> {

            if (editTextIDMODif.getText().toString().isEmpty()) {
                Toast.makeText(context, "Ingresa un ID", Toast.LENGTH_SHORT).show();
                return;
            }

            int idConsulta = Integer.parseInt(editTextIDMODif.getText().toString());

            String datosPlantacion = AdapterBaseDatos.getInstance(context).consultarPlantacion(idConsulta);

            if (!datosPlantacion.isEmpty()) {
        
                String[] datosSeparados = datosPlantacion.split("-");

                editTextID.setText(datosSeparados[0].toString());
                editTextNombre.setText(datosSeparados[1].toString());
                editTextNum.setText(datosSeparados[2].toString());
                editTextGrupo.setText(datosSeparados[3].toString());
                editTextIdTipo.setText(datosSeparados[4].toString());

                Toast.makeText(context, "Consulta realizada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "No se encontraron datos", Toast.LENGTH_SHORT).show();
            }
        });


        buttonModif.setOnClickListener(v -> {

            if (editTextID.getText().toString().isEmpty()) {
                Toast.makeText(context, "Ingresa un ID", Toast.LENGTH_SHORT).show();
                return;
            }

            String nombrePlanta = editTextNombre.getText().toString();
            int numPlantas = Integer.parseInt(editTextNum.getText().toString());
            String grupoClase = editTextGrupo.getText().toString();
            int idTipo = Integer.parseInt(editTextIdTipo.getText().toString());

            boolean actualizacionExitosa = AdapterBaseDatos.getInstance(context).setPlantacion(
                    Integer.valueOf(editTextID.getText().toString()),
                    nombrePlanta, numPlantas, grupoClase, idTipo);

            if (actualizacionExitosa) {
                Toast.makeText(context, "Plantación actualizada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Error al actualizar", Toast.LENGTH_SHORT).show();
            }
        });

    }
}