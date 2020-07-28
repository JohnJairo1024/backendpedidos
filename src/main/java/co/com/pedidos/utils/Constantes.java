package co.com.pedidos.utils;

public class Constantes {

    public enum CodigoRespuesta {
        Fallido, Exitoso
    }

    public static final String MENSAJE_OK = "Consulta o transacción exitosa";
    public static final String MSJ_ERROR_GENERAL = "Error generar de la aplicación.";
    public static final String MSJ_ERROR_CAMPOS_OBLIGATORIOS = "No se recibieron campos obligatorios.";

    /**
     * Mensajes para el producto
     */
    public static final String MSJ_PRODUCTO = "Debes ingresar al menos un producto referencia.";
    public static final String MSJ_PRODUCTO_NO_EXISTE = "El producto que deseas ingresar no existe ..";
    public static final String MSJ_PRODUCTO_YA_EXISTE = "Ya Existe este producto.";
    public static final String MSJ_PRODUCTO_GUARDAR = "Se guarda con éxito el producto.";
    public static final String MSJ_PEDIDO_GUARDAR = "Se guarda con éxito el pedido.";

}
