package co.com.pedidos.services;

import co.com.pedidos.dto.MensajeOut;
import co.com.pedidos.model.Pedido;
import co.com.pedidos.model.Producto;
import co.com.pedidos.repository.PedidoRepository;
import co.com.pedidos.repository.ProductoRepository;
import co.com.pedidos.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServices {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    /**
     * @param pedido
     * @return
     */
    public MensajeOut crearPedido(Pedido pedido) {

        MensajeOut mensajeOut = new MensajeOut();
        List<Producto> listaproducto = productoRepository.findByIdProducto(pedido.getProducto().getIdProducto());
        if (listaproducto == null) {
            mensajeOut.setMensaje(Constantes.MSJ_PRODUCTO);
            return mensajeOut;
        } else if (listaproducto.size() > 0) {
            mensajeOut.setMensaje(Constantes.MSJ_PRODUCTO_YA_EXISTE);
            return mensajeOut;
        }

        // Guardamos el pedido
        Pedido crearPedido = new Pedido();
        crearPedido.setCantidad(pedido.getCantidad());
        crearPedido.setEstado(pedido.getEstado());
        crearPedido.setFechaOrden(pedido.getFechaOrden());
        Producto producto = new Producto();
        producto.setIdProducto(pedido.getProducto().getIdProducto());
        producto.setNombreProducto(pedido.getProducto().getNombreProducto());
        crearPedido.setProducto(producto);
        pedidoRepository.save(crearPedido);
        mensajeOut.setMensaje(Constantes.MSJ_PRODUCTO_GUARDAR);
        return mensajeOut;
    }
}
