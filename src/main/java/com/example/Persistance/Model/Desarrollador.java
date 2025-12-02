// Archivo: src/main/java/com/example/Persistance/Model/Desarrollador.java

package com.example.Persistance.Model;

import jakarta.persistence.*;
import java.util.Set; 

@Entity
@Table(name = "desarrollador")
public class Desarrollador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desarrollador")
    private Long id; 

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre; 

    @Column(name = "apellido", length = 45)
    private String apellido; 

    @Column(name = "correo_electronico", length = 255, unique = true, nullable = false)
    private String correoElectronico; 

    @Column(name = "linkedin", length = 255)
    private String linkedin; 

    @Column(name = "github", length = 255)
    private String github; 

    // Relación Muchos a Muchos con Proyecto (Gestionada desde la entidad Proyecto)
    @ManyToMany(mappedBy = "programadores")
    private Set<Proyecto> proyectos;

    // --- CONSTRUCTORES ---

    // 1. Constructor vacío (DEFAULT) - NECESARIO para JPA
    public Desarrollador() {
    }

    // 2. Constructor para crear nuevas instancias (sin ID)
    public Desarrollador(String nombre, String apellido, String correoElectronico, String linkedin, String github) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.linkedin = linkedin;
        this.github = github;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}