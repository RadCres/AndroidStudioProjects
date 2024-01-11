package com.example.repasorecuperacion;

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

    private EditText editTextNombre;
    private RadioGroup radioGroup;
    private RadioButton radioButton12;
    private RadioButton radioButton14;
    private RadioButton radioButton16;
    private RadioButton radioButton18;
    private Button botonEnviar;
    private Context context =this;
    private String rangoEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.editTextNombre);
        radioButton12 = findViewById(R.id.radioButton1214);
        radioButton14 = findViewById(R.id.radioButton1416);
        radioButton16 = findViewById(R.id.radioButton1618);
        radioButton18 = findViewById(R.id.radioButton18);
        botonEnviar = findViewById(R.id.buttonEnviar);
        radioGroup = findViewById(R.id.radioGroupEdades);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton1214:
                        rangoEdad = radioButton12.getText().toString();
                        break;
                    case R.id.radioButton1416:
                        rangoEdad = radioButton14.getText().toString();
                        break;
                    case R.id.radioButton1618:
                        rangoEdad = radioButton16.getText().toString();
                        break;
                    case R.id.radioButton18:
                        rangoEdad = radioButton18.getText().toString();
                        break;
                    default:
                        break;
                }
            }
        });

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity2.class);
                intent.putExtra("nombre", editTextNombre.getText().toString());
                intent.putExtra("edad", rangoEdad);
                startActivity(intent);
            }
        });
    }
}