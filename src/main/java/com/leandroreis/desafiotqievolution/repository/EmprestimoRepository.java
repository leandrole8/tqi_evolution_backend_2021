package com.leandroreis.desafiotqievolution.repository;

import com.leandroreis.desafiotqievolution.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
