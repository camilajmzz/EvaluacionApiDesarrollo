package com.example.Service;

import java.util.List;

import com.example.Controller.DTO.ProyectoRequestDTO;
import com.example.Controller.DTO.ProyectoResponseDTO;

public interface ProyectoService {

    // 1. GET /projects
    List<ProyectoResponseDTO> obtenerTodosLosProyectos();

    // 2. GET /projects/{word}
    List<ProyectoResponseDTO> buscarProyectosPorNombre(String word);

    // 3. POST /projects
    ProyectoResponseDTO crearProyecto(ProyectoRequestDTO proyectoDTO);

    // 4. PUT /projects/{id}
    ProyectoResponseDTO actualizarProyecto(Long id, ProyectoRequestDTO proyectoDTO);

    // 5. DELETE /projects/{id}
    void eliminarProyecto(Long id);
}