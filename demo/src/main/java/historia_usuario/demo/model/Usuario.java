package historia_usuario.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    
    private String nombre;
    private String apellido;
    
    @Enumerated(EnumType.STRING)
    private TipoRegistro tipo_registro; // 'empresa', 'trabajador', 'usuario'

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}

enum TipoRegistro { empresa, trabajador, usuario }