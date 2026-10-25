package com.example.ecomerceelectric.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecomerceelectric.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    
}

