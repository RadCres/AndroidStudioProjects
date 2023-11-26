package com.example.proyectotema3.model;


import java.util.ArrayList;
import java.util.List;

public class NacionalidadOM {

    public static List<Nacionalidad> getList(){
        List<Nacionalidad> nacionalidades= new ArrayList<>();
        String[] paises = {"Portugal", "Rumania", "Marruecos", "Colombia", "Uruguay", "Nicaragua"
                , "Argentina","Ucrania","Venezuela","Honduras", "Italia", "China", "Bolivia"
                , "Brasil"};
        String[] numeroAlumno= {"3", "11", "13", "1", "2", "3", "1","1","4","3", "1", "1", "1", "1"};

        String[] idioma ={"Portugues", "Rumano", "Arabe", "Español", "Español", "Español"
                , "Español","Ucraniano","Español","Español", "Italiano", "Chino", "Español"
                , "Portugues"};

        int[] banderas={1,1,1,1,1,1,1,1,1,1,1,1};

        for (int i = 0; i < paises.length; i++) {
            Nacionalidad nacionalidad = new Nacionalidad.Builder(banderas[i], paises[i])
                    .setNumeroAlumnos(numeroAlumno[i])
                    .setIdiomaOficial(idioma[i]).build();
            nacionalidades.add(nacionalidad);
        }


        return nacionalidades;
    }
}