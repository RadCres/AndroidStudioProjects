package com.example.segundoejerciciotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private Button botonGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextEmail);
        botonGuardar = findViewById(R.id.buttonGuardar);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPreferencia();
                System.exit(0);
            }
        });
    }
    private void guardarPreferencia(){
        //Guardo preferencias
        SharedPreferences settings = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("correo", email.getText().toString());
        editor.commit();
        //Recupero preferencias
        String emailValor = settings.getString("correo",email.getText().toString());
        Toast.makeText(getApplicationContext(), emailValor+ " /guardado", Toast.LENGTH_SHORT).show();
    }
}