package com.leandroreis.desafiotqievolution.repository;

import com.leandroreis.desafiotqievolution.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
