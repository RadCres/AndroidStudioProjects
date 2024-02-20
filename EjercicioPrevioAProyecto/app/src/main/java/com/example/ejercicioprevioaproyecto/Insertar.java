package com.example.ejercicioprevioaproyecto;

import android.os.AsyncTask;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Insertar extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {
        String datos = params[0];
        HttpURLConnection clienthttp=null;
        OutputStream salida = null;
        try {
            URL url = new URL("https://files.000webhost.com/insertar.php");
            //Establecemos conexión con el servicio web
            clienthttp = (HttpURLConnection) url.openConnection();
            //Activamos el método POST
            clienthttp.setDoOutput(true);
            //Fijamos el tamaño
            clienthttp.setFixedLengthStreamingMode(datos.getBytes().length);
            //Cifrado de datos
            clienthttp.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            //Pasamos datos al servicio web
            salida = new BufferedOutputStream(clienthttp.getOutputStream());
            salida.write(datos.getBytes());
            salida.flush();
            salida.close();
            return null;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
