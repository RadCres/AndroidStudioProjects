package com.example.menucontextual;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText miEditColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miEditColor=findViewById(R.id.editTextText);
        registerForContextMenu(miEditColor);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("Elija el color de fondo:");
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menucontextual,menu);
    }
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.opcionRojo:
                miEditColor.setText("Has elegido el Rojo");
                miEditColor.setBackgroundColor(Color.rgb(255,0,0));
                return true;
            case R.id.opcionVerde:
                miEditColor.setText("Has elegido el Verde");
                miEditColor.setBackgroundColor(Color.rgb(0,255,0));
                return true;
            case R.id.opcionAzul:
                miEditColor.setText("Has elegido el Azul");
                miEditColor.setBackgroundColor(Color.rgb(0,0,255));
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }

    }
}