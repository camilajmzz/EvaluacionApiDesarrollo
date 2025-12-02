// Archivo: src/main/java/com/example/Service/Impl/ProyectoServiceImpl.java

package com.example.Service.Impl;

// IMPORTS CORREGIDOS para usar los DTOs y la Excepción en sus paquetes:
import com.example.Controller.DTO.ProyectoResponseDTO;
import com.example.Controller.DTO.ProyectoRequestDTO; 
import com.example.Controller.DTO.EstadoDTO; 
import com.example.Controller.DTO.TecnologiaDTO; 
import com.example.Controller.DTO.DesarrolladorDTO; 
import com.example.Persistance.Model.*;
import com.example.Persistance.Repository.*;
import com.example.Service.ProyectoService; 
import com.example.Controller.DTO.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    // Inyección de dependencias (Repositorios)
    private final ProyectoRepository proyectoRepository;
    private final EstadoRepository estadoRepository;
    private final TecnologiaRepository tecnologiaRepository;
    private final DesarrolladorRepository desarrolladorRepository;

    public ProyectoServiceImpl(ProyectoRepository proyectoRepository,
                               EstadoRepository estadoRepository,
                               TecnologiaRepository tecnologiaRepository,
                               DesarrolladorRepository desarrolladorRepository) {
        this.proyectoRepository = proyectoRepository;
        this.estadoRepository = estadoRepository;
        this.tecnologiaRepository = tecnologiaRepository;
        this.desarrolladorRepository = desarrolladorRepository;
    }

    // --- LÓGICA DE MAPEO (Mapper) ---

    /** Convierte la Entidad (Proyecto) a DTO (ProyectoResponseDTO) */
    private ProyectoResponseDTO mapearAResponseDTO(Proyecto proyecto) {
        ProyectoResponseDTO dto = new ProyectoResponseDTO();
        dto.setId(proyecto.getId());
        dto.setNombre(proyecto.getNombre());
        dto.setDescripcion(proyecto.getDescripcion());
        dto.setFechaInicio(proyecto.getFechaInicio());
        dto.setFechaFin(proyecto.getFechaFin());
        dto.setRepositorio(proyecto.getRepositorio());
        dto.setUrlDemo(proyecto.getUrlDemo());
        dto.setUrlImagen(proyecto.getUrlImagen());
        
        // Mapeo de relaciones
        if (proyecto.getEstado() != null) {
            dto.setEstado(new EstadoDTO(proyecto.getEstado().getId(), proyecto.getEstado().getNombre()));
        }
        
        if (proyecto.getTecnologias() != null) {
            dto.setTecnologias(proyecto.getTecnologias().stream()
                .map(t -> new TecnologiaDTO(t.getId(), t.getNombre()))
                .collect(Collectors.toSet()));
        }

        if (proyecto.getProgramadores() != null) {
            dto.setProgramadores(proyecto.getProgramadores().stream()
                .map(d -> new DesarrolladorDTO(d.getId(), d.getNombre(), d.getApellido()))
                .collect(Collectors.toSet()));
        }
        
        return dto;
    }

    /** Convierte el DTO de Petición (ProyectoRequestDTO) a la Entidad (Proyecto) */
    private Proyecto mapearAEntidad(ProyectoRequestDTO dto, Proyecto proyectoExistente) {
        
        // 1. Copiar campos simples
        proyectoExistente.setNombre(dto.getNombre());
        proyectoExistente.setDescripcion(dto.getDescripcion());
        proyectoExistente.setFechaInicio(dto.getFechaInicio());
        proyectoExistente.setFechaFin(dto.getFechaFin());
        proyectoExistente.setRepositorio(dto.getRepositorio());
        proyectoExistente.setUrlDemo(dto.getUrlDemo());
        proyectoExistente.setUrlImagen(dto.getUrlImagen());

        // 2. Manejar la relación Estado (Muchos a Uno)
        Estado estado = estadoRepository.findById(dto.getEstadoId())
            .orElseThrow(() -> new RecursoNoEncontradoException("Estado", dto.getEstadoId()));
        proyectoExistente.setEstado(estado);

        // 3. Manejar la relación Tecnologías (Muchos a Muchos)
        Set<Tecnologia> tecnologias = new HashSet<>();
        if (dto.getTecnologiasIds() != null) {
            for (Long techId : dto.getTecnologiasIds()) {
                Tecnologia tech = tecnologiaRepository.findById(techId)
                    .orElseThrow(() -> new RecursoNoEncontradoException("Tecnología", techId));
                tecnologias.add(tech);
            }
        }
        proyectoExistente.setTecnologias(tecnologias);

        // 4. Manejar la relación Desarrolladores (Muchos a Muchos)
        Set<Desarrollador> desarrolladores = new HashSet<>();
        if (dto.getDesarrolladoresIds() != null) {
            for (Long devId : dto.getDesarrolladoresIds()) {
                Desarrollador dev = desarrolladorRepository.findById(devId)
                    .orElseThrow(() -> new RecursoNoEncontradoException("Desarrollador", devId));
                desarrolladores.add(dev);
            }
        }
        proyectoExistente.setProgramadores(desarrolladores);

        return proyectoExistente;
    }
    
    // --- IMPLEMENTACIÓN DE ENDPOINTS DE PROYECTOS ---

    @Override
    @Transactional(readOnly = true)
    public List<ProyectoResponseDTO> obtenerTodosLosProyectos() {
        List<Proyecto> proyectos = proyectoRepository.findAll();
        return proyectos.stream()
                .map(this::mapearAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProyectoResponseDTO> buscarProyectosPorNombre(String word) {
        List<Proyecto> proyectos = proyectoRepository.findByNombreContainingIgnoreCase(word);
        return proyectos.stream()
                .map(this::mapearAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProyectoResponseDTO crearProyecto(ProyectoRequestDTO proyectoDTO) {
        Proyecto nuevoProyecto = new Proyecto();
        Proyecto proyectoAGuardar = mapearAEntidad(proyectoDTO, nuevoProyecto);
        Proyecto proyectoGuardado = proyectoRepository.save(proyectoAGuardar);
        return mapearAResponseDTO(proyectoGuardado);
    }

    @Override
    @Transactional
    public ProyectoResponseDTO actualizarProyecto(Long id, ProyectoRequestDTO proyectoDTO) {
        Proyecto proyectoExistente = proyectoRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Proyecto", id));

        Proyecto proyectoActualizado = mapearAEntidad(proyectoDTO, proyectoExistente);
        Proyecto proyectoGuardado = proyectoRepository.save(proyectoActualizado);
        
        return mapearAResponseDTO(proyectoGuardado);
    }

    @Override
    @Transactional
    public void eliminarProyecto(Long id) {
        if (!proyectoRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Proyecto", id);
        }
        proyectoRepository.deleteById(id);
    }
}