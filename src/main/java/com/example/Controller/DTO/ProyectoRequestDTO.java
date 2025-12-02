package com.example.Controller.DTO;
import java.time.LocalDate;
import java.util.Set;

public class ProyectoRequestDTO {
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String repositorio;
    private String urlDemo;
    private String urlImagen;
    
    // Usamos IDs para manejar las relaciones en la base de datos
    private Long estadoId;
    private Set<Long> tecnologiasIds;
    private Set<Long> desarrolladoresIds;

    public ProyectoRequestDTO(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
            String repositorio, String urlDemo, String urlImagen, Long estadoId, Set<Long> tecnologiasIds,
            Set<Long> desarrolladoresIds) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.repositorio = repositorio;
        this.urlDemo = urlDemo;
        this.urlImagen = urlImagen;
        this.estadoId = estadoId;
        this.tecnologiasIds = tecnologiasIds;
        this.desarrolladoresIds = desarrolladoresIds;
    }

    public ProyectoRequestDTO() {
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
    public Long getEstadoId() {
        return estadoId;
    }
    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
    public Set<Long> getTecnologiasIds() {
        return tecnologiasIds;
    }
    public void setTecnologiasIds(Set<Long> tecnologiasIds) {
        this.tecnologiasIds = tecnologiasIds;
    }
    public Set<Long> getDesarrolladoresIds() {
        return desarrolladoresIds;
    }
    public void setDesarrolladoresIds(Set<Long> desarrolladoresIds) {
        this.desarrolladoresIds = desarrolladoresIds;
    }
   
}