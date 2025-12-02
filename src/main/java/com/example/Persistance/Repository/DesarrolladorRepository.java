// Archivo: src/main/java/com/example/Persistance/Repository/DesarrolladorRepository.java

package com.example.Persistance.Repository;

import com.example.Persistance.Model.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {
    
    // Implementará el POST/DELETE de desarrolladores.
    // No se requiere código adicional para los 9 endpoints obligatorios.
}