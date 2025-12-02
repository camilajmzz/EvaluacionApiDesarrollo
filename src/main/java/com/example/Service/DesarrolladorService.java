package com.example.Service;

import com.example.Controller.DTO.DesarrolladorRequestDTO;
import com.example.Controller.DTO.DesarrolladorResponseDTO;

public interface DesarrolladorService {
    // POST/developers -> Insertar un programador.
    DesarrolladorResponseDTO crearDesarrollador(DesarrolladorRequestDTO dto);
    
    // DELETE /developers/{id} -> Borrar un programador.
    void eliminarDesarrollador(Long id);
}