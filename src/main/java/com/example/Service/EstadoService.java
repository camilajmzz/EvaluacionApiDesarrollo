package com.example.Service;
import com.example.Controller.DTO.EstadoDTO;

public interface EstadoService {
    
    // Método para crear un nuevo estado
    EstadoDTO crearEstado(EstadoDTO estadoDTO);
    
    // Método para obtener un estado por ID (necesario para la validación en ProyectoService)
    EstadoDTO obtenerEstadoPorId(Long id);
    
    // Opcional: obtener todos los estados
    // List<EstadoDTO> obtenerTodosLosEstados();
}