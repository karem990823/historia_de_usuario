package historia_usuario.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "disponibilidad")
@Data
public class Disponibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_disponibilidad;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('SI', 'NO')")
    private EstadoDisponibilidad disponible;

    @ManyToOne
    @JoinColumn(name = "id_usuario") // Foránea al Instructor
    private Usuario usuario;
}

// Enum para manejar el SI/NO de la base de datos
enum EstadoDisponibilidad {
    SI, NO
}