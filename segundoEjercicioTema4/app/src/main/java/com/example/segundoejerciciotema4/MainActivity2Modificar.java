package com.example.segundoejerciciotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2Modificar extends AppCompatActivity {
    private EditText editTextModif;
    private EditText editTextModifAbajo;
    private Button buttonModif;
    private Button buttonConsultParaModif;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_modificar);

        editTextModif = findViewById(R.id.editTextModificar);
        editTextModifAbajo = findViewById(R.id.editTextModificarAbajo);
        buttonModif = findViewById(R.id.buttonModificar);
        buttonConsultParaModif = findViewById(R.id.buttonConsultarParaModificar);

        buttonConsultParaModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextModif.getText().toString().isEmpty()){
                    Toast.makeText(context, "No existe", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("MyApp", "onClick: Start");
                try {
                        Log.d("MyApp", "onClick: Before consultar");
                        String name = AdapterBD.getInstance(context).consultar(Integer.valueOf(editTextModif.getText().toString()));
                        Log.d("MyApp", "onClick: After consultar");
                        editTextModifAbajo.setText(name.toString());
                        editTextModifAbajo.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.d("MyApp", "onClick: End");
            }
        });
        buttonModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextModif.getText().toString().isEmpty()){
                    Toast.makeText(context, "Esta vacío", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("MyApp", "onClick: Start");
                try {
                    Log.d("MyApp", "onClick: Before modifcar");
                    AdapterBD.getInstance(context).modificar(Integer.valueOf(editTextModif.getText().toString()),editTextModifAbajo.getText().toString());
                    Log.d("MyApp", "onClick: After modificar");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.d("MyApp", "onClick0: End");
            }
        });
    }
}