package com.devco.videojuegos.infraestructura.configuracion;

import com.devco.videojuegos.aplicacion.servicios.VideojuegoServicio;
import com.devco.videojuegos.aplicacion.casosuso.ActualizarVideojuegoCasoUsoAdaptador;
import com.devco.videojuegos.aplicacion.casosuso.EliminarVideojuegoCasoUsoAdaptador;
import com.devco.videojuegos.aplicacion.casosuso.GuardarVideojuegoCasoUsoAdaptador;
import com.devco.videojuegos.aplicacion.casosuso.ObtenerVideojuegoCasoUsoAdaptador;
import com.devco.videojuegos.dominio.puertos.VideojuegoRepositorio;
import com.devco.videojuegos.infraestructura.repositorios.JpaVideojuegoRepositorioAdaptador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicacionConfiguracion {

    @Bean
    public VideojuegoServicio videojuegoServicio(VideojuegoRepositorio videojuegoRepositorio) {
        return new VideojuegoServicio(
                new GuardarVideojuegoCasoUsoAdaptador(videojuegoRepositorio),
                new ObtenerVideojuegoCasoUsoAdaptador(videojuegoRepositorio),
                new ActualizarVideojuegoCasoUsoAdaptador(videojuegoRepositorio),
                new EliminarVideojuegoCasoUsoAdaptador(videojuegoRepositorio)
        );
    }

    @Bean
    public VideojuegoRepositorio videojuegoRepositorio(JpaVideojuegoRepositorioAdaptador jpaVideojuegoRepositorioAdaptador) {
        return jpaVideojuegoRepositorioAdaptador;
    }
}
