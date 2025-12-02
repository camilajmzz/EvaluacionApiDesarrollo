package com.example.Controller;
import com.example.Controller.DTO.DesarrolladorRequestDTO;
import com.example.Controller.DTO.DesarrolladorResponseDTO;
import com.example.Service.DesarrolladorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/developers") // Ruta base: /api/v1/developers
public class DesarrolladorController {

    private final DesarrolladorService desarrolladorService;

    public DesarrolladorController(DesarrolladorService desarrolladorService) {
        this.desarrolladorService = desarrolladorService;
    }

    // 6. POST/developers -> Insertar un programador.
    @PostMapping
    public ResponseEntity<DesarrolladorResponseDTO> crearDesarrollador(@RequestBody DesarrolladorRequestDTO dto) {
        DesarrolladorResponseDTO nuevo = desarrolladorService.crearDesarrollador(dto);
        // 201 CREATED
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // 7. DELETE /developers/{id} -> Borrar un programador.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDesarrollador(@PathVariable Long id) {
        desarrolladorService.eliminarDesarrollador(id);
        // 204 NO CONTENT
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}