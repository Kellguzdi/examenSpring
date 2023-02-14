package mx.edu.utez.examen.models.producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_producto",nullable = false, length = 50)
    private String name;

    @Column(name = "category",nullable = false,length = 50)
    private String categoria;

    @Column(name = "price", nullable = false,length = 15)
    private int precio;

    @Column(nullable = false,columnDefinition = "TINYINY DEFAULT 1")
    private boolean disponibilidad;


}
