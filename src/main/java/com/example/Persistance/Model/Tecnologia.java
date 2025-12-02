// Archivo: src/main/java/com/example/Persistance/Model/Tecnologia.java

package com.example.Persistance.Model;

import jakarta.persistence.*;
import java.util.Set; 

@Entity
@Table(name = "tecnologia")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnologia")
    private Long id; 

    @Column(name = "nombre", nullable = false)
    private String nombre; 

    // Relación Muchos a Muchos con Proyecto (Gestionada desde la entidad Proyecto)
    @ManyToMany(mappedBy = "tecnologias")
    private Set<Proyecto> proyectos;

    // --- CONSTRUCTORES ---

    // 1. Constructor vacío (DEFAULT) - NECESARIO para JPA
    public Tecnologia() {
    }

    // 2. Constructor para crear nuevas instancias (sin ID)
    public Tecnologia(String nombre) {
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

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}