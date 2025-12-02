// Archivo: src/main/java/com/example/Persistance/Repository/TecnologiaRepository.java

package com.example.Persistance.Repository;

import com.example.Persistance.Model.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long> {
    
    // Implementará el POST/DELETE de tecnologías.
    // No se requiere código adicional para los 9 endpoints obligatorios.
}