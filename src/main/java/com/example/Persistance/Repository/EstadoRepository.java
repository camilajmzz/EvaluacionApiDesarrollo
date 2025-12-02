// Archivo: src/main/java/com/example/Persistance/Repository/EstadoRepository.java

package com.example.Persistance.Repository;

import com.example.Persistance.Model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Anotación para que Spring la gestione
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    
    // Todos los métodos CRUD básicos (save, findById, findAll, delete, etc.)
    // se heredan automáticamente de JpaRepository<Entidad, Tipo_de_ID>.
}