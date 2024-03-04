package com.example.eventosfuturos.service.impl;

import android.os.AsyncTask;
import android.util.Log;

import com.example.eventosfuturos.mapper.EventoMapper;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GetEventos extends AsyncTask<String,Object, List<Evento>> {
    private TaskCompleted listener;

    public GetEventos(TaskCompleted listener){
        this.listener = listener;
    }

    @Override
    protected List<Evento> doInBackground(String... nombre) {
        try {
            URL url = new URL("https://proyectoandroidjesuschavero.000webhostapp.com/selectEventos.php");
            HttpURLConnection clienthttp = (HttpURLConnection) url.openConnection();
            clienthttp = (HttpURLConnection) url.openConnection();
            //Activamos el método POST
            clienthttp.setRequestMethod("POST");
            clienthttp.setDoOutput(true);
            String params = "nombre="+nombre[0];
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
            JSONArray jsonArray = new JSONArray(String.valueOf(response));
            List<Evento> eventos = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                eventos.add(new EventoMapper().map(jsonObject));
                Log.i("test", eventos.get(i).getTitulo());
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
