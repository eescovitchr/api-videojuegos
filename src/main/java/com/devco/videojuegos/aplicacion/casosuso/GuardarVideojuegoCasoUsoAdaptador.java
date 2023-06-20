package com.devco.videojuegos.aplicacion.casosuso;

import com.devco.videojuegos.dominio.modelos.Videojuego;
import com.devco.videojuegos.dominio.puertos.VideojuegoRepositorio;

public class GuardarVideojuegoCasoUsoAdaptador implements com.devco.videojuegos.dominio.puertos.GuardarVideojuegoCasoUso {
    private final VideojuegoRepositorio videojuegoRepositorio;

    public GuardarVideojuegoCasoUsoAdaptador(VideojuegoRepositorio videojuegoRepositorio) {
        this.videojuegoRepositorio = videojuegoRepositorio;
    }

    @Override
    public Videojuego guardarVideojuego(Videojuego videojuego) {
        return this.videojuegoRepositorio.guardar(videojuego);
    }
}
