package co.com.pedidos.repository;

import co.com.pedidos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

    List<Producto> findByIdProducto(Long idProducto);

}
