package com.example.pruebaexamen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {
        private TextView txt1;
        private TextView txt2;

        private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt1 = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);

        String nombre = getIntent().getStringExtra("Nombre");
        String pais = getIntent().getStringExtra("Pais");
        txt1.setText("Bienvenido "+nombre);
        txt2.setText("Eres de "+pais);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return true;
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String opcion = "";
        switch (item.getItemId()) {
            case R.id.opcionAtras:
                finish();
                return true;
            case R.id.opcionLibros:
                Intent intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}