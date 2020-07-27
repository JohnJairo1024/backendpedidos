package co.com.pedidos;

import co.com.pedidos.model.Producto;
import co.com.pedidos.repository.ProductoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Autowired
    private ProductoRepository productoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            productoRepository.save(new Producto(1L, "Computador Portatil", "Gamer Acer Nitro", "Cada generación trae consigo avances tecnológicos: poder, diseños futuristas y gran rendimiento, junto a velocidad y procesamiento inigualable. Por esto, Acer trae consigo el nuevo Notebook Nitro 5"));
            productoRepository.save(new Producto(2L, "Teclado", "Logitech Mk235", "Escribe hasta tres años entre cambios de pilas y usa el ratón hasta un año antes de tener que cambiar la pila. La predicción de tres años de duración de las pilas se basa en aproximadamente dos millones de pulsaciones por año en un entorno empresaria"));
            productoRepository.save(new Producto(3L, "Router inalambrico", "AC5300", "Un router inalámbrico o WIFI es un dispositivo que realiza las funciones de un router, pero también incluye las funciones de un punto de acceso inalámbrico hilo"));
        };
    }

}


