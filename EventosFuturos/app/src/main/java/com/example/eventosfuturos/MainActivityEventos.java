package com.example.eventosfuturos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eventosfuturos.model.dto.Evento;
import com.example.eventosfuturos.service.TaskCompleted;
import com.example.eventosfuturos.service.impl.CreateEvento;

import java.sql.Timestamp;

public class MainActivityEventos extends AppCompatActivity implements TaskCompleted<Boolean> {
    private EditText editTitulo, editGrupo, editDescripcion, editFecha, editHora;
    private Button buttonCrearEvento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_eventos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTitulo = findViewById(R.id.editTextTitulo);
        editGrupo = findViewById(R.id.editTextGrupo);
        editDescripcion = findViewById(R.id.editTextDescripcion);
        editFecha = findViewById(R.id.editTextFecha);
        editHora = findViewById(R.id.editTextHora);
        buttonCrearEvento = findViewById(R.id.buttonCrearEvento);
        String fecha = getIntent().getStringExtra("Date");
        String[] dia = fecha.split(" ");
        editFecha.setText(dia[0]);

        buttonCrearEvento.setOnClickListener(v -> {
            CreateEvento createEvento = new CreateEvento(this);
            Timestamp timestamp = Timestamp.valueOf(editFecha.getText().toString() + " " + editHora.getText().toString());
            String titulo = editTitulo.getText().toString();
            String descripcion = editDescripcion.getText().toString();
            String nombreGrupo = editGrupo.getText().toString();
            Evento evento = new Evento(timestamp, titulo, descripcion,nombreGrupo);
            createEvento.execute(evento);
        });
    }

    @Override
    public void onTaskCompleted(Boolean created) {
        if(created){
            Toast.makeText(this, "Evento Creado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "No se pudo crear", Toast.LENGTH_SHORT).show();
        }
    }
}