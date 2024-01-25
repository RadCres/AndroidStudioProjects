package com.example.segundoejerciciotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2Insertar extends AppCompatActivity {
    private EditText editTextInsert;
    private Button buttonInsert;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_insertar);

        editTextInsert = findViewById(R.id.editTextInsertar);
        buttonInsert = findViewById(R.id.buttonInsertar);


        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextInsert.getText().toString().isEmpty())
                AdapterBD.getInstance(context).insertar(editTextInsert.toString());
            }
        });
    }

}