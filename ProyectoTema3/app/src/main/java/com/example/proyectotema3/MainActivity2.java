package com.example.proyectotema3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private static final int MENU_ESO = 1;
    private static final int MENU_BACHILLERATO = 2;

    private TextView ESO;
    private TextView bachillerato;
    private TextView fp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ESO = findViewById(R.id.textViewESO);
        bachillerato = findViewById(R.id.textViewBachillerato);
        fp = findViewById(R.id.textViewFP);
        registerForContextMenu(ESO);
        registerForContextMenu(bachillerato);
        registerForContextMenu(fp);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.textViewESO) {
            // Si el botón ESO está pulsado, inflar el menú contextual de ESO
            getMenuInflater().inflate(R.menu.menucontextualeso_main2, menu);
        } else if (v.getId() == R.id.textViewBachillerato) {
            // Si el botón Bachillerato está pulsado, inflar el menú contextual de Bachillerato
            getMenuInflater().inflate(R.menu.menucontextualbachillerato_main2, menu);
        } else {
            getMenuInflater().inflate(R.menu.menucontextualfp_main2, menu);
        }
    }


    public boolean onContextItemSelected(MenuItem item) {
        String opcion = "";
        switch (item.getItemId()) {
            case R.id.itemPrimero:
                opcion = "PrimeroESO";
                pulsarOpcionDelMenuESO(opcion);
                return true;
            case R.id.itemSegundo:
                opcion = "SegundoESO";
                pulsarOpcionDelMenuESO(opcion);
                return true;
            case R.id.itemTercero:
                opcion = "TerceroESO";
                pulsarOpcionDelMenuESO(opcion);
                return true;
            case R.id.itemCuarto:
                opcion = "CuartoESO";
                pulsarOpcionDelMenuESO(opcion);
                return true;
            case R.id.opcionPrimeroBachillerato:
                opcion = "PrimeroBachilleraro";
                pulsarOpcionDelMenuBachillerato(opcion);
                return true;
            case R.id.opcionSegundoBachillerato:
                opcion = "SegundoBachilleraro";
                pulsarOpcionDelMenuBachillerato(opcion);
                return true;
            case R.id.FPopcion1SA:
                opcion = "1SA";
                pulsarOpcionDelMenuFP(opcion);
                return true;
            case R.id.FPopcion2SA:
                opcion = "2SA";
                pulsarOpcionDelMenuFP(opcion);
                return true;
            case R.id.FPopcion1GA:
                opcion = "1GA";
                pulsarOpcionDelMenuFP(opcion);
                return true;
            case R.id.FPopcion2GA:
                opcion = "2GA";
                pulsarOpcionDelMenuFP(opcion);
                return true;
            case R.id.FPopcion1AF:
                opcion = "1AF";
                pulsarOpcionDelMenuFP(opcion);
                return true;
            case R.id.FPopcion2AF:
                opcion = "2AF";
                pulsarOpcionDelMenuFP(opcion);
                return true;
            case R.id.FPopcion1DAM:
                opcion = "1DAM";
                pulsarOpcionDelMenuFP(opcion);
                return true;
            case R.id.FPopcion2DAM:
                opcion = "2DAM";
                pulsarOpcionDelMenuFP(opcion);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void pulsarOpcionDelMenuESO(String opcion) {
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
        } else if (opcion.equalsIgnoreCase("CuartoESO")) {
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

    private void pulsarOpcionDelMenuBachillerato(String opcion) {
        if (opcion.equalsIgnoreCase("PrimeroBachilleraro")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=740:1eso&catid=11&Itemid=213067";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else if (opcion.equalsIgnoreCase("SegundoBachilleraro")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=751:2-bach&catid=11&Itemid=213469";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void pulsarOpcionDelMenuFP(String opcion) {
        if (opcion.equalsIgnoreCase("1SA")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=757:1fpb&catid=154&Itemid=213080";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else if (opcion.equalsIgnoreCase("2SA")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=758:2fpb&catid=154&Itemid=213081";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else if (opcion.equalsIgnoreCase("1GA")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=759:ga1&catid=154&Itemid=213082";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else if (opcion.equalsIgnoreCase("2GA")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=760:ga2&catid=11&Itemid=213083";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else if (opcion.equalsIgnoreCase("1AF")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=761:1af&catid=154&Itemid=213094";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else if (opcion.equalsIgnoreCase("2AF")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=763:2af&catid=154&Itemid=213084";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else if (opcion.equalsIgnoreCase("1DAM")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=764:1dam&catid=154&Itemid=213085";
            try {
                // Utiliza ACTION_VIEW en lugar de ACTION_WEB_SEARCH
                Intent intentoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentoUrl); // Asegúrate de iniciar la actividad
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se pudo abrir la página web", Toast.LENGTH_SHORT).show();
            }
        } else if (opcion.equalsIgnoreCase("2DAM")) {
            String url = "https://iesarroyoharnina.educarex.es/index.php?option=com_content&view=article&id=765:2dam&catid=154&Itemid=213086";
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