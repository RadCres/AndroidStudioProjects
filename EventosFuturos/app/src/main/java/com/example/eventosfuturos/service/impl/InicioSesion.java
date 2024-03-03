package com.example.eventosfuturos.service.impl;

import android.os.AsyncTask;

import com.example.eventosfuturos.mapper.UsuarioMapper;
import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.TaskCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InicioSesion extends AsyncTask<Usuario,Object, Usuario> {

    private TaskCompleted listener;

    public InicioSesion(TaskCompleted listener) {
        this.listener = listener;
    }
    @Override
    protected Usuario doInBackground(Usuario... usuario) {
        try {
            URL url = new URL("faltaElPhp");
            //TODO falta enlazar con php
            boolean response = false;
            HttpURLConnection clienteHtp = (HttpURLConnection) url.openConnection();
            InputStream is = clienteHtp.getInputStream();
            InputStreamReader isReader = new InputStreamReader(is,"UTF-8");
            BufferedReader bfr = new BufferedReader(isReader);
            //Si la respuesta es true, devuelvo el usuario
            if(response){
                return usuario[0];
            }else{
                return null;
            }

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
