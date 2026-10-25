package com.example.ecomerceelectric.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecomerceelectric.model.Producto;
import com.example.ecomerceelectric.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor 

public class ProductoService {
    private final ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Long id, Producto producto) {
        return productoRepository.findById(id)
                .map(productoExistente -> {
                    producto.setId(id);
                    return productoRepository.save(producto);
                })
                .orElse(null);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

}
