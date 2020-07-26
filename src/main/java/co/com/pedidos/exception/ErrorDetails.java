package co.com.pedidos.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorDetails {
    private Date timestamp;
    private String mensaje;
    private String detalle;

    public ErrorDetails(Date timestamp, String mensaje, String detalle) {
        super();
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.detalle = detalle;
    }
}
