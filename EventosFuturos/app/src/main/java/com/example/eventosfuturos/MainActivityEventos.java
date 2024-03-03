package com.example.eventosfuturos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityEventos extends AppCompatActivity {
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
        buttonCrearEvento.setOnClickListener(v -> {

        });
    }
}