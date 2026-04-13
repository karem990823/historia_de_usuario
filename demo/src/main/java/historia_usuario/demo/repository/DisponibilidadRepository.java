package historia_usuario.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import historia_usuario.demo.model.Disponibilidad;
import historia_usuario.demo.model.Usuario;

@Repository
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Integer> {
    
    @Query("SELECT d.usuario FROM Disponibilidad d WHERE d.fecha_inicio <= :fecha " +
           "AND d.fecha_fin >= :fecha AND d.disponible = 'SI'")
    List<Usuario> findAvailableInstructors(@Param("fecha") LocalDateTime fecha);
}
