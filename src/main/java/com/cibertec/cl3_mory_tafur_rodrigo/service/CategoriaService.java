package com.cibertec.cl3_mory_tafur_rodrigo.service;

import com.cibertec.cl3_mory_tafur_rodrigo.model.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria guardarCategoria(Categoria categoria);

    Categoria actualizarCategoria(Categoria categoria);

    void eliminarCategoria(Long id);

    Categoria obtenerCategoria(Long id);

    List<Categoria> listarTodasLasCategorias();
}
