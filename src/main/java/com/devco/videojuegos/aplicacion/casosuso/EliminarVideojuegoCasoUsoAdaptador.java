package com.devco.videojuegos.aplicacion.casosuso;

import com.devco.videojuegos.dominio.puertos.EliminarVideojuegoCasoUso;
import com.devco.videojuegos.dominio.puertos.VideojuegoRepositorio;

public class EliminarVideojuegoCasoUsoAdaptador implements EliminarVideojuegoCasoUso {
    private final VideojuegoRepositorio videojuegoRepositorio;

    public EliminarVideojuegoCasoUsoAdaptador(VideojuegoRepositorio videojuegoRepositorio) {
        this.videojuegoRepositorio = videojuegoRepositorio;
    }

    @Override
    public void eliminarVideojuego(Integer id) {
        videojuegoRepositorio.eliminar(id);
    }
}
