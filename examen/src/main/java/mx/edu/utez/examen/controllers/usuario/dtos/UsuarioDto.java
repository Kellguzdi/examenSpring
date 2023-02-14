package mx.edu.utez.examen.controllers.usuario.dtos;

import lombok.*;
import org.apache.catalina.User;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {
    private long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "password is required")
    private String password;

    private String list;

    /*public User castToUser(){
        return new User(
                this.id,
                this.name,
                this.password,
                this.email,
                this.list
        );
    }*/
}
