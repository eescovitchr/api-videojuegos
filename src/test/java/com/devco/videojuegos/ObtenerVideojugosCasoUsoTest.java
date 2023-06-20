package com.devco.videojuegos;

import com.devco.videojuegos.aplicacion.casosuso.ObtenerVideojuegoCasoUsoAdaptador;
import com.devco.videojuegos.aplicacion.servicios.VideojuegoServicio;
import com.devco.videojuegos.dominio.modelos.Videojuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ObtenerVideojugosCasoUsoTest {
    @Mock
    private ObtenerVideojuegoCasoUsoAdaptador obtenerVideojuegoCasoUso;

    @InjectMocks
    private VideojuegoServicio videojuegoServicio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerVideojuegosCasoUso() {

        Videojuego videojuegoPruba1 = new Videojuego(1, "Mario Kart 8 Deluxe", "Nintendo Switch", 210000.0);

        Videojuego videojuegoPruba2 = new Videojuego(1, "The Last Of Us Part 2", "PS5", 309900.0);

        List<Videojuego> videojuegos = Arrays.asList(videojuegoPruba1, videojuegoPruba2);

        when(obtenerVideojuegoCasoUso.obtenerVideojuegos()).thenReturn(videojuegos);

        List<Videojuego> resultado = videojuegoServicio.obtenerVideojuegos();

        assertThat(resultado).isNotNull().hasSize(2).containsExactly(videojuegoPruba1, videojuegoPruba2);

    }

    @Test
    void testObtenerVideojuegoPorIdCasoUso() {

        Optional<Videojuego> videojuego = Optional.of(new Videojuego(5, "NBA 2K23", "PC, Xbox series S|X, PS5", 270000.0));

        when(obtenerVideojuegoCasoUso.obtenerVideojuegoPorId(5)).thenReturn(videojuego);

        Optional<Videojuego> resultado = videojuegoServicio.obtenerVideojuegoPorId(5);

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getId()).isEqualTo(5);
        assertThat(resultado.get().getNombre()).isEqualTo("NBA 2K23");

    }

    @Test
    void testObtenerVideojuegosCasoUsoFallo() {

        when(obtenerVideojuegoCasoUso.obtenerVideojuegos()).thenReturn(null);

        List<Videojuego> resultado = videojuegoServicio.obtenerVideojuegos();

        assertThat(resultado).isNull();

        verify(obtenerVideojuegoCasoUso, times(1)).obtenerVideojuegos();
        verifyNoMoreInteractions(obtenerVideojuegoCasoUso);
    }

    @Test
    void testObtenerVideojuegoPorIdCasoUsoFallo() {

        when(obtenerVideojuegoCasoUso.obtenerVideojuegoPorId(5)).thenReturn(null);

        Optional<Videojuego> resultado = videojuegoServicio.obtenerVideojuegoPorId(5);

        assertThat(resultado).isNull();

        verify(obtenerVideojuegoCasoUso, times(1)).obtenerVideojuegoPorId(5);
        verifyNoMoreInteractions(obtenerVideojuegoCasoUso);

    }


}
