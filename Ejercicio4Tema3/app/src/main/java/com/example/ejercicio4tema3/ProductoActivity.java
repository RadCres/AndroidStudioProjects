package com.example.ejercicio4tema3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProductoActivity extends AppCompatActivity {
private Button botonVolverMain;
    private EditText numero1;
    private EditText numero2;
    private EditText numero3;
    private TextView result;
    private Button botonProd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        botonVolverMain = findViewById(R.id.buttonVolverProd);
        numero1 = findViewById(R.id.editTextNumber);
        numero2 = findViewById(R.id.editTextNumber2);
        numero3 = findViewById(R.id.editTextNumber3);
        result = findViewById(R.id.textViewRes);
        botonProd = findViewById(R.id.buttonProd);

        botonProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultadoSuma = (
                        Double.valueOf(numero1.getText().toString())*
                                Double.valueOf(numero2.getText().toString())*
                                Double.valueOf(numero3.getText().toString())) ;
                result.setText(String.valueOf(resultadoSuma));
            }
        });

        botonVolverMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasarActivityPrincipal = new Intent(v.getContext(), MainActivity.class);
                startActivity(pasarActivityPrincipal);
                finish();
            }
        });
    }
}