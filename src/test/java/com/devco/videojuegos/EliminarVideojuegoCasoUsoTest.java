package com.devco.videojuegos;

import com.devco.videojuegos.aplicacion.casosuso.EliminarVideojuegoCasoUsoAdaptador;
import com.devco.videojuegos.aplicacion.servicios.VideojuegoServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

class EliminarVideojuegoCasoUsoTest {
    @Mock
    private EliminarVideojuegoCasoUsoAdaptador eliminarVideojuegoCasoUso;

    @InjectMocks
    private VideojuegoServicio videojuegoServicio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEliminarVideojuegoCasoUso() {

        Integer id = 4;

        eliminarVideojuegoCasoUso.eliminarVideojuego(id);

        verify(eliminarVideojuegoCasoUso, times(1)).eliminarVideojuego(id);
        verifyNoMoreInteractions(eliminarVideojuegoCasoUso);
    }

    @Test
    void testEliminarVideojuegoCasoUsoFallo() {

        Integer id = 2;

        doThrow(new RuntimeException("Error al eliminar el videojuego")).when(eliminarVideojuegoCasoUso).eliminarVideojuego(id);

        assertThatThrownBy(() -> videojuegoServicio.eliminarVideojuego(id))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Error al eliminar el videojuego");

        verify(eliminarVideojuegoCasoUso, times(1)).eliminarVideojuego(id);
        verifyNoMoreInteractions(eliminarVideojuegoCasoUso);

    }

}
