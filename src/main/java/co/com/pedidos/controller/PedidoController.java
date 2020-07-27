package co.com.pedidos.controller;

import co.com.pedidos.exception.ResourceNotFoundException;
import co.com.pedidos.model.Pedido;
import co.com.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedidos")
    public List<Pedido> getInstructors() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> gePedidoById(
            @PathVariable(value = "id") Long idPedido
    ) throws ResourceNotFoundException {
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new ResourceNotFoundException("pedido no encontrado :: " + idPedido));
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping("/pedidos")
    public Pedido crearPedido(@Valid @RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> actualizaPedido(
            @PathVariable(value = "id") Long idPedido,
            @Valid @RequestBody Pedido pedidoDetalle
    ) throws ResourceNotFoundException {
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no se encuentra :: " + idPedido));

        pedido.setCantidad(pedidoDetalle.getCantidad());
        pedido.setFechaOrden(pedidoDetalle.getFechaOrden());
        pedido.setEstado(pedidoDetalle.getEstado());
        final Pedido actualizarPedido = pedidoRepository.save(pedido);
        return ResponseEntity.ok(actualizarPedido);
    }

    @DeleteMapping("/pedidos/{id}")
    public Map<String, Boolean> eliminarPedido(
            @PathVariable(value = "id") Long idPedido
    ) throws ResourceNotFoundException {
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no se encuentra id :: " + idPedido));
        pedidoRepository.delete(pedido);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
