// Archivo: src/main/java/com/example/Persistance/Model/Proyecto.java

package com.example.Persistance.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto") 
    private Long id; 

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre; 

    @Lob 
    @Column(name = "descripcion")
    private String descripcion; 

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio; 

    @Column(name = "fecha_fin")
    private LocalDate fechaFin; 

    @Column(name = "repositorio", length = 255)
    private String repositorio; 

    @Column(name = "url_demo", length = 255)
    private String urlDemo; 

    @Column(name = "url_imagen", length = 255)
    private String urlImagen; 

    // Relación Muchos a Uno con Estado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_fk", nullable = false) 
    private Estado estado; 

    // Relación Muchos a Muchos con Tecnologia
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "proyecto_tecnologia", 
        joinColumns = @JoinColumn(name = "id_proyecto_fk"),
        inverseJoinColumns = @JoinColumn(name = "id_tecnologia_fk")
    )
    private Set<Tecnologia> tecnologias;

    // Relación Muchos a Muchos con Desarrollador
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "proyecto_desarrollador", // Cambiado el nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "id_proyecto_fk"),
        inverseJoinColumns = @JoinColumn(name = "id_desarrollador_fk")
    )
    private Set<Desarrollador> programadores;

    // --- CONSTRUCTORES ---

    // 1. Constructor vacío (DEFAULT) - NECESARIO para JPA
    public Proyecto() {
    }

    // 2. Constructor para crear nuevas instancias (general)
    public Proyecto(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String repositorio, String urlDemo, String urlImagen, Estado estado, Set<Tecnologia> tecnologias, Set<Desarrollador> programadores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.repositorio = repositorio;
        this.urlDemo = urlDemo;
        this.urlImagen = urlImagen;
        this.estado = estado;
        this.tecnologias = tecnologias;
        this.programadores = programadores;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }

    public String getUrlDemo() {
        return urlDemo;
    }

    public void setUrlDemo(String urlDemo) {
        this.urlDemo = urlDemo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Set<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(Set<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public Set<Desarrollador> getProgramadores() {
        return programadores;
    }

    public void setProgramadores(Set<Desarrollador> programadores) {
        this.programadores = programadores;
    }
}