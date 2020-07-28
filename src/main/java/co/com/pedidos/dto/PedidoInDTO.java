package co.com.pedidos.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PedidoInDTO {

    private Long idPedido;
    private Long cantidad;
    private Date fechaOrden;
    private String estado;
    private Long idProducto;
}
