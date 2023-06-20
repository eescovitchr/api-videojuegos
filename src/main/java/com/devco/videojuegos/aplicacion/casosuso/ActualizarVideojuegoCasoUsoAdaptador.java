package com.devco.videojuegos.aplicacion.casosuso;

import com.devco.videojuegos.dominio.modelos.Videojuego;
import com.devco.videojuegos.dominio.puertos.ActualizarVideojuegoCasoUso;
import com.devco.videojuegos.dominio.puertos.VideojuegoRepositorio;

import java.util.Optional;

public class ActualizarVideojuegoCasoUsoAdaptador implements ActualizarVideojuegoCasoUso {
    private final VideojuegoRepositorio videojuegoRepositorio;

    public ActualizarVideojuegoCasoUsoAdaptador(VideojuegoRepositorio videojuegoRepositorio) {
        this.videojuegoRepositorio = videojuegoRepositorio;
    }

    @Override
    public Optional<Videojuego> actualizarVideojuego(Integer id, Videojuego videojuegoActualizado) {

        return videojuegoRepositorio.actualizar(id, videojuegoActualizado);
    }
}
