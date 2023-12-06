package com.example.proyectotema3.model;

import android.media.Image;

public class Nacionalidad {
    private Image bandera;
    private String pais;
    private String numeroAlumnos;
    private String idiomaOficial;

    private Nacionalidad(Image bandera, String pais) {
        this.bandera = bandera;
        this.pais = pais;
    }

    private void setNumeroAlumnos(String numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    private void setIdiomaOficial(String idiomaOficial) {
        this.idiomaOficial = idiomaOficial;
    }

    private void setBandera(Image bandera) {
        this.bandera = bandera;
    }

    public static class Builder {
        private Image bandera;
        private String pais;
        private String numeroAlumnos;
        private String idiomaOficial;

        public Builder(Image bandera, String pais) {
            this.bandera = bandera;
            this.pais = pais;
            this.numeroAlumnos = "0";
            this.idiomaOficial = "NS";
        }

        public Builder setNumeroAlumnos(String numeroAlumnos) {
            this.numeroAlumnos = numeroAlumnos;
            return this;
        }

        public Builder setIdiomaOficial(String idiomaOficial) {
            this.idiomaOficial = idiomaOficial;
            return this;
        }

        public Builder setBandera(Image bandera) {
            this.bandera = bandera;
            return this;
        }

        public Nacionalidad build() {
            Nacionalidad nacionalidad = new Nacionalidad(this.bandera, this.pais);
            nacionalidad.setIdiomaOficial(this.idiomaOficial);
            nacionalidad.setNumeroAlumnos(this.numeroAlumnos);
            nacionalidad.setBandera(this.bandera);
            return nacionalidad;
        }

    }

    public Image getBandera() {
        return bandera;
    }

    public String getPais() {
        return pais;
    }

    public String getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public String getIdiomaOficial() {
        return idiomaOficial;
    }

}