package com.example.ejercicioreciclaje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  MyRecyclerViewAdapter.ItemClickListener {

        private MyRecyclerViewAdapter adapter;

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ArrayList<String> animalNames = new ArrayList<>();
            animalNames.add("Gato");
            animalNames.add("Perro");
            animalNames.add("León");
            animalNames.add("Gaviota");
            animalNames.add("Toro");

            RecyclerView leon = findViewById(R.id.ListaAnimales);
            leon.setLayoutManager(new LinearLayoutManager(this));
            adapter = new MyRecyclerViewAdapter(this, animalNames);
            adapter.setCLickListener(this);
            leon.setAdapter(adapter);


}


    @Override
    public void onItemClick(View activista, int position) {
        Toast.makeText(this,"Has pulsado en: " +
                        adapter.getItem(position) +
                        " el elemento: " + position,
                Toast.LENGTH_SHORT).show();
    }
}