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

import com.example.ecomerceelectric.model.Proveedor;
import com.example.ecomerceelectric.services.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) Long buscarId, Model model) {
        List<Proveedor> proveedores;
        if (buscarId == null) {
            proveedores = proveedorService.getAllProveedores();
        } else {
            Proveedor proveedor = proveedorService.getProveedorById(buscarId);
            proveedores = proveedor == null ? List.of() : List.of(proveedor);
        }
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("buscarId", buscarId);
        return "proveedores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Proveedor proveedor = proveedorService.getProveedorById(id);
        if (proveedor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        }
        model.addAttribute("proveedor", proveedor);
        return "editar_proveedor";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proveedor proveedor) {
        proveedorService.saveProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        proveedorService.deleteProveedor(id);
        return "redirect:/proveedores";
    }
}
