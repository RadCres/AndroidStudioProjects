package com.example.eventosfuturos.mapper;

import com.example.eventosfuturos.model.dto.Evento;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;

public class EventoMapper implements Mapper<JSONObject, Evento>{

    @Override
    public Evento map(JSONObject jsonObject) {
        try {
            return new Evento(Timestamp.valueOf(jsonObject.getString("fecha")),jsonObject.getString("titulo"),jsonObject.getString("descripcion"),jsonObject.getString("nombre"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
