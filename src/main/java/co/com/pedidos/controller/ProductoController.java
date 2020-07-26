package co.com.pedidos.controller;

import co.com.pedidos.model.Producto;
import co.com.pedidos.exception.ResourceNotFoundException;
import co.com.pedidos.repository.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping("/producto")
    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> geProductoById(
            @PathVariable(value = "id") Long idProducto
    ) throws ResourceNotFoundException {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado para el id-Producto :: " + idProducto));
        return ResponseEntity.ok().body(producto);
    }

    @PostMapping("/producto")
    public Producto createProducto(@Valid @RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<Producto> updateProducto(
            @PathVariable(value = "id") Long idProducto,
            @Valid @RequestBody Producto productoDetalle
    ) throws ResourceNotFoundException {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no se encuentra :: " + idProducto));

        producto.setIdProducto(productoDetalle.getIdProducto());
        producto.setNombreProducto(productoDetalle.getNombreProducto());
        producto.setReferencia(productoDetalle.getReferencia());
        producto.setDescripcion(productoDetalle.getDescripcion());
        final Producto actualizarProducto = productoRepository.save(producto);
        return ResponseEntity.ok(actualizarProducto);
    }

    @DeleteMapping("/producto/{id}")
    public Map<String, Boolean> deleteProducto(
            @PathVariable(value = "id") Long idProducto
    ) throws ResourceNotFoundException {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no se encuentra id :: " + idProducto));

        productoRepository.delete(producto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
