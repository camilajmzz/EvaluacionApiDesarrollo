package com.example.Controller.DTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
// Mapea esta excepción automáticamente a un código de respuesta HTTP 404
@ResponseStatus(HttpStatus.NOT_FOUND) 
public class RecursoNoEncontradoException extends RuntimeException {
    
    public RecursoNoEncontradoException(String recurso, Long id) {
        super("El recurso " + recurso + " con ID " + id + " no fue encontrado.");
    }
}