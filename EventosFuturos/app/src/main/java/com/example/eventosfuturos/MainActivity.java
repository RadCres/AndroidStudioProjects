package com.example.eventosfuturos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;
import com.example.eventosfuturos.service.impl.InicioSesion;
import com.example.eventosfuturos.service.impl.RegistroUsuario;

public class MainActivity extends AppCompatActivity implements TaskCompleted<Usuario> {
    private EditText usuario,contrasena,email;
    private Button iniciarSesion;
    private TextView contrasenaOlvidada;
    private Switch switchBoxSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.editTextUsuario);
        email = findViewById(R.id.EditTextEmail);
        contrasena = findViewById(R.id.editTextPassword);
        iniciarSesion = findViewById(R.id.buttonIniciarSesion);
        switchBoxSesion = findViewById(R.id.switchInicio);
        contrasenaOlvidada = findViewById(R.id.textViewContraseñaOlvidada);
        setLogInListener();
        setSwitchBoxBehaviour();
    }

    private void setSwitchBoxBehaviour() {
        switchBoxSesion.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked == true){
                switchBoxSesion.setText("Registrarse");
                usuario.setVisibility(View.VISIBLE);
                iniciarSesion.setText("Registrarse");
            }else {
                switchBoxSesion.setText("Iniciar Sesión");
                usuario.setVisibility(View.INVISIBLE);
                iniciarSesion.setText("Iniciar sesión");
            }
        });
    }

    private void setLogInListener() {
        iniciarSesion.setOnClickListener(v -> {
            if(switchBoxSesion.isChecked()){
                signIn();
            }else{
                logIn();
            }
        });
    }

    private void logIn(){
        InicioSesion inicioSesion = new InicioSesion(this);
        inicioSesion.execute(email.getText().toString(),contrasena.getText().toString());
    }

    private void signIn(){
        RegistroUsuario registroUsuario = new RegistroUsuario(this);
        registroUsuario.execute(usuario.getText().toString(),email.getText().toString(),contrasena.getText().toString());
    }

    @Override
    public void onTaskCompleted(Usuario usuario) {
        if(usuario==null) {
            Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, usuario.getNombre(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ResumenActivity.class);
        startActivity(intent);

    }
}