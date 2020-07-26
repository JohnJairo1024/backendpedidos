package co.com.pedidos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idProducto;

    @Column(name = "nombre_producto")
    public String nombreProducto;

    @Column(name = "referencia")
    public String referencia;

    @Column(name = "descripcion")
    public String descripcion;

    public Producto() {

    }

    public Producto(String nombreProducto, String referencia, String descripcion) {
        this.nombreProducto = nombreProducto;
        this.referencia = referencia;
        this.descripcion = descripcion;
    }


}
