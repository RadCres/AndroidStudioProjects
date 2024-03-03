package com.example.eventosfuturos.service.impl;

import android.os.AsyncTask;

import com.example.eventosfuturos.mapper.UsuarioMapper;
import com.example.eventosfuturos.model.dto.Evento;
import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetEventos extends AsyncTask<Usuario,Object, List<Evento>> {
    private TaskCompleted listener;

    public GetEventos(TaskCompleted listener){
        this.listener = listener;
    }

    @Override
    protected List<Evento> doInBackground(Usuario... usuarios) {
        try {
            URL url = new URL("https://proyectoandroidjesuschavero.000webhostapp.com/inicioSesion.php");
            HttpURLConnection clienthttp = (HttpURLConnection) url.openConnection();
            clienthttp = (HttpURLConnection) url.openConnection();
            //Activamos el método POST
            clienthttp.setRequestMethod("POST");
            clienthttp.setDoOutput(true);
            String params = "email="+usuarios[0];
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
            JSONArray jsonArray = new JSONArray(response);
            List<Evento> eventos = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // TODO Evento evento = new Evento(jsonObject.getString("titulo"));
                Evento evento = new Evento();
                eventos.add(evento);
            }
            return eventos;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(List<Evento> eventos) {
        super.onPostExecute(eventos);
        listener.onTaskCompleted(eventos);
    }
}
