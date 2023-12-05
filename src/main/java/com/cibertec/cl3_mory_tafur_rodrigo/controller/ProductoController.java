package com.cibertec.cl3_mory_tafur_rodrigo.controller;

import com.cibertec.cl3_mory_tafur_rodrigo.model.Producto;
import com.cibertec.cl3_mory_tafur_rodrigo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarTodosLosProductos() {return productoService.listarTodosLosProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable("id") Long id) { return productoService.obtenerProducto(id);
    }

    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable("id") Long id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.actualizarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable("id") Long id) { productoService.eliminarProducto(id);
    }
}
