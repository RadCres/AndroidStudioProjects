package com.example.ejercicio4formulario;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView enlaceWeb;
private Button botonAceptar;
private Button botonCancelar;
private EditText nombre;
private EditText apellidos;
private EditText email;
private EditText mensaje;
private CheckBox suscripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enlaceWeb=findViewById(R.id.textViewEnlaceWeb);
        //Subarayar TextView
        enlaceWeb.setPaintFlags(enlaceWeb.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        botonAceptar= findViewById(R.id.buttonConfirmar);
        botonCancelar = findViewById(R.id.buttonCancelar);
        nombre = findViewById(R.id.editTextNombre);
        apellidos = findViewById(R.id.editTextApellidos);
        email = findViewById(R.id.editTextEmail);
        mensaje = findViewById(R.id.editTextMensaje);
        suscripcion = findViewById(R.id.checkBoxSusc);

        botonCancelar();
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater getMenuInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.opcionMenuHola:
                Toast.makeText(this, "Hola",Toast.LENGTH_LONG).show();
                return true;
            case R.id.opcionMenuAdios:
                Toast.makeText(this, "Adiós",Toast.LENGTH_LONG).show();
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }
    public void botonCancelar(){
        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText("");
                apellidos.setText("");
                email.setText("");
                mensaje.setText("");
                suscripcion.setChecked(false);
                Toast.makeText(MainActivity.this, "Operación cancelada", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void abrirEnlaceWeb(View view) {
        String url = "https://iesarroyoharnina.educarex.es/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);

    }
}