package co.com.pedidos.services;

import co.com.pedidos.dto.MensajeOut;
import co.com.pedidos.model.Producto;
import co.com.pedidos.repository.ProductoRepository;
import co.com.pedidos.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServices {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * @param producto
     * @return
     */
    public MensajeOut crearproducto(Producto producto) {

        MensajeOut mensajeOut = new MensajeOut();
        mensajeOut.setExitoso(true);

        List<Producto> listaproducto = productoRepository.findByIdProducto(producto.getIdProducto());
        if (listaproducto == null) {
            mensajeOut.setMensaje(Constantes.MSJ_PRODUCTO);
            mensajeOut.setExitoso(false);
            return mensajeOut;
        } else if (listaproducto.size() > 0) {
            mensajeOut.setMensaje(Constantes.MSJ_PRODUCTO_YA_EXISTE);
            mensajeOut.setExitoso(false);
            return mensajeOut;
        }

        // Guardamos el producto
        Producto crearProducto = new Producto();
        crearProducto.setIdProducto(producto.getIdProducto());
        crearProducto.setNombreProducto(producto.getNombreProducto());
        crearProducto.setReferencia(producto.getReferencia());
        crearProducto.setDescripcion(producto.getDescripcion());
        productoRepository.save(crearProducto);
        mensajeOut.setMensaje(Constantes.MSJ_PRODUCTO_GUARDAR);
        return mensajeOut;
    }

}
