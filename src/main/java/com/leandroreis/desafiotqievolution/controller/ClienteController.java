package com.leandroreis.desafiotqievolution.controller;

import com.leandroreis.desafiotqievolution.model.Cliente;
import com.leandroreis.desafiotqievolution.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> newCliente(@RequestBody Cliente cliente){
        Cliente cliente1 = clienteService.newCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public List<Cliente> pesquisaTodos(){

        return clienteService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> clienteById(@PathVariable Long id){
        return clienteService.listById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id){
        return clienteService.listById(id)
                .map(record -> {
                    clienteService.delete(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
                }).orElse(ResponseEntity.notFound().build());
    }

}
