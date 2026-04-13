package historia_usuario.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cursos")
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_curso;

    @Column(name = "nombre_curso", length = 100)
    private String nombreCurso;

    @Column(name = "intensidad_horaria")
    private Integer intensidadHoraria;
}