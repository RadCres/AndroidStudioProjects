package com.example.eventosfuturos;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.eventosfuturos.model.dto.Usuario;
import com.example.eventosfuturos.service.impl.InicioSesion;

public class InicioSesionTest {
    private InicioSesion inicioSesion;
    @Before
    public void init(){
        inicioSesion=new InicioSesion(null);
    }
    @Test
    public void fetch() {
    }

}
