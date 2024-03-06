package com.example.eventosfuturos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private Context context = this;
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
            if (iniciarSesion.getText().toString().equals("Registrarse")&&(usuario.getText().toString().isEmpty()||contrasena.getText().toString().isEmpty()||email.getText().toString().isEmpty())){
                Toast.makeText(context, "Rellena los campos vacíos", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (iniciarSesion.getText().toString().equals("Iniciar sesión")&&(contrasena.getText().toString().isEmpty()||email.getText().toString().isEmpty())){
                Toast.makeText(context, "Rellena los campos vacíos", Toast.LENGTH_SHORT).show();
                return;
            }
            if(switchBoxSesion.isChecked()){
                signIn();
            }else{
                Log.i("Loging", "Entra en login");
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
        intent.putExtra("nombre", usuario.getNombre());
        startActivity(intent);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemCerrar:
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}