package com.example.Service.Impl;
import com.example.Controller.DTO.DesarrolladorRequestDTO;
import com.example.Controller.DTO.DesarrolladorResponseDTO;
import com.example.Persistance.Model.Desarrollador;
import com.example.Persistance.Repository.DesarrolladorRepository;
import com.example.Service.DesarrolladorService;
import com.example.Controller.DTO.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DesarrolladorServiceImpl implements DesarrolladorService {

    private final DesarrolladorRepository desarrolladorRepository;

    public DesarrolladorServiceImpl(DesarrolladorRepository desarrolladorRepository) {
        this.desarrolladorRepository = desarrolladorRepository;
    }

    // --- Mapper ---

    private DesarrolladorResponseDTO mapearAResponseDTO(Desarrollador entidad) {
        DesarrolladorResponseDTO dto = new DesarrolladorResponseDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setApellido(entidad.getApellido());
        dto.setCorreoElectronico(entidad.getCorreoElectronico());
        dto.setLinkedin(entidad.getLinkedin());
        dto.setGithub(entidad.getGithub());
        return dto;
    }

    private Desarrollador mapearAEntidad(DesarrolladorRequestDTO dto) {
        Desarrollador entidad = new Desarrollador();
        entidad.setNombre(dto.getNombre());
        entidad.setApellido(dto.getApellido());
        entidad.setCorreoElectronico(dto.getCorreoElectronico());
        entidad.setLinkedin(dto.getLinkedin());
        entidad.setGithub(dto.getGithub());
        return entidad;
    }

    // 6. POST/developers
    @Override
    @Transactional
    public DesarrolladorResponseDTO crearDesarrollador(DesarrolladorRequestDTO dto) {
        Desarrollador nuevoDesarrollador = mapearAEntidad(dto);
        Desarrollador guardado = desarrolladorRepository.save(nuevoDesarrollador);
        return mapearAResponseDTO(guardado);
    }

    // 7. DELETE /developers/{id}
    @Override
    @Transactional
    public void eliminarDesarrollador(Long id) {
        if (!desarrolladorRepository.existsById(id)) {
            // Lanza 404 si no se encuentra
            throw new RecursoNoEncontradoException("Desarrollador", id);
        }
        desarrolladorRepository.deleteById(id);
    }
}