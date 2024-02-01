package com.example.segundoejerciciotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemConsulta:
                intent = new Intent(this, MainActivity2Consultar.class);
                startActivity(intent);

                return true;
            case R.id.itemAlta:
                intent = new Intent(this, MainActivity2Insertar.class);
                startActivity(intent);

                return true;

            case R.id.itemEliminar:
                intent = new Intent(this, MainActivity2Eliminar.class);
                startActivity(intent);

                return true;
            case R.id.itemModificar:
                intent = new Intent(this, MainActivity2Modificar.class);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}