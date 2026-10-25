package com.example.ecomerceelectric.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecomerceelectric.model.Cliente;

public interface CustomerRepository extends JpaRepository<Cliente, Long>{
    
}
