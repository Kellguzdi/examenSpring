package mx.edu.utez.examen.services.producto;

import mx.edu.utez.examen.models.producto.Producto;
import mx.edu.utez.examen.models.producto.ProductoRepository;
import mx.edu.utez.examen.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Producto>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(), false, 200, "OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Producto> getOne(Long id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(), false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Producto> insert(Producto producto) {
        if (this.repository.existsById(producto.getId())) {
            return new CustomResponse<>(null, true, 400, "The user already exists");
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(producto), false, 200, "User registered correctly!"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Producto> update(Producto producto) {
        if (!this.repository.existsById(producto.getId())) {
            return new CustomResponse<>(null, true, 400, "The user already exists");
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(producto), false, 200, "User registered correctly!"
        );
    }
}
