package com.example.ecomerceelectric.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.example.ecomerceelectric.model.Categoria;
import com.example.ecomerceelectric.services.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) Long buscarId, Model model) {
        List<Categoria> categorias;
        if (buscarId == null) {
            categorias = categoriaService.getAllCategorias();
        } else {
            Categoria categoria = categoriaService.getCategoriaById(buscarId);
            categorias = categoria == null ? List.of() : List.of(categoria);
        }
        model.addAttribute("categorias", categorias);
        model.addAttribute("buscarId", buscarId);
        return "categorias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.getCategoriaById(id);
        if (categoria == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoría no encontrada");
        }
        model.addAttribute("categoria", categoria);
        return "editar_categoria";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Categoria categoria) {
        categoriaService.saveCategoria(categoria);
        return "redirect:/categorias";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return "redirect:/categorias";
    }
}
