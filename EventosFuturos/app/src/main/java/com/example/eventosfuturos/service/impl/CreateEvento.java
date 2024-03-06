package com.example.eventosfuturos.service.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.example.eventosfuturos.R;
import com.example.eventosfuturos.mapper.UsuarioMapper;
import com.example.eventosfuturos.model.dto.Evento;
import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CreateEvento extends AsyncTask<Evento,Object, Boolean> {

    private TaskCompleted listener;

    public CreateEvento(TaskCompleted listener){
        this.listener = listener;
    }
    @Override
    protected Boolean doInBackground(Evento... eventos) {
        try {
            URL url = new URL("https://proyectoandroidjesuschavero.000webhostapp.com/createEvento.php");
            HttpURLConnection clienthttp = (HttpURLConnection) url.openConnection();
            clienthttp = (HttpURLConnection) url.openConnection();
            //Activamos el método POST
            clienthttp.setRequestMethod("POST");
            clienthttp.setDoOutput(true);
            Evento evento = eventos[0];
            String params = "fecha=" + evento.getFecha().toString() + "&titulo=" + evento.getTitulo() + "&descripcion=" + evento.getDescripcion() + "&nombreGrupo=" + evento.getNombreGrupo();//+"&nombreUsuario="+;
            clienthttp.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //Pasamos datos al servicio web
            try (OutputStream os = clienthttp.getOutputStream()) {
                byte[] input = params.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            StringBuilder response = new StringBuilder();
            String responseLine;
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(clienthttp.getInputStream(), "utf-8"))) {

                responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

            }
            Log.i("Test", String.valueOf(response));
            JSONObject jsonObject = new JSONObject(String.valueOf(response));
            return jsonObject.getBoolean("message");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(Boolean response) {
        super.onPostExecute(response);
        listener.onTaskCompleted(response);
    }
}
