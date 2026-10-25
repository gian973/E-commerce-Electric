package com.example.ecomerceelectric.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecomerceelectric.model.Proveedor;
import com.example.ecomerceelectric.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;

    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor getProveedorById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor updateProveedor(Long id, Proveedor proveedor) {
        return proveedorRepository.findById(id)
                .map(proveedorExistente -> {
                    proveedor.setId(id);
                    return proveedorRepository.save(proveedor);
                })
                .orElse(null);
    }

    public void deleteProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}