package com.example.eventosfuturos.model.dto;

import java.util.List;

public class Grupo {
    private String nombre;
    private List<String> emailsAsociados;

    public Grupo(String nombre, List<String> emailsAsociados) {
        this.nombre = nombre;
        this.emailsAsociados = emailsAsociados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getEmailsAsociados() {
        return emailsAsociados;
    }

    public void setEmailsAsociados(List<String> emailsAsociados) {
        this.emailsAsociados = emailsAsociados;
    }
}
