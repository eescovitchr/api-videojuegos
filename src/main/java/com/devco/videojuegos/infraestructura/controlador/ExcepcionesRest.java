package com.devco.videojuegos.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExcepcionesRest {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationException(Exception ex) {

        String mensajeError = "Datos incompletos, los campos no pueden ser nulos";
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        return new ResponseEntity<>(mensajeError, status);
    }
}
