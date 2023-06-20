package com.devco.videojuegos.infraestructura.repositorios;

import com.devco.videojuegos.dominio.modelos.Videojuego;
import com.devco.videojuegos.dominio.puertos.VideojuegoRepositorio;
import com.devco.videojuegos.infraestructura.entidades.VideojuegoEntidad;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaVideojuegoRepositorioAdaptador implements VideojuegoRepositorio {
    private final JpaVideojuegoRepositorio jpaVideojuegoRepositorio;

    public JpaVideojuegoRepositorioAdaptador(JpaVideojuegoRepositorio jpaVideojuegoRepositorio) {
        this.jpaVideojuegoRepositorio = jpaVideojuegoRepositorio;
    }

    @Override
    public Videojuego guardar(Videojuego videojuego) {
        VideojuegoEntidad videojuegoEntidad = VideojuegoEntidad.desdeDominioModelo(videojuego);
        VideojuegoEntidad videojuegoEntidadGuardado = jpaVideojuegoRepositorio.save(videojuegoEntidad);
        return videojuegoEntidadGuardado.aDominioModelo();
    }

    @Override
    public Optional<Videojuego> obtenerPorId(Integer id) {
        return jpaVideojuegoRepositorio.findById(id).map(VideojuegoEntidad::aDominioModelo);
    }

    @Override
    public List<Videojuego> obtenerVideojuegos() {
        return jpaVideojuegoRepositorio.findAll().stream()
                .map(VideojuegoEntidad::aDominioModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Videojuego> actualizar(Integer id, Videojuego videojuego) {
        VideojuegoEntidad videojuegoEntidad = VideojuegoEntidad.desdeDominioModelo(videojuego);
        VideojuegoEntidad videojuegoEntidadActualizado = jpaVideojuegoRepositorio.save(videojuegoEntidad);
        return Optional.of(videojuegoEntidadActualizado.aDominioModelo());
    }

    @Override
    public void eliminar(Integer id) {
        jpaVideojuegoRepositorio.deleteById(id);
    }
}
