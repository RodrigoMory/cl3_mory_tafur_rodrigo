package com.cibertec.cl3_mory_tafur_rodrigo.service.impl;

import com.cibertec.cl3_mory_tafur_rodrigo.model.Producto;
import com.cibertec.cl3_mory_tafur_rodrigo.repository.ProductoRepository;
import com.cibertec.cl3_mory_tafur_rodrigo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardarProducto(Producto producto) {
        validarProducto(producto);
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        validarProducto(producto);
        if (productoRepository.existsById(producto.getId())){
            throw new IllegalArgumentException("El producto con el ID especificado no existe");
        }
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (productoRepository.existsById(id)){
            throw new IllegalArgumentException("El producto con el ID especificado no existe");
        }
        productoRepository.deleteById(id);

    }

    @Override
    public Producto obtenerProducto(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isEmpty()) {
            throw new IllegalArgumentException("El producto con el ID especificado no existe.");
        }
        return producto.get();
    }

    @Override
    public List<Producto> listarTodosLosProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    private void validarProducto(Producto producto) {

        if (producto.getDescripcion() == null || producto.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion del producto no puede estar vacío.");
        }
        if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (producto.getStock() == null) {
            throw new IllegalArgumentException("El stock no puede estar vacía.");
        }
        if (!producto.getEstado()) {
            throw new IllegalArgumentException("El estado del producto no puede ser falso");
        }
        if (producto.getCategoria() == null || producto.getCategoria().getId() == null) {
            throw new IllegalArgumentException("La categoria asignada no es válida.");
        }
    }
}
