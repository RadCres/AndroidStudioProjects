package com.example.eventosfuturos.model.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Evento {
    private Timestamp fecha;
    private String titulo;
    private String descripcion;
    private String nombreGrupo;

    public Evento(Date fecha, String titulo, String descripcion, String nombreGrupo) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreGrupo = nombreGrupo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
}
