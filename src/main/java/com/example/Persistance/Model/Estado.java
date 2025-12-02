// Archivo: src/main/java/com/example/Persistance/Model/Estado.java

package com.example.Persistance.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado") 
    private Long id; 

    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre; 

    // --- CONSTRUCTORES ---

    // 1. Constructor vacío (DEFAULT) - NECESARIO para JPA/Hibernate
    public Estado() {
    }

    // 2. Constructor para crear nuevas instancias (sin ID)
    public Estado(String nombre) {
        this.nombre = nombre;
    }
    
    // 3. Constructor con ID (usado a veces para DTOs o inicialización)
    public Estado(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // --- GETTERS Y SETTERS ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}