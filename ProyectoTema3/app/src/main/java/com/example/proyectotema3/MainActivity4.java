package com.example.proyectotema3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity4 extends AppCompatActivity {
    private CalendarView calendario;


    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        calendario = findViewById(R.id.MiCalendario);


        getCalendario();


    }


    public void dialogoEditText(final String date) {
        // Crea un EditText
        final EditText lista = new EditText(this);

        // Lee el contenido del archivo y establece el texto en el EditText
        String contenidoGuardado = leerContenidoGuardado(date);
        lista.setText(contenidoGuardado);

        // Crea un AlertDialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(lista);
        alertDialogBuilder.setTitle("Notas");
        alertDialogBuilder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Acción al hacer clic en el botón Guardar
                guardar(date, lista.getText().toString());
            }
        });
        alertDialogBuilder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Acción al hacer clic en el botón Salir
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilder.setCancelable(false);

        // Muestra el AlertDialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
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


    private void guardar(String date, String contenido) {
        try {
            if (!TextUtils.isEmpty(contenido)) {
                OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(date, Context.MODE_PRIVATE));
                archivo.write(contenido);
                archivo.flush();
                archivo.close();
            } else {
                Toast.makeText(MainActivity4.this, "Nueva nota guardada", Toast.LENGTH_SHORT).show();
            }
        } catch (Throwable e) {
            Toast.makeText(getApplicationContext(),
                    "Exception: " + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


}