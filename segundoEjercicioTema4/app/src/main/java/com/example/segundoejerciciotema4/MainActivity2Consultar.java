package com.example.segundoejerciciotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2Consultar extends AppCompatActivity {
    private EditText editTextConsult;
    private Button buttonConsult;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_consultar);

        editTextConsult = findViewById(R.id.editTextConsultar);
        buttonConsult = findViewById(R.id.buttonConsultar);

        buttonConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextConsult.getText().toString().isEmpty()){
                Toast.makeText(context, "Por favor, ingrese un valor para consultar", Toast.LENGTH_SHORT).show();
                return;
                }
                Log.d("MyApp", "onClick: Start");
                try {
                        Log.d("MyApp", "onClick: Before consultar");
                        int idConsulta = Integer.valueOf(editTextConsult.getText().toString());
                        String name = AdapterBD.getInstance(context).consultar(idConsulta);
                        Log.d("MyApp", "onClick: After consultar");
                        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("miapp",e.getMessage());
                    e.printStackTrace();
                    Toast.makeText(context, "Error al consultar", Toast.LENGTH_SHORT).show();
                }
                Log.d("MyApp", "onClick: End");
            }
        });



    }

}