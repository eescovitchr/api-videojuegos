package com.devco.videojuegos.infraestructura.entidades;

import com.devco.videojuegos.dominio.modelos.Videojuego;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "videojuegos")
public class VideojuegoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String plataforma;
    @NotNull
    private Double precio;

    public VideojuegoEntidad() {
    }

    public VideojuegoEntidad(Integer id, String nombre, String plataforma, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    public static VideojuegoEntidad desdeDominioModelo(Videojuego videojuego) {
        return new VideojuegoEntidad(videojuego.getId(), videojuego.getNombre(), videojuego.getPlataforma(), videojuego.getPrecio());
    }

    public Videojuego aDominioModelo() {
        return new Videojuego(id, nombre, plataforma, precio);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
