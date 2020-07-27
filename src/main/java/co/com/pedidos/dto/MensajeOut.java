package co.com.pedidos.dto;

import co.com.pedidos.utils.Constantes;
import co.com.pedidos.utils.FechaUtil;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@NoArgsConstructor
@Getter
@Setter
public class MensajeOut {

    private String codigoRespuesta;
    private String mensaje;
    private String fecha;
    private boolean exitoso;

    public MensajeOut(boolean exitoso, String mensaje) {
        this.exitoso = exitoso;
        if (exitoso) {
            this.setMensaje(Constantes.MENSAJE_OK);
            this.setCodigoRespuesta(Constantes.CodigoRespuesta.Exitoso.toString());
        } else {
            this.setCodigoRespuesta(Constantes.CodigoRespuesta.Fallido.toString());
        }
        if (mensaje != null) {
            this.setMensaje(mensaje);
        }
        this.setFecha(FechaUtil.convertirDateToString(new Date()));
    }
}
