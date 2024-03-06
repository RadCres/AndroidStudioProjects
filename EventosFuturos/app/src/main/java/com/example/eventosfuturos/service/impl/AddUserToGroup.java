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

public class AddUserToGroup extends AsyncTask<String,Object, Boolean> {
    private TaskCompleted listener;

    public AddUserToGroup(TaskCompleted listener) {
        this.listener = listener;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        try {
            URL url = new URL("https://proyectoandroidjesuschavero.000webhostapp.com/addUserToGroup.php");
            HttpURLConnection clienthttp = (HttpURLConnection) url.openConnection();
            clienthttp = (HttpURLConnection) url.openConnection();
            //Activamos el método POST
            clienthttp.setRequestMethod("POST");
            clienthttp.setDoOutput(true);
            String params = "nombreGrupo=" + strings[0] + "&email=" + strings[1];
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
            try{
                return jsonObject.getBoolean("message");
            }catch (Exception e){
                return false;
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
