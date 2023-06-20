package com.devco.videojuegos;

import com.devco.videojuegos.aplicacion.casosuso.GuardarVideojuegoCasoUsoAdaptador;
import com.devco.videojuegos.aplicacion.servicios.VideojuegoServicio;
import com.devco.videojuegos.dominio.modelos.Videojuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

class GuardarVideojuegoCasoUsoTest {

    @Mock
    private GuardarVideojuegoCasoUsoAdaptador guardarVideojuegoCasoUso;

    @InjectMocks
    private VideojuegoServicio videojuegoServicio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarVideojuegoCasoUso() {

        Videojuego videojuego = new Videojuego(10, "CyberPunk2077", "PC, Xbox series S|X, PS5", 240000.0);

        when(guardarVideojuegoCasoUso.guardarVideojuego(videojuego)).thenReturn(videojuego);

        Videojuego resultado = videojuegoServicio.guardarVideojuego(videojuego);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(10);
        assertThat(resultado.getNombre()).isEqualTo("CyberPunk2077");

        verify(guardarVideojuegoCasoUso, times(1)).guardarVideojuego(videojuego);
        verifyNoMoreInteractions(guardarVideojuegoCasoUso);
    }

    @Test
    void testGuardarVideojuegoCasoUsoFallo() {

        Videojuego videojuego = new Videojuego(7, "Call of duty modern warfare II", "PC, Xbox series S|X, PS5", 299900.0);

        when(guardarVideojuegoCasoUso.guardarVideojuego(videojuego)).thenThrow(new RuntimeException("Error al guardar el videojuego"));

        assertThatThrownBy(() -> videojuegoServicio.guardarVideojuego(videojuego))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Error al guardar el videojuego");

        verify(guardarVideojuegoCasoUso, times(1)).guardarVideojuego(videojuego);
        verifyNoMoreInteractions(guardarVideojuegoCasoUso);

    }

}
