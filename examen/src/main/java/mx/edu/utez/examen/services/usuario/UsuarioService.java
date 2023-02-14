package mx.edu.utez.examen.services.usuario;

import mx.edu.utez.examen.models.usuario.Usuario;
import mx.edu.utez.examen.models.usuario.UsuarioRepository;
import mx.edu.utez.examen.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Usuario>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(), false, 200, "OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Usuario> getOne(Long id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(), false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Usuario> insert(Usuario user) {
        if (this.repository.existsByName(user.getNombre())) {
            return new CustomResponse<>(null, true, 400, "The user already exists");
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(user), false, 200, "User registered correctly!"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Usuario> update(Usuario user) {
        if (!this.repository.existsById(user.getId())) {
            return new CustomResponse<>(null, true, 400, "The user already exists");
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(user), false, 200, "User registered correctly!"
        );
    }


}
