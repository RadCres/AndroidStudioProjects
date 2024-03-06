package com.example.eventosfuturos.service.impl;

import android.os.AsyncTask;

import com.example.eventosfuturos.service.TaskCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SalirDeGrupo extends AsyncTask<String, Object, Boolean> {

    private TaskCompleted listener;

    public SalirDeGrupo(TaskCompleted listener) {
        this.listener = listener;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        try {
            URL url = new URL("https://proyectoandroidjesuschavero.000webhostapp.com/borrarUsuarioGrupo.php");
            HttpURLConnection clienthttp = (HttpURLConnection) url.openConnection();
            // Activamos el método POST
            clienthttp.setRequestMethod("POST");
            clienthttp.setDoOutput(true);

            String params = "email=" + strings[0] + "&nombreGrupo=" + strings[1];
            clienthttp.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Pasamos datos al servicio web
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
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
