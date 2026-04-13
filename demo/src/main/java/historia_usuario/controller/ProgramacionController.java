package historia_usuario.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import historia_usuario.model.ProgramacionCurso;
import historia_usuario.model.Usuario;
import historia_usuario.service.ProgramacionService;

@RestController
@RequestMapping("/api/programacion")
public class ProgramacionController {

    @Autowired
    private ProgramacionService service;

    @GetMapping("/disponibles")
    public ResponseEntity<List<Usuario>> obtenerDisponibles(@RequestParam LocalDateTime fecha) {
        return ResponseEntity.ok(service.buscarInstructoresDisponibles(fecha));
    }

    @PutMapping("/reasignar/{id}")
    public ResponseEntity<ProgramacionCurso> reasignar(@PathVariable Integer id, @RequestParam Integer idInstructor) {
        return ResponseEntity.ok(service.reasignarInstructor(id, idInstructor));
    }
}