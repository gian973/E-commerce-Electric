package com.example.ecomerceelectric.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecomerceelectric.model.Cliente;
import com.example.ecomerceelectric.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final CustomerRepository customerRepository;

    public List<Cliente> getAllClientes() {
        return customerRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Cliente saveCliente(Cliente cliente) {
        return customerRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        return customerRepository.findById(id)
                .map(clienteExistente -> {
                    cliente.setId(id);
                    return customerRepository.save(cliente);
                })
                .orElse(null);
    }

    public void deleteCliente(Long id) {
        customerRepository.deleteById(id);
    }
}