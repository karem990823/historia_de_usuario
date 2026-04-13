package historia_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import historia_usuario.model.ProgramacionCurso;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProgramacionCursoRepository extends JpaRepository<ProgramacionCurso, Integer> {
    
    // Buscar todas las clases programadas para un día específico
    // Útil para ver el cronograma del día y detectar huecos
    List<ProgramacionCurso> findByFecha(LocalDate fecha);

    // Buscar clases de un instructor específico 
    // (Para saber a quiénes afecta si el instructor falta)
    List<ProgramacionCurso> findByInstructor_IdUsuario(Long idUsuario);
}