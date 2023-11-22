package com.example.ejercicioclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner miSpinner;
ArrayList<Contactos> misContactos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        misContactos.add(new Contactos("Pepe","C/Perdida, Almendralejor"));
        misContactos.add(new Contactos("Ron","C/Cola, Almendralejor"));

        MiAdaptador miada = new MiAdaptador(this,R.layout.elementospinner,misContactos);
        miada.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        miSpinner.setAdapter();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}