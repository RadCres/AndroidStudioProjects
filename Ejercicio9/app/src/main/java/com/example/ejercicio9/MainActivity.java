package com.example.ejercicio9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView mensajeColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensajeColor= findViewById(R.id.TextViewColor);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater getMenuInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.colorRojo:
                mensajeColor.setText("Has elegido el Rojo");
                mensajeColor.setBackgroundColor(Color.rgb(255,0,0));
                return true;
            case R.id.colorVerde:
                mensajeColor.setText("Has elegido el Verde");
                mensajeColor.setBackgroundColor(Color.rgb(0,255,0));
                return true;
            case R.id.colorAzul:
                mensajeColor.setText("Has elegido el Azul");
                mensajeColor.setBackgroundColor(Color.rgb(0,0,255));
                return true;
            case R.id.colorMorado:
                mensajeColor.setText("Has elegido el Morado");
                mensajeColor.setBackgroundColor(Color.rgb(128, 0, 128));
                return true;
            case R.id.colorBlanco:
                mensajeColor.setText("Has elegido el Blanco");
                mensajeColor.setBackgroundColor(Color.rgb(255, 255, 255));
                return true;
            case R.id.colorNegro:
                mensajeColor.setText("Has elegido el Negro");
                mensajeColor.setBackgroundColor(Color.rgb(0, 0, 0));
                return true;
            case R.id.Jugar:
                Toast.makeText(this, "A jugar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Configurar:
                Toast.makeText(this, "A configurar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Salir:
                finish();
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }

    }

}