package com.devco.videojuegos.aplicacion.casosuso;

import com.devco.videojuegos.dominio.modelos.Videojuego;
import com.devco.videojuegos.dominio.puertos.ObtenerVideojuegoCasoUso;
import com.devco.videojuegos.dominio.puertos.VideojuegoRepositorio;

import java.util.List;
import java.util.Optional;

public class ObtenerVideojuegoCasoUsoAdaptador implements ObtenerVideojuegoCasoUso {

    private final VideojuegoRepositorio videojuegoRepositorio;

    public ObtenerVideojuegoCasoUsoAdaptador(VideojuegoRepositorio videojuegoRepositorio) {
        this.videojuegoRepositorio = videojuegoRepositorio;
    }

    @Override
    public Optional<Videojuego> obtenerVideojuegoPorId(Integer id) {
        return videojuegoRepositorio.obtenerPorId(id);
    }

    @Override
    public List<Videojuego> obtenerVideojuegos() {
        return videojuegoRepositorio.obtenerVideojuegos();
    }
}
