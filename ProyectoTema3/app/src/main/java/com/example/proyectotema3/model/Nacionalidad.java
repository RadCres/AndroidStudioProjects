package com.example.proyectotema3.model;

public class Nacionalidad {
    private int bandera;
    private String pais;
    private String numeroAlumnos;
    private String idiomaOficial;

    private Nacionalidad(int bandera, String pais) {
        this.bandera = bandera;
        this.pais = pais;
    }

    private void setNumeroAlumnos(String numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    private void setIdiomaOficial(String idiomaOficial) {
        this.idiomaOficial = idiomaOficial;
    }

    private void setBandera(int bandera) {
        this.bandera = bandera;
    }

    public static class Builder {
        private int bandera;
        private String pais;
        private String numeroAlumnos;
        private String idiomaOficial;

        public Builder(int bandera, String pais) {
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

        public Builder setBandera(int bandera) {
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

    public int getBandera() {
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