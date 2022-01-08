package com.leandroreis.desafiotqievolution.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.sql.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valorEmprestimo;

    @Column(nullable = false)
    private Date dataPrimeiraParcela;

    @Column(nullable = false)
    @Max(60)
    private Integer qtdadeParcelas;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
