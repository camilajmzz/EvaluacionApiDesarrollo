package com.example.Service;
import com.example.Controller.DTO.TecnologiaRequestDTO;
import com.example.Controller.DTO.TecnologiaResponseDTO;

public interface TecnologiaService {
    // 8. POST /technologies -> Insertar tecnología.
    TecnologiaResponseDTO crearTecnologia(TecnologiaRequestDTO dto);
    
    // 9. DELETE/technologies/{id} -> Borrar tecnología.
    void eliminarTecnologia(Long id);
}