package com.example.eventosfuturos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private Context context = this;
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

        setBotonCrearEvento();
    }

    private void setBotonCrearEvento() {
        buttonCrearEvento.setOnClickListener(v -> {
            // Obtener valores de los campos
            String titulo = editTitulo.getText().toString().trim();
            String grupo = editGrupo.getText().toString().trim();
            String descripcion = editDescripcion.getText().toString().trim();
            String fecha = editFecha.getText().toString().trim();
            String hora = editHora.getText().toString().trim();

            // Verificar si algún campo está vacío
            if (titulo.isEmpty() || grupo.isEmpty() || descripcion.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
                // Mostrar un mensaje al usuario indicando que complete todos los campos
                Toast.makeText(context, "Completa todos los campos antes de continuar", Toast.LENGTH_SHORT).show();
            } else {
                // Todos los campos están completos, proceder con la acción
                SharedPreferences prefs = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
                String email = prefs.getString("email", "");
                CreateEvento createEvento = new CreateEvento(this, email);
                Timestamp timestamp = Timestamp.valueOf(fecha + " " + hora);
                Evento evento = new Evento(timestamp, titulo, descripcion, grupo);
                createEvento.execute(evento);
            }
        });
    }


    @Override
    public void onTaskCompleted(Boolean created) {
        if(created){
            editTitulo.setText("");
            editGrupo.setText("");
            editDescripcion.setText("");
            editFecha.setText("");;
            editHora.setText("");;
            Toast.makeText(context, "Evento Creado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "No se pudo crear", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemCerrar:
                SharedPreferences prefs =
                        getSharedPreferences(getString(R.string.app_name),
                                Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}