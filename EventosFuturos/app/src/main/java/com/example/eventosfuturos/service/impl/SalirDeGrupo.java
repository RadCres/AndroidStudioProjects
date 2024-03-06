package com.example.eventosfuturos.service.impl;

import android.os.AsyncTask;
import android.util.Log;

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

public class SalirDeGrupo extends AsyncTask<Void, Object, Boolean> {

    private TaskCompleted listener;
    private String email;
    private String nombreGrupo;

    public SalirDeGrupo(TaskCompleted listener, String email, String nombreGrupo) {
        this.listener = listener;
        this.email = email;
        this.nombreGrupo = nombreGrupo;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            URL url = new URL("https://proyectoandroidjesuschavero.000webhostapp.com/salirDeGrupo.php");
            HttpURLConnection clienthttp = (HttpURLConnection) url.openConnection();
            // Activamos el método POST
            clienthttp.setRequestMethod("POST");
            clienthttp.setDoOutput(true);

            String params = "email=" + email + "&nombreGrupo=" + nombreGrupo;
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

            Log.i("Test", String.valueOf(response));
            JSONObject jsonObject = new JSONObject(String.valueOf(response));
            try {
                return jsonObject.getBoolean("message");
            } catch (Exception e) {
                return null;
            }

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
