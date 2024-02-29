package com.example.eventosfuturos.model.entity;

public class Usuario {
    private Long id;
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
