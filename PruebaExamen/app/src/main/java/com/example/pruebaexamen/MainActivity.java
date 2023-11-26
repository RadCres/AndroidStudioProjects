package com.example.pruebaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spBandera;
    private Context cont = this;
    private String[] countries = {"España", "Francia", "Portugal"};
    private int[] flags = {R.drawable.spain, R.drawable.francia, R.drawable.portugal};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spBandera = findViewById(R.id.spinnerBandera);
        Adaptador adapter = new Adaptador(this, countries, flags);
        spBandera.setAdapter(adapter);


        darClick();
    }


    private void darClick() {
        spBandera.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch (adapterView.getId()) {
            case R.id.spinnerBandera:
                Toast.makeText(cont, countries[position], Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}