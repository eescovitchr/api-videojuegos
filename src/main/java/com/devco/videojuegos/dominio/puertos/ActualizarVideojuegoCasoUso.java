package com.devco.videojuegos.dominio.puertos;

import com.devco.videojuegos.dominio.modelos.Videojuego;

import java.util.Optional;

public interface ActualizarVideojuegoCasoUso {
    Optional<Videojuego> actualizarVideojuego(Integer id, Videojuego videojuegoActualizado);
}
