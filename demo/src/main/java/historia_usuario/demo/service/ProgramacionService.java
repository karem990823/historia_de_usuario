package historia_usuario.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import historia_usuario.demo.model.ProgramacionCurso;
import historia_usuario.demo.model.Usuario;
import historia_usuario.demo.repository.DisponibilidadRepository;
import historia_usuario.demo.repository.ProgramacionCursoRepository;
import historia_usuario.demo.repository.UsuarioRepository;

@Service
public class ProgramacionService {

    @Autowired
    private ProgramacionCursoRepository programacionRepo;

    @Autowired
    private DisponibilidadRepository disponibilidadRepo;
    @Autowired
    private UsuarioRepository usuarioRepo;

    // Buscar instructores alternativos para una fecha y hora específica
    public List<Usuario> buscarInstructoresDisponibles(LocalDateTime fechaHora) {
        return disponibilidadRepo.findAvailableInstructors(fechaHora);
    }

    // Reasignar un curso a un nuevo instructor por emergencia
    public ProgramacionCurso reasignarInstructor(Integer idProgramacion, Integer idNuevoInstructor) {
        ProgramacionCurso pc = programacionRepo.findById(idProgramacion)
            .orElseThrow(() -> new RuntimeException("Programación no encontrada"));
        
    Usuario nuevoInstructor = usuarioRepo.findById(idNuevoInstructor)
        .orElseThrow(() -> new RuntimeException("El Instructor no existe"));
    
    // 3. Lo asignamos y guardamos
    pc.setInstructor(nuevoInstructor); 
    return programacionRepo.save(pc);
}
}