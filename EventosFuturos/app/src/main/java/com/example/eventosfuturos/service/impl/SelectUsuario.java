package com.example.eventosfuturos.service.impl;

import android.os.AsyncTask;
import com.example.eventosfuturos.mapper.UsuarioMapper;
import com.example.eventosfuturos.model.entity.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SelectUsuario extends AsyncTask<Object,Object, Usuario> {
    private TaskCompleted listener;

    public SelectUsuario(TaskCompleted listener) {
        this.listener = listener;
    }

    @Override
    protected Usuario doInBackground(Object... objects) {
        try {
            URL url = new URL("faltaElPhp");
            //TODO falta enlazar con php
            HttpURLConnection clienteHtp = (HttpURLConnection) url.openConnection();
            InputStream is = clienteHtp.getInputStream();
            InputStreamReader isReader = new InputStreamReader(is,"UTF-8");
            BufferedReader bfr = new BufferedReader(isReader);
            //TODO hacer parametros para seleccionar por email y contraseña, y no pillar todos
            return new UsuarioMapper().map(bfr.readLine());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(Usuario s) {
        super.onPostExecute(s);
        listener.onTaskCompleted(s);
    }
}
