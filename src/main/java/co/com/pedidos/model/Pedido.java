package co.com.pedidos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_orden")
    private Long idOrden;

    @Column(name = "cantidad")
    private Long cantidad;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_orden")
    private Date fechaOrden;

    @Column(name = "estado")
    private String estado;

    public Long idProducto;

    public Pedido() {
    }

    public Pedido(Long cantidad, Date fechaOrden, String estado, Long idProducto) {
        this.cantidad = cantidad;
        this.fechaOrden = fechaOrden;
        this.estado = estado;
        this.idProducto = idProducto;
    }

}
