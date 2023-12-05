package com.cibertec.cl3_mory_tafur_rodrigo.service;

import com.cibertec.cl3_mory_tafur_rodrigo.model.Producto;

import java.util.List;

public interface ProductoService {

    Producto guardarProducto(Producto producto);

    Producto actualizarProducto(Producto producto);

    void eliminarProducto(Long id);

    Producto obtenerProducto(Long id);

    List<Producto> listarTodosLosProductos();

}
