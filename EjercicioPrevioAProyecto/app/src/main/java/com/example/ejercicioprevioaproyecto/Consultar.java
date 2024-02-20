package com.example.ejercicioprevioaproyecto;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Consultar extends AsyncTask<Object, Object, String> {
    String linea = null;
    private TaskCompleted listener;

    public Consultar(TaskCompleted listener){
        this.listener =listener;
    }

    @Override
    protected String doInBackground(Object... objects) {
        URL url = null;
        try {
            url = new URL("https://knobbier-model.000webhostapp.com/seleccionar.php");
            //Establecemos conexión con el servicio web
            HttpURLConnection clientehttp = (HttpURLConnection) url.openConnection();
            //Leemos el string que nos devuelve el webservice
            InputStream is = clientehttp.getInputStream();
            InputStreamReader isReader = new InputStreamReader(is, "UTF-8");
            BufferedReader reader = new BufferedReader(isReader);
            //En esta variable tenemos el resultado
            linea = reader.readLine();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    protected void onPostExecute(String s){
        super.onPostExecute(s);
        listener.onTaskCompleted(linea);
    }


}
