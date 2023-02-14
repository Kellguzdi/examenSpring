package mx.edu.utez.examen.models.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.transaccion.Transaccion;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false,length = 50,unique=true)
    private String nombre;

    @Column(name = "email",nullable = false,length = 100)
    private String correo;

    @Column(name = "password",nullable = false,length = 50)
    private String passwd;

    @Column(name = "list",nullable = true,length = 500)
    private String lista;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transaccion> transcciones;

    public Usuario(long id, String nombre, String correo, String passwd, String lista) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.passwd = passwd;
        this.lista = lista;
    }

}
