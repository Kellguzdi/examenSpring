package mx.edu.utez.examen.models.producto;

import mx.edu.utez.examen.models.usuario.Usuario;
import mx.edu.utez.examen.models.usuario.UsuarioRepository;
import mx.edu.utez.examen.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Long>{

}
