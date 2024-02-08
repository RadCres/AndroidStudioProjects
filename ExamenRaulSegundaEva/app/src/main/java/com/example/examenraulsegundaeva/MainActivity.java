package com.example.examenraulsegundaeva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonPasar;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(context, "Bienvenido al huerto Harnina", Toast.LENGTH_LONG).show();

        buttonPasar = findViewById(R.id.buttonPasarActivity2);

        buttonPasar.setOnClickListener(v -> {
            Intent intentActivity2 = new Intent(v.getContext(),MainActivity2.class);
            startActivity(intentActivity2);
        });
    }
}
