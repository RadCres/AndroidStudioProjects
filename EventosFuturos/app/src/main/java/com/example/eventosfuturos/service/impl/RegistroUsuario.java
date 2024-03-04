package com.example.eventosfuturos.service.impl;

import android.os.AsyncTask;
import android.util.Log;

import com.example.eventosfuturos.mapper.UsuarioMapper;
import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RegistroUsuario extends AsyncTask<String,Object, Usuario> {
    private TaskCompleted listener;

    public RegistroUsuario(TaskCompleted listener) {
        this.listener = listener;
    }


    @Override
    protected Usuario doInBackground(String... strings) {
        try {
            URL url = new URL("https://proyectoandroidjesuschavero.000webhostapp.com/registrarUsuario.php");
            HttpURLConnection clienthttp = (HttpURLConnection) url.openConnection();
            clienthttp = (HttpURLConnection) url.openConnection();
            //Activamos el método POST
            clienthttp.setRequestMethod("POST");
            clienthttp.setDoOutput(true);
            String params = "nombre="+strings[0]+"&email="+strings[1]+"&contrasena="+strings[2];
            clienthttp.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            //Pasamos datos al servicio web
            try(OutputStream os = clienthttp.getOutputStream()) {
                byte[] input = params.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            StringBuilder response = new StringBuilder();
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(clienthttp.getInputStream(), "utf-8"))) {

                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

            }
            Log.i("Test", String.valueOf(response));
            return new UsuarioMapper().map(String.valueOf(response));

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(Usuario usuario) {
        super.onPostExecute(usuario);
        listener.onTaskCompleted(usuario);
    }
}
