package com.example.Persistance.Repository;
import com.example.Persistance.Model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    /*
      Define la consulta para GET /projects/{word}.
      Busca proyectos donde el campo 'nombre' contenga la 'word'
      (el 'Containing' hace el LIKE %word%) e ignora mayúsculas/minúsculas.
     */
    List<Proyecto> findByNombreContainingIgnoreCase(String word);
}