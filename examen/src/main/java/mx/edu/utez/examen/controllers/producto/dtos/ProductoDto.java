package mx.edu.utez.examen.controllers.producto.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.producto.Producto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDto {
    private long id;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 150)
    private String name;
    private String categoria;

    private int precio;
    private Boolean disponibilidad;

    public Producto castToProducto() {
        return new Producto(
                this.id,
                this.name,
                this.categoria,
                this.precio,
                this.disponibilidad
        );
    }
}
