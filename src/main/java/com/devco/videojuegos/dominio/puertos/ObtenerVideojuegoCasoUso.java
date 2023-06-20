package com.devco.videojuegos.dominio.puertos;

import com.devco.videojuegos.dominio.modelos.Videojuego;

import java.util.List;
import java.util.Optional;

public interface ObtenerVideojuegoCasoUso {
    Optional<Videojuego> obtenerVideojuegoPorId(Integer id);

    List<Videojuego> obtenerVideojuegos();
}
