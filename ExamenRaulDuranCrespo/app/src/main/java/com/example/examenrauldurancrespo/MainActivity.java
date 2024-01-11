package com.example.examenrauldurancrespo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private RadioGroup radio;
    private Button botonEnviarDatos;
    private Context context = this;
    private RadioButton radio12;
    private RadioButton radio14;
    private RadioButton radio16;
    private RadioButton radio18;
    private Intent intent;
    private String edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.editTextNombre);
        radio = findViewById(R.id.radiogp);
        botonEnviarDatos = findViewById(R.id.botonPasarActivity2);
        radio12 = findViewById(R.id.radioButton1);
        radio14 = findViewById(R.id.radioButton2);
        radio16 = findViewById(R.id.radioButton3);
        radio18 = findViewById(R.id.radioButton4);

        botonEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, MainActivity2.class);
                intent.putExtra("nombre", nombre.getText().toString());
                intent.putExtra("edad", getEdad());

                startActivity(intent);
            }
        });

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        setEdad("12");

                        break;
                    case R.id.radioButton2:
                        setEdad("14-16");

                        break;
                    case R.id.radioButton3:
                       setEdad("16-18");

                        break;
                    case R.id.radioButton4:
                       setEdad(">18");

                        break;
                    default:
                        break;
                }
            }
        });

    }

    private String getEdad() {
        return this.edad;
    }

    private void setEdad(String s) {
        this.edad=s;
    }
}