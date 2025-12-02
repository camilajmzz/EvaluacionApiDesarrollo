package com.example.Controller;
import com.example.Controller.DTO.EstadoDTO;
import com.example.Service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/states") // Ruta base: /api/v1/states
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    // Endpoint: POST /api/v1/states
    @PostMapping
    public ResponseEntity<EstadoDTO> crearEstado(@RequestBody EstadoDTO estadoDTO) {
        EstadoDTO nuevo = estadoService.crearEstado(estadoDTO);
        // 201 CREATED
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Opcional: GET /api/v1/states/{id} para verificación
    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> obtenerEstado(@PathVariable Long id) {
        EstadoDTO estado = estadoService.obtenerEstadoPorId(id);
        // 200 OK
        return new ResponseEntity<>(estado, HttpStatus.OK);
    }
}
