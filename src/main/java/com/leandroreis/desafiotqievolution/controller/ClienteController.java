package com.leandroreis.desafiotqievolution.controller;

import com.leandroreis.desafiotqievolution.model.Cliente;
import com.leandroreis.desafiotqievolution.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/cadastrar")
    public Cliente cadastro(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping
    public List<Cliente> pesquisaTodos(){
        return clienteRepository.findAll();
    }
    //fazer o clone do projeto antes de modificar DTO e demais classes!!
}
