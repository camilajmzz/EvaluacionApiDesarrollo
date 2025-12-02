package com.example.Controller;
import com.example.Controller.DTO.ProyectoRequestDTO;
import com.example.Controller.DTO.ProyectoResponseDTO;
import com.example.Service.ProyectoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que es un controlador REST
@RequestMapping("/api/v1/projects") // Define la ruta base para todos los endpoints de proyectos
public class ProyectoController {

    private final ProyectoService proyectoService;

    // Inyección de dependencias del servicio
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    // 1. GET /projects
    // Obtener todos los proyectos
    @GetMapping
    public ResponseEntity<List<ProyectoResponseDTO>> obtenerTodosLosProyectos() {
        List<ProyectoResponseDTO> proyectos = proyectoService.obtenerTodosLosProyectos();
        // 200 OK
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    // 2. GET /projects/{word}
    // Obtener proyectos por palabra en el nombre
    @GetMapping("/{word}")
    public ResponseEntity<List<ProyectoResponseDTO>> buscarProyectosPorNombre(@PathVariable String word) {
        List<ProyectoResponseDTO> proyectos = proyectoService.buscarProyectosPorNombre(word);
        // 200 OK
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    // 3. POST /projects
    // Insertar proyecto
    @PostMapping
    public ResponseEntity<ProyectoResponseDTO> crearProyecto(@RequestBody ProyectoRequestDTO proyectoDTO) {
        ProyectoResponseDTO nuevoProyecto = proyectoService.crearProyecto(proyectoDTO);
        // 201 CREATED
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
    }

    // 4. PUT /projects/{id}
    // Editar el proyecto
    @PutMapping("/{id}")
    public ResponseEntity<ProyectoResponseDTO> actualizarProyecto(@PathVariable Long id, @RequestBody ProyectoRequestDTO proyectoDTO) {
        ProyectoResponseDTO proyectoActualizado = proyectoService.actualizarProyecto(id, proyectoDTO);
        // 200 OK
        return new ResponseEntity<>(proyectoActualizado, HttpStatus.OK);
    }

    // 5. DELETE /projects/{id}
    // Eliminar el proyecto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        // 204 NO CONTENT
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}