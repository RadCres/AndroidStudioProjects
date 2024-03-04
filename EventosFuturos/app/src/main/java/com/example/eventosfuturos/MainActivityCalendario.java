package com.example.eventosfuturos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Timestamp;

public class MainActivityCalendario extends AppCompatActivity {
    private Context context = this;
    private Button botonNuevoEvento;
    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_calendario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botonNuevoEvento = findViewById(R.id.buttonNuevoEvento);
        calendarView = findViewById(R.id.calendarView);
       botonNuevoEvento.setOnClickListener(v -> {
           Intent intent = new Intent(context, MainActivityEventos.class);
           intent.putExtra("Date", new Timestamp(calendarView.getDate()).toString());
           startActivity(intent);
       });

    }


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemEventos:
                Intent intent = new Intent(context, MainActivityEventos.class);
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