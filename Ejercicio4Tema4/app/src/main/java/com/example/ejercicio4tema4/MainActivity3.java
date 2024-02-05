package com.example.ejercicio4tema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private AdapterBaseDatos adapterBD;
    private Context context = this;
    private TextView textViewDATOS;
    private Button buttonMod;
    private EditText editTextEma;
    private EditText editTextTelefo;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textViewDATOS = findViewById(R.id.textView3);
        buttonMod = findViewById(R.id.buttonMod);
        editTextEma = findViewById(R.id.editTextEmail);
        editTextTelefo = findViewById(R.id.editTextPhone);

        adapterBD = AdapterBaseDatos.getInstance(context);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main3,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.OpcionConsultar:
                Intent intent = getIntent();
                if (intent != null && intent.hasExtra("nombreEmpleado")) {
                    String datos = adapterBD.consultarTodosLosDatos(Integer.valueOf(intent.getStringExtra("nombreEmpleado")));
                    textViewDATOS.setText(datos);
                } else {
                    Toast.makeText(this, "No se proporcionó el número de empleado", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.OpcionModificar:
                Intent intentDos = getIntent();
                String email= adapterBD.getEmail(Integer.valueOf(intentDos.getStringExtra("nombreEmpleado")));
                Intent intentTres = getIntent();
                String telef = adapterBD.getTelefono(Integer.valueOf(intentTres.getStringExtra("nombreEmpleado")));
                editTextEma.setText(email);
                editTextTelefo.setText(telef);

                buttonMod.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adapterBD.setEmailYTelefono(editTextEma.getText().toString(),editTextTelefo.getText().toString(),Integer.valueOf(intentDos.getStringExtra("nombreEmpleado")));
                    }
                });
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}