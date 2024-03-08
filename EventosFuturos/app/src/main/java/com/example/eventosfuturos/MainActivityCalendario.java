package com.example.eventosfuturos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventosfuturos.adapter.MiAdaptador;
import com.example.eventosfuturos.model.dto.Evento;
import com.example.eventosfuturos.service.TaskCompleted;
import com.example.eventosfuturos.service.impl.GetEventos;
import com.google.android.material.datepicker.DayViewDecorator;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MainActivityCalendario extends AppCompatActivity implements TaskCompleted<List<Evento>>, MiAdaptador.IntemClickListener {
    private Context context = this;
    private Button botonNuevoEvento;
    private CalendarView calendarView;
    private RecyclerView recicler;
    private String selectedDay;
    private List<Evento> eventos = new ArrayList<>();
    private List<Evento> filtered = new ArrayList<>();
    private MiAdaptador miAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        selectedDay = new Timestamp(System.currentTimeMillis()).toString().split(" ")[0];
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_calendario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botonNuevoEvento = findViewById(R.id.buttonNuevoEvento);
        calendarView = findViewById(R.id.calendarView);
        recicler = findViewById(R.id.recicler);
        setCurrentDate();
        botonNuevoEvento.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivityEventos.class);
            intent.putExtra("Date", selectedDay);
            startActivity(intent);
        });

        miAdaptador = new MiAdaptador(this, filtered);
        recicler = findViewById(R.id.recicler);
        recicler.setLayoutManager(new LinearLayoutManager(this));
        recicler.setAdapter(miAdaptador);
        miAdaptador.setClickListener(this);
        fetchEventos();
    }

    private void setCurrentDate(){
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            recicler.setVisibility(View.VISIBLE);
            String  curDate = String.valueOf(dayOfMonth);
            String  Year = String.valueOf(year);
            String  Month = String.valueOf(month+1);
            selectedDay=Year+"-"+Month+"-"+curDate;
            List<Evento> auxiliar = new ArrayList<>();
            auxiliar = eventos.stream().filter(evento->{
                Timestamp fecha = evento.getFecha();
                String fechaString = fecha.toString().split(" ")[0];
                String[] fechaArray = fechaString.split("-");
                String anio = fechaArray[0];
                int mes = Integer.parseInt(fechaArray[1]);
                int dia = Integer.parseInt(fechaArray[2]);

                if(Year.equals(fechaArray[0])&&month+1==mes&&dia==dayOfMonth){
                    Log.i("ano", anio+"|"+year);
                    Log.i("mes", mes+"|"+(month+1));
                    Log.i("dia", dia+"|"+dayOfMonth);
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
            Log.i("longitud lista", auxiliar.size()+"");
            filtered.clear();
            filtered.addAll(auxiliar);
            miAdaptador.notifyDataSetChanged();
        });
    }

    private void fetchEventos(){
        GetEventos getEventos = new GetEventos(this);
        SharedPreferences prefs
                =getSharedPreferences(getString(R.string.app_name),
                Context.MODE_PRIVATE);
        String value = prefs.getString("email", "");
        getEventos.execute(value);
    }


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemCerrar:
                SharedPreferences prefs =
                        getSharedPreferences(getString(R.string.app_name),
                                Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onTaskCompleted(List<Evento> eventos) {
        this.eventos=eventos;
    }

    @Override
    public void onClickSelected(View vista, int position) {

    }
}