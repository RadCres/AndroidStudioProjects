package com.example.proyectotema3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;


public class MainActivity4 extends AppCompatActivity {
    private CalendarView calendario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        calendario = findViewById(R.id.MiCalendario);
        getCalendario();
    }


    private void dialogoEditText(final String date) {
        final EditText lista = new EditText(this);

        String contenidoGuardado = leerContenidoGuardado(date);
        lista.setText(contenidoGuardado);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(lista);
        alertDialogBuilder.setTitle("Notas");

        alertDialogBuilder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                guardar(date, lista.getText().toString());

            }
        });

        alertDialogBuilder.setNegativeButton("Borrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                borrarNotas(date);
            }
        });

        alertDialogBuilder.setNeutralButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialogBuilder.setCancelable(false);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void guardar(String date, String contenido) {
        try {
            if (!TextUtils.isEmpty(contenido)) {
                OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(date, Context.MODE_PRIVATE));
                archivo.write(contenido);
                archivo.flush();
                archivo.close();
                Toast.makeText(MainActivity4.this, "Nota guardada con éxito", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity4.this, "Guardado sin cambios", Toast.LENGTH_SHORT).show();
            }
        } catch (Throwable e) {
            Toast.makeText(getApplicationContext(),
                    "Exception: " + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void borrarNotas(String date) {
        try {
            // Verificar si el archivo existe antes de intentar borrar
            File file = getFileStreamPath(date);
            if (file.exists()) {
                deleteFile(date);
                Toast.makeText(MainActivity4.this, "Notas borradas", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity4.this, "No hay notas que borrar", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity4.this, "Error al borrar las notas", Toast.LENGTH_SHORT).show();
        }
    }


    private void getCalendario() {
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = obtenerFechaComoTexto(year, month, dayOfMonth);
                dialogoEditText(date);

            }
        });

    }

    private String obtenerFechaComoTexto(int year, int month, int dayOfMonth) {
        // Convertir año, mes y día a un formato de texto
        // Aquí puedes personalizar el formato según tus necesidades
        return year + "_" + (month + 1) + "_" + dayOfMonth;
    }

    private String leerContenidoGuardado(String date) {
        try {
            FileInputStream archivo = openFileInput(date);
            InputStreamReader lector = new InputStreamReader(archivo);
            BufferedReader br = new BufferedReader(lector);
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            br.close();
            lector.close();
            archivo.close();
            return contenido.toString();
        } catch (Exception e) {
            // Manejar la excepción según tus necesidades
            return "";
        }
    }


}