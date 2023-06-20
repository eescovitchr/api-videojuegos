package com.devco.videojuegos.infraestructura.repositorios;

import com.devco.videojuegos.infraestructura.entidades.VideojuegoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaVideojuegoRepositorio extends JpaRepository<VideojuegoEntidad, Integer> {
}
