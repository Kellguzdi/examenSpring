package mx.edu.utez.examen.controllers.producto;

import mx.edu.utez.examen.controllers.producto.dtos.ProductoDto;
import mx.edu.utez.examen.models.producto.Producto;
import mx.edu.utez.examen.services.producto.ProductoService;
import mx.edu.utez.examen.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-examen/producto")
@CrossOrigin(origins = {"*"})
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping("/")
    // URL: http://localhost:8080/api-examen/producto/
    public ResponseEntity<CustomResponse<List<Producto>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK);
    }

    @PostMapping("/")
    // URL: http://localhost:8080/api-examen/producto/
    public ResponseEntity<CustomResponse<Producto>> insert(@RequestBody ProductoDto producto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    new CustomResponse<>(null, true, 400, "The category already exists"),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                this.service.insert(producto.castToProducto()), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    // URL: http://localhost:8080/api-firstapp/category/{id}
    public ResponseEntity<CustomResponse<Producto>> update(@PathVariable("id") Long id, @RequestBody ProductoDto category, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    new CustomResponse<>(null, true, 400, "The category already exists"),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                this.service.update(category.castToProducto()), HttpStatus.OK
        );
    }


}
