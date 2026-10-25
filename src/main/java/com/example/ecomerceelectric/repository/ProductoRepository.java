package com.example.ecomerceelectric.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecomerceelectric.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
