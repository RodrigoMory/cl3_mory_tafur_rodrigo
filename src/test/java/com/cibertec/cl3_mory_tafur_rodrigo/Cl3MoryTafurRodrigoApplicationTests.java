package com.cibertec.cl3_mory_tafur_rodrigo;

import com.cibertec.cl3_mory_tafur_rodrigo.model.Categoria;
import com.cibertec.cl3_mory_tafur_rodrigo.model.Producto;
import com.cibertec.cl3_mory_tafur_rodrigo.repository.CategoriaRepository;
import com.cibertec.cl3_mory_tafur_rodrigo.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Cl3MoryTafurRodrigoApplicationTests {
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Test
	void insertarCategoria() {

		Categoria categoria = new Categoria();
		categoria.setDescripcion("Abarrotes");

		Categoria categoriaRegistrado = categoriaRepository.save(categoria);

		assertThat(categoriaRegistrado).isNotNull();
		assertThat(categoriaRegistrado.getId()).isPositive();
		assertThat(categoriaRegistrado.getDescripcion()).isNotEmpty();

	}


	@Test
	void insertarProducto() {

		Producto producto = new Producto();

		producto.setDescripcion("Aceite Primor");
		producto.setPrecio(new BigDecimal("9.80"));
		producto.setStock(10);
		producto.setEstado(true);

		Categoria categoria = new Categoria();
		categoria.setDescripcion("Abarrotes");
		Categoria categoriaRegistrado = categoriaRepository.save(categoria);

		producto.setCategoria(categoriaRegistrado);

		Producto productoRegistrado = productoRepository.save(producto);

		assertThat(productoRegistrado.getId()).isPositive();
		assertThat(productoRegistrado.getDescripcion()).isNotEmpty();
		assertThat(productoRegistrado.getPrecio()).isNotNull();
		assertThat(productoRegistrado.getStock()).isNotNull();
		assertThat(productoRegistrado.getEstado()).isTrue();
		assertThat(productoRegistrado.getCategoria().getId()).isPositive();
		assertThat(productoRegistrado.getCategoria().getDescripcion()).isNotEmpty();

	}

	@Test
	void actualizarProducto() {

		// editar el producto con id 1
		Producto producto = productoRepository.findById(1L).orElse(null);

		// modificar el nombre del producto
		producto.setDescripcion("Aceite de Oliva");

		// guardar los cambios
		productoRepository.save(producto);

		// verificar que el nombre del producto se actualizo
		Producto productoActualizado = productoRepository.findById(1L).orElse(null);
		assertThat(productoActualizado.getDescripcion()).isEqualTo("Aceite de Oliva");
	}

	@Test
	void eliminarProducto() {

		// eliminar el producto con id 1
		productoRepository.deleteById(1L);

		// verificar que el producto con id 1 ya no existe
		Producto productoEliminado = productoRepository.findById(1L).orElse(null);
		assertThat(productoEliminado).isNull();

	}

	@Test
	void listarProductos(){
		Iterable<Producto> productos = productoRepository.findAll();
		assertThat(productos).isNotEmpty();
	}

	@Test
	void jpa_query_methods() {
		Iterable<Producto> productos = productoRepository.findByDescripcion("Aceite Primor");
		assertThat(productos).isNotEmpty();
	}

}
