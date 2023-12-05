package com.cibertec.cl3_mory_tafur_rodrigo.service.impl;

import com.cibertec.cl3_mory_tafur_rodrigo.model.Categoria;
import com.cibertec.cl3_mory_tafur_rodrigo.repository.CategoriaRepository;
import com.cibertec.cl3_mory_tafur_rodrigo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        validarCategoria(categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        validarCategoria(categoria);
        if (!categoriaRepository.existsById(categoria.getId())) {
            throw new IllegalArgumentException("La categoria con el ID especificado no existe.");
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new IllegalArgumentException("La categoria con el ID especificado no existe.");
        }
        categoriaRepository.deleteById(id);

    }

    @Override
    public Categoria obtenerCategoria(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isEmpty()) {
            throw new IllegalArgumentException("La categoria con el ID especificado no existe.");
        }
        return categoria.get();
    }

    @Override
    public List<Categoria> listarTodasLasCategorias() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    private void validarCategoria(Categoria categoria) {
        if (categoria.getDescripcion() == null || categoria.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción de la categoria no puede estar vacía.");
        }
    }

}
