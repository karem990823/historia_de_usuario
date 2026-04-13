package historia_usuario.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import historia_usuario.demo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Buscar usuarios por su rol (por ejemplo, buscar todos los que son 'Instructor')
    List<Usuario> findByRol_NombreRol(String nombreRol);
}

