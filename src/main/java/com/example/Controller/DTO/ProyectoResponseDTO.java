package com.example.Controller.DTO;


import java.time.LocalDate;
import java.util.Set;

public class ProyectoResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String repositorio;
    private String urlDemo;
    private String urlImagen;
    
    // Relaciones (Obligatorio por el enunciado)
    private EstadoDTO estado;
    private Set<TecnologiaDTO> tecnologias;
    private Set<DesarrolladorDTO> programadores;

    
    public ProyectoResponseDTO(Long id, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
            String repositorio, String urlDemo, String urlImagen, EstadoDTO estado, Set<TecnologiaDTO> tecnologias,
            Set<DesarrolladorDTO> programadores) {
        this.id = id;
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

    public ProyectoResponseDTO() {

    }

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
    public EstadoDTO getEstado() {
        return estado;
    }
    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }
    public Set<TecnologiaDTO> getTecnologias() {
        return tecnologias;
    }
    public void setTecnologias(Set<TecnologiaDTO> tecnologias) {
        this.tecnologias = tecnologias;
    }
    public Set<DesarrolladorDTO> getProgramadores() {
        return programadores;
    }
    public void setProgramadores(Set<DesarrolladorDTO> programadores) {
        this.programadores = programadores;
    }
    

}