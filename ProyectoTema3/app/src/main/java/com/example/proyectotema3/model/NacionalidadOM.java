package com.example.proyectotema3.model;


import android.media.Image;

import com.example.proyectotema3.R;

import java.util.ArrayList;
import java.util.List;

public class NacionalidadOM {

    public static List<Nacionalidad> getList() {
        List<Nacionalidad> nacionalidades = new ArrayList<>();
        String[] paises = {"Portugal", "Rumania", "Marruecos", "Colombia", "Uruguay", "Nicaragua", "Argentina",
                "Ucrania", "Venezuela", "Honduras", "Italia", "China", "Bolivia", "Brasil"};
        String[] numeroAlumno = {"3", "11", "13", "1", "2", "3", "1", "1", "4", "3", "1", "1", "1", "1"};

        String[] idioma = {"Portugues", "Rumano", "Árabe", "Español", "Español uruaguayo", "Español nicaragüense", "Español",
                "Ucraniano", "Español venezolano", "Español", "Italiano", "Chino", "Español", "Portugues"};

        int[] banderas = {R.drawable.portugal_flags_flag_17054, R.drawable.romania_flags_flag_17057, R.drawable.morocco_flags_flag_17039, R.drawable.colombia_flags_flag_16986, R.drawable.uruguay_flags_flag_17081, R.drawable.nicaraguaflag_6444, R.drawable.argentina_flags_flag_16969,
                R.drawable.ukraine_flags_flag_17076, R.drawable.venezuela_flags_flag_17083, R.drawable.honduras_flags_flag_17008, R.drawable.italy_flags_flag_17018, R.drawable.china_flags_flag_16985, R.drawable.flagofbolivia_6581, R.drawable.brazil_flags_flag_16979};

        for (int i = 0; i < paises.length; i++) {
            Nacionalidad nacionalidad = new Nacionalidad.Builder(banderas[i], paises[i])
                    .setNumeroAlumnos(numeroAlumno[i])
                    .setIdiomaOficial(idioma[i]).build();
                    nacionalidades.add(nacionalidad);
        }


        return nacionalidades;
    }
}