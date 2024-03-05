package com.example.eventosfuturos.service.impl;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.eventosfuturos.mapper.UsuarioMapper;
import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InicioSesion extends AsyncTask<String,Object, Usuario> {

    private TaskCompleted listener;

    public InicioSesion(TaskCompleted listener) {
        this.listener = listener;
    }
    @Override
    protected Usuario doInBackground(String... userInfo) {
        try {
            Log.i("Test", "iniciando sesion");
            URL url = new URL("https://proyectoandroidjesuschavero.000webhostapp.com/inicioSesion.php");
            HttpURLConnection clienthttp = (HttpURLConnection) url.openConnection();
            clienthttp = (HttpURLConnection) url.openConnection();
            Log.i("Test", "1");
            //Activamos el método POST
            clienthttp.setRequestMethod("POST");
            clienthttp.setDoOutput(true);
            String params = "email="+userInfo[0]+"&contrasena="+userInfo[1];
            clienthttp.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            Log.i("Test", "2");
            //Pasamos datos al servicio web
            try(OutputStream os = clienthttp.getOutputStream()) {
                byte[] input = params.getBytes("utf-8");
                os.write(input, 0, input.length);
            }catch (Exception e){
                Log.i("error", e.toString());
            }
            Log.i("Test", "hola");
            StringBuilder response = new StringBuilder();
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(clienthttp.getInputStream(), "utf-8"))) {

                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

            }
            Log.i("Test", new JSONObject(String.valueOf(response)).getString("nombre"));
            return new UsuarioMapper().map(String.valueOf(response));

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(Usuario s) {
        super.onPostExecute(s);
        listener.onTaskCompleted(s);
    }
}
