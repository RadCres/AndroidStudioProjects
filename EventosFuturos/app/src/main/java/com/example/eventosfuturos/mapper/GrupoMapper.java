package com.example.eventosfuturos.mapper;

import com.example.eventosfuturos.model.dto.Grupo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GrupoMapper implements Mapper<JSONObject, Grupo> {
    @Override
    public Grupo map(JSONObject jsonObject) {
        try {
            String nombre = jsonObject.getString("nombre");
            //List<String> emailsAsociados = getEmailsAsociadosDesdeJSON(jsonObject);

            return new Grupo(nombre, new ArrayList<>());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> getEmailsAsociadosDesdeJSON(JSONObject jsonObject) throws JSONException {
        List<String> emailsAsociados = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("emailsAsociados");

        for (int i = 0; i < jsonArray.length(); i++) {
            String email = jsonArray.getString(i);
            emailsAsociados.add(email);
        }

        return emailsAsociados;
    }
}