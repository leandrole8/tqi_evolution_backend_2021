package com.leandroreis.desafiotqievolution.service;

import com.leandroreis.desafiotqievolution.model.Cliente;
import com.leandroreis.desafiotqievolution.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listAll(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> listById(Long id){

        return clienteRepository.findById(id);
    }

    public Cliente newCliente(Cliente cliente){

        return clienteRepository.save(cliente);
    }

    public void delete(Long id){

        clienteRepository.deleteById(id);
    }

}
