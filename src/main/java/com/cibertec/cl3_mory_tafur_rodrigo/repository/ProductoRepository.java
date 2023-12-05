package com.cibertec.cl3_mory_tafur_rodrigo.repository;

import com.cibertec.cl3_mory_tafur_rodrigo.model.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    List<Producto> findByDescripcion(String descripcion);

}
