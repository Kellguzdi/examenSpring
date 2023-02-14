package mx.edu.utez.examen.models.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    boolean updateStatusById(@Param("id") Long id, @Param("status")boolean status);
    boolean existsByName(String name);
}
