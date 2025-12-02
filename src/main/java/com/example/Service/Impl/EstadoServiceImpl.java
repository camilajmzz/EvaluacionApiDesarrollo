package com.example.Service.Impl;
import com.example.Controller.DTO.EstadoDTO;
import com.example.Controller.DTO.RecursoNoEncontradoException;
import com.example.Persistance.Model.Estado;
import com.example.Persistance.Repository.EstadoRepository;
import com.example.Service.EstadoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoServiceImpl(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    // --- Mapper (simples) ---

    private EstadoDTO mapearADTO(Estado estado) {
        return new EstadoDTO(estado.getId(), estado.getNombre());
    }

    private Estado mapearAEntidad(EstadoDTO dto) {
        // Ignoramos el ID al mapear del DTO para la creación
        return new Estado(dto.getNombre());
    }

    // --- Implementación de Métodos ---

    @Override
    @Transactional
    public EstadoDTO crearEstado(EstadoDTO estadoDTO) {
        Estado nuevoEstado = mapearAEntidad(estadoDTO);
        Estado guardado = estadoRepository.save(nuevoEstado);
        return mapearADTO(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public EstadoDTO obtenerEstadoPorId(Long id) {
        Estado estado = estadoRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Estado", id));
        return mapearADTO(estado);
    }
}