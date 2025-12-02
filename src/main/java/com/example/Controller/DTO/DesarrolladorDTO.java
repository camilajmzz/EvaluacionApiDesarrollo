package com.example.Controller.DTO;
public class DesarrolladorDTO {
    private Long id;
    private String nombre;
    private String apellido;

    public DesarrolladorDTO() {
    }

    public DesarrolladorDTO(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
}