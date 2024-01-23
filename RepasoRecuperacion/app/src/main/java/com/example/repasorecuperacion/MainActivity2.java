package com.example.repasorecuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private String informacionRelleno = "La identidad digital es la imagen que proyectamos ante  los demás a través de Internet. Esta se genera a partir de:\n" +
            "Aquella aportada voluntariamente por nosotros mismo.\n" +
            "La que es aportada por otras personas.\n" +
            "La información generada automáticamente.\n" +
            "No siempre la imagen que proyectas en Internet se corresponde con la que tienes fuera de la Red.\n" +
            "La privacidad es un derecho y un factor de autoprotección.";
    private TextView textViewInformacion;
    private TextView nombreRecibido;
    private TextView rangoRecibido;
    private Context context= this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewInformacion = findViewById(R.id.textViewInformacion);
        textViewInformacion.setText(informacionRelleno);
        nombreRecibido = findViewById(R.id.textViewNombreRecibido);
        rangoRecibido = findViewById(R.id.textViewRangoRecibido);



        Intent intent = getIntent();
        if (intent!=null){
            String mensaje = intent.getStringExtra("nombre");
            String rango = intent.getStringExtra("edad");
            nombreRecibido.setText(mensaje);
            rangoRecibido.setText(rango);
        }



    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemConsejos:
                Intent intent = new Intent(context, MainActivity3.class);
                startActivity(intent);
                return true;
            case R.id.itemCerrar:
                //System.exit(0);
                finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}