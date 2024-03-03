package com.example.eventosfuturos.mapper;

import android.util.Log;

import com.example.eventosfuturos.model.dto.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UsuarioMapper implements Mapper<String,Usuario>{
    //TODO
    @Override
    public Usuario map(String s) {
        try {
            JSONObject result = new JSONObject(s);
            return new Usuario(result.getString("nombre"),result.getString("email"));

        } catch (JSONException e) {
            Log.e("Exception", e.toString() );
            return null;
        }

    }


}
