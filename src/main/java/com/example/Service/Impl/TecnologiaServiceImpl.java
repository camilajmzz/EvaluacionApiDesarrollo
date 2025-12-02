package com.example.Service.Impl;
import com.example.Controller.DTO.TecnologiaRequestDTO;
import com.example.Controller.DTO.TecnologiaResponseDTO;
import com.example.Persistance.Model.Tecnologia;
import com.example.Persistance.Repository.TecnologiaRepository;
import com.example.Controller.DTO.RecursoNoEncontradoException;
import com.example.Service.TecnologiaService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TecnologiaServiceImpl implements TecnologiaService {

    private final TecnologiaRepository tecnologiaRepository;

    public TecnologiaServiceImpl(TecnologiaRepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }

    // --- Mapper ---

    private TecnologiaResponseDTO mapearAResponseDTO(Tecnologia entidad) {
        return new TecnologiaResponseDTO(entidad.getId(), entidad.getNombre());
    }

    private Tecnologia mapearAEntidad(TecnologiaRequestDTO dto) {
        return new Tecnologia(dto.getNombre());
    }

    // 8. POST /technologies
    @Override
    @Transactional
    public TecnologiaResponseDTO crearTecnologia(TecnologiaRequestDTO dto) {
        Tecnologia nuevaTecnologia = mapearAEntidad(dto);
        Tecnologia guardada = tecnologiaRepository.save(nuevaTecnologia);
        return mapearAResponseDTO(guardada);
    }

    // 9. DELETE /technologies/{id}
    @Override
    @Transactional
    public void eliminarTecnologia(Long id) {
        if (!tecnologiaRepository.existsById(id)) {
            // Lanza 404 si no se encuentra
            throw new RecursoNoEncontradoException("Tecnología", id);
        }
        tecnologiaRepository.deleteById(id);
    }
}