package com.devco.videojuegos;

import com.devco.videojuegos.aplicacion.casosuso.ActualizarVideojuegoCasoUsoAdaptador;
import com.devco.videojuegos.aplicacion.servicios.VideojuegoServicio;
import com.devco.videojuegos.dominio.modelos.Videojuego;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class ActualizarVideojuegoCasoUsoTest {
    @Mock
    private ActualizarVideojuegoCasoUsoAdaptador actualizarVideojuegoCasoUso;

    @InjectMocks
    private VideojuegoServicio videojuegoServicio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testActualizarVideojuegoCasoUso() {

        Integer id = 5;

        Videojuego videojuegoActualizado = new Videojuego(id, "Batman Arkham Nigth", "PC, Xbox series S|X, PS5", 299900.0);

        when(actualizarVideojuegoCasoUso.actualizarVideojuego(eq(id), any(Videojuego.class)))
                .thenReturn(Optional.of(videojuegoActualizado));

        Optional<Videojuego> resultado = videojuegoServicio.actualizarVideojuego(id, videojuegoActualizado);

        Assertions.assertThat(resultado).isPresent();
        Assertions.assertThat(resultado.get().getId()).isEqualTo(id);
        Assertions.assertThat(resultado.get().getNombre()).isEqualTo(videojuegoActualizado.getNombre());
        Assertions.assertThat(resultado.get().getPlataforma()).isEqualTo(videojuegoActualizado.getPlataforma());
        Assertions.assertThat(resultado.get().getPrecio()).isEqualTo(videojuegoActualizado.getPrecio());

        verify(actualizarVideojuegoCasoUso).actualizarVideojuego(any(Integer.class), any(Videojuego.class));
    }

    @Test
    void testActualizarVideojuegoCasoUsoFallo() {

        Integer id = 5;

        Videojuego videojuegoActualizado = new Videojuego(id, "Batman Arkham Nigth", "PC, Xbox series S|X, PS5", 299900.0);

        when(actualizarVideojuegoCasoUso.actualizarVideojuego(any(Integer.class), any(Videojuego.class)))
                .thenReturn(Optional.empty());

        Optional<Videojuego> resultado = videojuegoServicio.actualizarVideojuego(id, videojuegoActualizado);

        assertThat(resultado).isEmpty();

        verify(actualizarVideojuegoCasoUso).actualizarVideojuego(any(Integer.class), any(Videojuego.class));

    }
}
