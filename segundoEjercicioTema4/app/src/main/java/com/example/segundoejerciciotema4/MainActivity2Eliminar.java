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

public class MainActivity2Eliminar extends AppCompatActivity {
    private EditText editTextElimin;
    private Button buttonElimin;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_eliminar);

        editTextElimin = findViewById(R.id.editTextEliminar);
        buttonElimin = findViewById(R.id.buttonEliminar);

        buttonElimin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyApp", "onClick: Start");
                try {
                    if (!editTextElimin.getText().toString().isEmpty()){
                        Log.d("MyApp", "onClick: Before eliminar");
                        AdapterBD.getInstance(context).eliminar(Integer.valueOf(editTextElimin.getText().toString()));
                        Log.d("MyApp", "onClick: After eliminar");
                        Toast.makeText(context, "eliminado", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, "No existe para borrar", Toast.LENGTH_SHORT).show();
                }
                Log.d("MyApp", "onClick: End");
            }
        });
    }

}