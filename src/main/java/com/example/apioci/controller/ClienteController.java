package com.example.apioci.controller;

import com.example.apioci.model.Cliente;
import com.example.apioci.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> consultarClientes() {
        try {
            List<Cliente> clientes = clienteRepository.consultarClientes();
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/{cpf}/bloquear")
    public ResponseEntity<String> bloquearCliente(@PathVariable String cpf) {
        try {
            clienteRepository.bloquearCliente(cpf);
            return ResponseEntity.ok("Cliente bloqueado com sucesso: " + cpf);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao bloquear cliente: " + e.getMessage());
        }
    }

    @PostMapping("/{cpf}/desbloquear")
    public ResponseEntity<String> desbloquearCliente(@PathVariable String cpf) {
        try {
            clienteRepository.desbloquearCliente(cpf);
            return ResponseEntity.ok("Cliente desbloqueado com sucesso: " + cpf);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao desbloquear cliente: " + e.getMessage());
        }
    }
}
