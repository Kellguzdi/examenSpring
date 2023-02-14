package mx.edu.utez.examen.models.transaccion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.producto.Producto;
import mx.edu.utez.examen.models.usuario.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "transacciones")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;

    @JoinColumn(name = "producto_id",nullable = false)
    private Producto producto;

    @Column(nullable = false,length = 50)
    private String fecha;
}
