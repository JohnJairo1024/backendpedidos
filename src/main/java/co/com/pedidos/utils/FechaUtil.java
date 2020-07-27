package co.com.pedidos.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FechaUtil {

    /**
     * @param fecha
     * @return
     */
    public static String convertirDateToStringLargoGuion(Date fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        String reportDate = formatter.format(fecha);
        return reportDate;
    }


    /**
     * @param fecha
     * @return
     */
    public static String convertirDateToString(Date fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
        String reportDate = formatter.format(fecha);
        return reportDate;
    }

}
