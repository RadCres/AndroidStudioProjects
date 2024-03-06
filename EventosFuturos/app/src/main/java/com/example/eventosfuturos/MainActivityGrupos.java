package com.example.eventosfuturos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventosfuturos.adapter.MiAdaptadorGrupos;
import com.example.eventosfuturos.model.dto.Grupo;
import com.example.eventosfuturos.service.TaskCompleted;
import com.example.eventosfuturos.service.impl.GetGrupos;
import com.example.eventosfuturos.service.impl.SalirDeGrupo;

import java.util.ArrayList;
import java.util.List;

public class MainActivityGrupos extends AppCompatActivity implements TaskCompleted<List<Grupo>>, MiAdaptadorGrupos.IntemClickListener {
    private Context context = this;
    private RecyclerView recicler;
    private MiAdaptadorGrupos miAdaptadorGrupos;
    private List<Grupo> listaGrupos = new ArrayList<>();
    private Button buttonAnadirGrupo;

    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_grupos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        miAdaptadorGrupos = new MiAdaptadorGrupos(context, listaGrupos);
        recicler= findViewById(R.id.reciclerGrupos);
        recicler.setLayoutManager(new LinearLayoutManager(context));
        recicler.setAdapter(miAdaptadorGrupos);
        miAdaptadorGrupos.setClickListener(this);
        buttonAnadirGrupo = findViewById(R.id.buttonAnadirGrupo);

        //Hacer get eventos
        GetGrupos getGrupos = new GetGrupos(this);
        SharedPreferences prefs
                =getSharedPreferences(getString(R.string.app_name),
                Context.MODE_PRIVATE);
        email = prefs.getString("email", "");
        getGrupos.execute(email);

        setButtonAnadirGrupo();
    }

    @Override
    public void onClickSelected(View vista, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(vista.getContext());
        builder.setTitle("Opciones")
                .setItems(new CharSequence[]{"Añadir usuario al grupo", "Salir del grupo", "Cancelar"}, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            // Opción: Añadir usuario al grupo
                            mostrarDialogoAñadirUsuario(position);
                            break;
                        case 1:
                            mostrarDialogoSalirGrupo(position);
                            break;
                        // Agregamos el caso para la opción Cancelar
                        case 2:
                            Toast.makeText(context, "Operación cancelada", Toast.LENGTH_SHORT).show();
                            break;
                    }
                });

        builder.create().show();
    }


    private void mostrarDialogoAñadirUsuario(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Introduce el email del usuario a añandir");
            final EditText email = new EditText(this);
                builder.setView(email);
                builder.setPositiveButton("Aceptar", (dialog, which) -> {
                    String palabraIngresada = email.getText().toString().trim();
                })
                .setNegativeButton("Cancelar", (dialog, which) -> {
                    Toast.makeText(context, "Operación cancelada", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                });

        builder.create().show();
    }


    private void mostrarDialogoSalirGrupo(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Salir del grupo")
                .setMessage("¿Estás seguro de que deseas salir del grupo?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    SalirDeGrupo salirDeGrupo = new SalirDeGrupo(this);
                    salirDeGrupo.execute(email,listaGrupos.get(position).getNombre());
                })
                .setNegativeButton("No", (dialog, which) -> {
                    Toast.makeText(context, "Operación cancelada", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                });

        builder.create().show();
    }



    @Override
    public void onTaskCompleted(List<Grupo> grupos) {
    listaGrupos.clear();
    listaGrupos.addAll(grupos);
    miAdaptadorGrupos.notifyDataSetChanged();
        Log.d("Grupos",listaGrupos.size()+"");
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

    public void setButtonAnadirGrupo() {
        buttonAnadirGrupo.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Añadir Grupo");
            
            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);
            
            builder.setPositiveButton("Aceptar", (dialog, which) -> {
           
                //String nuevoGrupo = input.getText().toString();
                // Llamar a un método para manejar la creación del nuevo grupo
                //handleCrearGrupo(nuevoGrupo);
            });
            builder.setNegativeButton("Cancelar", (dialog, which) -> {
                Toast.makeText(context, "Operación cancelada", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            });

            builder.show();
        });
    }
}