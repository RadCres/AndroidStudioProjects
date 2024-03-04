package com.example.eventosfuturos.OM;

import com.example.eventosfuturos.model.dto.Evento;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OM_Eventos {
    public void ListaEventos(){
        List<Evento> eventos = new ArrayList<>();
        Evento evento1 = new Evento(Timestamp.valueOf("2024-03-05 10:00:00"), "Concierto en Vivo", "Concierto de rock en el centro de la ciudad", "BandaX");
        Evento evento2 = new Evento(Timestamp.valueOf("2024-03-08 15:30:00"), "Exposición de Arte", "Mostra de pinturas y esculturas contemporáneas", "Artistas Unidos");
        Evento evento3 = new Evento(Timestamp.valueOf("2024-03-12 18:00:00"), "Charla Técnica", "Conferencia sobre nuevas tecnologías", "Tech Talks");
        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);
    }


}
