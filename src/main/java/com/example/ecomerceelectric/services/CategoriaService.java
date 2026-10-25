package com.example.ecomerceelectric.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecomerceelectric.model.Categoria;
import com.example.ecomerceelectric.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(categoriaExistente -> {
                    categoria.setId(id);
                    return categoriaRepository.save(categoria);
                })
                .orElse(null);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}