package com.example.ejercicio4tema3;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button botonSumar;
    private Button botonProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonSumar = findViewById(R.id.buttonSumar);
        botonProducto = findViewById(R.id.buttonProducto);

        botonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasarActivitySumar = new Intent(v.getContext(), SumarActivity.class);
                startActivity(pasarActivitySumar);

            }
        });

        botonProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasarActivityProducto = new Intent(v.getContext(), ProductoActivity.class);
                startActivity(pasarActivityProducto);
                finish();
            }
        });
    }
}
