package com.example.segundoejerciciotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2Modificar extends AppCompatActivity {
    private EditText editTextModificar;
    private Button buttonModificar;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_modificar);
    }
}