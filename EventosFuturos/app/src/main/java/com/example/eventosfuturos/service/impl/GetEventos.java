package com.example.eventosfuturos.service.impl;

import android.os.AsyncTask;

import com.example.eventosfuturos.mapper.UsuarioMapper;
import com.example.eventosfuturos.model.dto.Evento;
import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class GetEventos extends AsyncTask<Usuario,Object, List<Evento>> {
    private TaskCompleted listener;

    public GetEventos(TaskCompleted listener){
        this.listener = listener;
    }

    @Override
    protected List<Evento> doInBackground(Usuario... usuarios) {
        try {
            URL url = new URL("faltaElPhp");
            //Hacer php
            HttpURLConnection clienteHtp = (HttpURLConnection) url.openConnection();
            InputStream is = clienteHtp.getInputStream();
            InputStreamReader isReader = new InputStreamReader(is,"UTF-8");
            BufferedReader bfr = new BufferedReader(isReader);

            return new UsuarioMapper().map(bfr.readLine());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(List<Evento> eventos) {
        super.onPostExecute(eventos);
        listener.onTaskCompleted(eventos);
    }
}
