package com.example.ecomerceelectric.controller;

import org.springframework.stereotype.Controller;

import com.example.ecomerceelectric.model.Cliente;
import com.example.ecomerceelectric.services.ClienteService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller 
@RequestMapping("/Cliente")
public class ClienteController {
    
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
 
   }

   @GetMapping()
   public String ListarClientes(Model model) {
        model.addAttribute("ListaUsuarios", clienteService.getAllClientes());
        return "clientes";
   }
   @GetMapping ("/nuevo")
   public String MostrarFormularioNuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formulario_cliente";
   }

   @PostMapping ("/guardar")
    public String GuardarCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/Cliente";
   }

   @PostMapping ("/eliminar/{id}")
     public String eliminarCliente(@PathVariable("id") Long id) {
        clienteService.deleteCliente(id);
        return "redirect:/Cliente";
   }

}