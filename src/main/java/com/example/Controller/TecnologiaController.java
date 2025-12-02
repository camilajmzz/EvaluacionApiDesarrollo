package com.example.Controller;
import com.example.Controller.DTO.TecnologiaRequestDTO;
import com.example.Controller.DTO.TecnologiaResponseDTO;
import com.example.Service.TecnologiaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/technologies")
public class TecnologiaController {

    private final TecnologiaService tecnologiaService;

    public TecnologiaController(TecnologiaService tecnologiaService) {
        this.tecnologiaService = tecnologiaService;
    }

    // POST /technologies Insertar tecnología.
    @PostMapping
    public ResponseEntity<TecnologiaResponseDTO> crearTecnologia(@RequestBody TecnologiaRequestDTO dto) {
        TecnologiaResponseDTO nueva = tecnologiaService.crearTecnologia(dto);
        // 201 CREATED
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    // DELETE /technologies/{id}  Borrar tecnología.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTecnologia(@PathVariable Long id) {
        tecnologiaService.eliminarTecnologia(id);
        // 204 NO CONTENT
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}