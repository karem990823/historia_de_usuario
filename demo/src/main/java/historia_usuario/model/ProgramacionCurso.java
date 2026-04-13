package historia_usuario.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "programacion_cursos")
@Data
public class ProgramacionCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_programacion;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    private LocalDate fecha;
    private LocalTime hora;
    private Integer cupos;

    @ManyToOne
    @JoinColumn(name = "id_usuario") // El instructor asignado
    private Usuario instructor;
}