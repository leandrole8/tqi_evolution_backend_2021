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

    public ResponseEntity<Cliente> updateCliente(Long id, Cliente cliente){
        return clienteRepository.findById(id)
                .map(record -> {
                    record.setNome(cliente.getNome());
                    record.setEmail(cliente.getEmail());
                    record.setCpf(cliente.getCpf());
                    record.setRg(cliente.getRg());
                    record.setEndereco(cliente.getEndereco());
                    record.setRenda(cliente.getRenda());
                    record.setSenha(cliente.getSenha());
                    record.setEmprestimo(cliente.getEmprestimo());
                    Cliente updated = clienteRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

}
