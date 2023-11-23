package com.example.proyectotema3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private ImageButton botonESO;
    private ImageButton botonFP;
    private ImageButton botonBachillerato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        botonFP = findViewById(R.id.imageButtonFP);
        botonESO = findViewById(R.id.imageButtonEso);
        botonBachillerato = findViewById(R.id.imageButtonBachillerato);
        registerForContextMenu(botonESO);

        botonFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Botón pulsado", Toast.LENGTH_SHORT).show();

            }
        });
        botonESO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Toast.makeText(MainActivity2.this, "Botón pulsado", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontextualeso_main2, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        String opcion = "";
        switch (item.getItemId()) {
            case R.id.itemPrimero:
                opcion = "PrimeroESO";
                pulsarOpcionDelMenu(opcion);

                return true;
            case R.id.itemSegundo:
                opcion = "SegundoESO";
                pulsarOpcionDelMenu(opcion);
                return true;
            case R.id.itemTercero:
                opcion = "TerceroESO";
                pulsarOpcionDelMenu(opcion);
                return true;

            case R.id.itemCuarto:
                opcion = "CuartoESO";
                pulsarOpcionDelMenu(opcion);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void pulsarOpcionDelMenu(String opcion) {
        if (opcion.equalsIgnoreCase("PrimeroESO")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=740:1eso&catid=11&Itemid=213067";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else if (opcion.equalsIgnoreCase("SegundoESO")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=741:2eso&catid=11&Itemid=213070";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else if (opcion.equalsIgnoreCase("TerceroESO")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=742:3eso&catid=11&Itemid=213071";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=744:4eso&catid=11&Itemid=213072";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        }
    }
}