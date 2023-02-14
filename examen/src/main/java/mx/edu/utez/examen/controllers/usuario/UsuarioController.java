package mx.edu.utez.examen.controllers.usuario;

import mx.edu.utez.examen.controllers.usuario.dtos.UsuarioDto;
import mx.edu.utez.examen.models.usuario.Usuario;
import mx.edu.utez.examen.services.usuario.UsuarioService;
import mx.edu.utez.examen.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api-examen/usuario")
@CrossOrigin(origins = {"*"})
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    // URL: http://localhost:8080/api-firstapp/category/
    public ResponseEntity<CustomResponse<List<Usuario>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK);
    }

  /*  @PostMapping("/")
    // URL: http://localhost:8080/api-firstapp/category/
    public ResponseEntity<CustomResponse<Usuario>> insert(@RequestBody UsuarioDto user, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    new CustomResponse<>(null, true, 400, "The category already exists"),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                this.service.insert(user.castToUser()), HttpStatus.CREATED
        );
    }*/

    /*@PutMapping("/{id}")
    // URL: http://localhost:8080/api-firstapp/category/{id}
    public ResponseEntity<CustomResponse<Usuario>> update(@PathVariable("id") Long id, @RequestBody UsuarioDto user, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    new CustomResponse<>(null, true, 400, "The category already exists"),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                this.service.update(user.castToUser()), HttpStatus.OK
        );
    }*/


}
