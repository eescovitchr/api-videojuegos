package com.devco.videojuegos.infraestructura.controlador;

import com.devco.videojuegos.aplicacion.servicios.VideojuegoServicio;
import com.devco.videojuegos.dominio.modelos.Videojuego;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoControlador {

    private final VideojuegoServicio videojuegoServicio;

    public VideojuegoControlador(VideojuegoServicio videojuegoServicio) {
        this.videojuegoServicio = videojuegoServicio;
    }

    @PostMapping
    public ResponseEntity<Videojuego> guardarVideojuego(@RequestBody @Valid Videojuego videojuego) {
        Videojuego videojuegoCreado = videojuegoServicio.guardarVideojuego(videojuego);
        return new ResponseEntity<>(videojuegoCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> obtenerVideojuegoPorId(@PathVariable Integer id) {
        return videojuegoServicio.obtenerVideojuegoPorId(id)
                .map(videojuego -> new ResponseEntity<>(videojuego, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Videojuego>> obtenerVideojuegos() {
        if (videojuegoServicio.obtenerVideojuegos().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<Videojuego> videojuegos = videojuegoServicio.obtenerVideojuegos();
            return new ResponseEntity<>(videojuegos, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videojuego> actualizarVideojuego(@PathVariable Integer id, @RequestBody Videojuego videojuegoActualizado) {
        videojuegoActualizado.setId(id);
        if (videojuegoServicio.obtenerVideojuegoPorId(id).isPresent()) {
            videojuegoServicio.actualizarVideojuego(id, videojuegoActualizado);
            return new ResponseEntity<>(videojuegoActualizado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Integer id) {
        if (videojuegoServicio.obtenerVideojuegoPorId(id).isPresent()) {
            videojuegoServicio.eliminarVideojuego(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
