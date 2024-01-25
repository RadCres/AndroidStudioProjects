package com.example.segundoejerciciotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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
                if (!editTextConsult.getText().toString().isEmpty()){
                    AdapterBD.getInstance(context).consultar(Integer.valueOf(editTextConsult.getText().toString()));
                    Toast.makeText(context, "Consultado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}