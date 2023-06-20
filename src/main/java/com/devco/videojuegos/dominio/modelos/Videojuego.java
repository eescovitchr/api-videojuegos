package com.devco.videojuegos.dominio.modelos;

public class Videojuego {
    private Integer id;
    private String nombre;
    private String plataforma;
    private Double precio;

    public Videojuego(Integer id, String nombre, String plataforma, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    public Videojuego() {

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
