package com.devco.videojuegos.dominio.puertos;

import com.devco.videojuegos.dominio.modelos.Videojuego;

import java.util.List;
import java.util.Optional;

public interface VideojuegoRepositorio {
    Videojuego guardar(Videojuego videojuego);

    Optional<Videojuego> obtenerPorId(Integer id);

    List<Videojuego> obtenerVideojuegos();

    Optional<Videojuego> actualizar(Integer id, Videojuego videojuego);

    void eliminar(Integer id);
}
