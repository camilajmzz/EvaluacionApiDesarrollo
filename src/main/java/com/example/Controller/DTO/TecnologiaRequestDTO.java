package com.example.Controller.DTO;

public class TecnologiaRequestDTO {
    private String nombre;

    public TecnologiaRequestDTO() {}

    public TecnologiaRequestDTO(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}