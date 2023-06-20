package com.devco.videojuegos.aplicacion.servicios;

import com.devco.videojuegos.dominio.modelos.Videojuego;
import com.devco.videojuegos.dominio.puertos.ActualizarVideojuegoCasoUso;
import com.devco.videojuegos.dominio.puertos.EliminarVideojuegoCasoUso;
import com.devco.videojuegos.dominio.puertos.GuardarVideojuegoCasoUso;
import com.devco.videojuegos.dominio.puertos.ObtenerVideojuegoCasoUso;

import java.util.List;
import java.util.Optional;

public class VideojuegoServicio implements GuardarVideojuegoCasoUso, ObtenerVideojuegoCasoUso, ActualizarVideojuegoCasoUso, EliminarVideojuegoCasoUso {
    private final GuardarVideojuegoCasoUso guardarVideojuegoUseCase;
    private final ObtenerVideojuegoCasoUso obtenerVideojuegoUseCase;
    private final ActualizarVideojuegoCasoUso actualizarVideojuegoUseCase;
    private final EliminarVideojuegoCasoUso eliminarVideojuegoUseCase;

    public VideojuegoServicio(GuardarVideojuegoCasoUso guardarVideojuegoUseCase, ObtenerVideojuegoCasoUso obtenerVideojuegoUseCase, ActualizarVideojuegoCasoUso actualizarVideojuegoUseCase, EliminarVideojuegoCasoUso eliminarVideojuegoUseCase) {
        this.guardarVideojuegoUseCase = guardarVideojuegoUseCase;
        this.obtenerVideojuegoUseCase = obtenerVideojuegoUseCase;
        this.actualizarVideojuegoUseCase = actualizarVideojuegoUseCase;
        this.eliminarVideojuegoUseCase = eliminarVideojuegoUseCase;
    }

    @Override
    public Videojuego guardarVideojuego(Videojuego videojuego) {
        return guardarVideojuegoUseCase.guardarVideojuego(videojuego);
    }

    @Override
    public Optional<Videojuego> obtenerVideojuegoPorId(Integer id) {
        return obtenerVideojuegoUseCase.obtenerVideojuegoPorId(id);
    }

    @Override
    public List<Videojuego> obtenerVideojuegos() {
        return obtenerVideojuegoUseCase.obtenerVideojuegos();
    }

    @Override
    public Optional<Videojuego> actualizarVideojuego(Integer id, Videojuego videojuegoActualizado) {
        Videojuego videojuego = new Videojuego(id, videojuegoActualizado.getNombre(), videojuegoActualizado.getPlataforma(), videojuegoActualizado.getPrecio());
        return actualizarVideojuegoUseCase.actualizarVideojuego(id, videojuego);
    }

    @Override
    public void eliminarVideojuego(Integer id) {

        eliminarVideojuegoUseCase.eliminarVideojuego(id);
    }
}
