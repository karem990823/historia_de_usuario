package historia_usuario.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import historia_usuario.demo.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    // Buscar cursos por nombre
    List<Curso> findByNombreCursoContaining(String nombre);
}
