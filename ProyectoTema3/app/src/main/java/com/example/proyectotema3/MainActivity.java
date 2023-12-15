package com.example.proyectotema3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton iconoTelefono;
    private ImageButton iconoEmail;
    private ImageButton iconoMaps;
    private ImageButton iconoRayuela;
    private ImageButton iconoClassroom;
    private ImageButton iconoWeb;
    private ImageButton icoMoodle;
    private ImageButton icoCulturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconoTelefono = findViewById(R.id.imageButtonTelefono);
        iconoEmail = findViewById(R.id.imageButtonEmail);
        iconoMaps = findViewById(R.id.imageButtonMaps);
        iconoRayuela = findViewById(R.id.imageButtonRayuela);
        iconoClassroom = findViewById(R.id.imageButtonClassroom);
        iconoWeb = findViewById(R.id.imageButtonWeb);
        icoMoodle = findViewById(R.id.imageButtonMoodle);
        icoCulturas = findViewById(R.id.imageButtonCulturas);

        iconoTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentoLlamada = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:924017778"));
                startActivity(intentoLlamada);
            }
        });
        iconoMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String latitud = "38.67735712197755";
                String longittud = "-6.4113897177911285";
                String uri = "geo:" + latitud + "," + longittud + "?q= IES Arroyo Harnina Calle Coria Almendralejo";
                Intent intentoMapa = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));

                startActivity(intentoMapa);
            }
        });
        iconoEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correoDestino = "ies.arroyoharnina@edu.juntaex.es";
                Intent intentoEmail = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + correoDestino));
                intentoEmail.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo");
                intentoEmail.putExtra(Intent.EXTRA_TEXT, "Cuerpo del correo");

                // Inicia la actividad con el intento
                startActivity(intentoEmail);
            }
        });
        iconoRayuela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageName = "es.educarex.rayuela"; // Reemplaza con el nombre del paquete de la aplicación que deseas abrir

                try {
                    Intent intentoRayuela = getPackageManager().getLaunchIntentForPackage(packageName);

                    if (intentoRayuela != null) {
                        startActivity(intentoRayuela);
                    } else {
                        // La aplicación no está instalada, redirige al usuario a la Play Store
                        Intent intentoPlayStore = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=es.educarex.rayuela&pcampaignid=web_share" + packageName));
                        startActivity(intentoPlayStore);
                    }
                } catch (ActivityNotFoundException e) {
                    // Si no se puede abrir la Play Store, maneja la excepción según sea necesario
                    Toast.makeText(getApplicationContext(), "No se pudo abrir la Play Store.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        iconoClassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageName = "com.google.android.apps.classroom";

                try {
                    Intent intentoRayuela = getPackageManager().getLaunchIntentForPackage(packageName);

                    if (intentoRayuela != null) {
                        startActivity(intentoRayuela);
                    } else {
                        // La aplicación no está instalada, redirige al usuario a la Play Store
                        Intent intentoPlayStore = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.android.apps.classroom&pcampaignid=web_share" + packageName));
                        startActivity(intentoPlayStore);
                    }
                } catch (ActivityNotFoundException e) {
                    // Si no se puede abrir la Play Store
                    Toast.makeText(getApplicationContext(), "No se pudo abrir la Play Store.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        iconoWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://iesarroyoharnina.educarex.es/";
                try {
                    // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                    Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intentoUrl); // Asegúrate de iniciar la actividad
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
                }
            }
        });
        icoMoodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageMoodle = "com.moodle.moodlemobile";
                try {
                    Intent intentoMoodle = getPackageManager().getLaunchIntentForPackage(packageMoodle);

                    if (intentoMoodle != null) {
                        startActivity(intentoMoodle);
                    } else {
                        // La aplicación no está instalada, redirige al usuario a la Play Store
                        Intent intentoPlayStore = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.moodle.moodlemobile&pcampaignid=web_share" + packageMoodle));
                        startActivity(intentoPlayStore);
                    }
                } catch (ActivityNotFoundException e) {
                    // Si no se puede abrir la Play Store
                    Toast.makeText(getApplicationContext(), "No se pudo abrir la Play Store.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        icoCulturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity3.class);
                startActivity(intent);

            }
        });

    }


    private void pulsarOpcionDelMenu(String opcion) {
        if (opcion.equalsIgnoreCase("EscolarizacionSecundaria")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=810&Itemid=213497";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } if (opcion.equalsIgnoreCase("EscolarizacionFP")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=940&Itemid=213573";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl2);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String opcion = "";
        switch (item.getItemId()) {
            case R.id.EscolarizacionSecundaria:
                opcion = "EscolarizacionSecundaria";
                pulsarOpcionDelMenu(opcion);

                return true;
            case R.id.EscolarizacionFP:
                opcion = "EscolarizacionFP";
                pulsarOpcionDelMenu(opcion);
                return true;
            case R.id.opcionEso:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                finishActivity(R.layout.activity_main);

                return true;
            case R.id.opcionCalendario:
                Intent intentDos = new Intent(this, MainActivity4.class);
                startActivity(intentDos);
                finishActivity(R.layout.activity_main);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}