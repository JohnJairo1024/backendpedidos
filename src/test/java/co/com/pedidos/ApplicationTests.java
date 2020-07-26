package co.com.pedidos;

import co.com.pedidos.model.Producto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testObtenerTodosProductos() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/producto", HttpMethod.GET, entity, String.class);
		assertNotNull(response.getBody());
	}

	@Test
	public void testObtenerProductoById() {
		Producto producto = restTemplate.getForObject(getRootUrl() + "/producto/1", Producto.class);
		System.out.println(producto.getIdProducto());
		assertNotNull(producto);
	}

	@Test
	public void testCrearProducto() {
		Producto producto = new Producto();
		producto.setNombreProducto("teclado");
		producto.setReferencia("H46");
		producto.setDescripcion("Excelente estado.");

		ResponseEntity<Producto> postResponse = restTemplate.postForEntity(getRootUrl() + "/producto", producto, Producto.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testActualizarProducto() {
		int id = 1;
		Producto producto = restTemplate.getForObject(getRootUrl() + "/producto/" + id, Producto.class);
		producto.setNombreProducto("teclado");
		producto.setReferencia("teclado");
		producto.setDescripcion("teclado");
		restTemplate.put(getRootUrl() + "/producto/" + id, producto);
		Producto actproducto = restTemplate.getForObject(getRootUrl() + "/producto/" + id, Producto.class);
		assertNotNull(actproducto);
	}

	@Test
	public void testEliminarProducto() {
		int id = 2;
		Producto producto = restTemplate.getForObject(getRootUrl() + "/producto/" + id, Producto.class);
		assertNotNull(producto);
		restTemplate.delete(getRootUrl() + "/producto/" + id);
		try {
			producto = restTemplate.getForObject(getRootUrl() + "/producto/" + id, Producto.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
