package historia_usuario.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol;

    @Column(name = "nombre_rol", nullable = false, length = 50)
    private String nombreRol;
}
