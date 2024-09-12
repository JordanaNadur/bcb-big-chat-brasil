package com.br.bcb_big_chat_brasil.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpfResponsavel;
    private String cnpj;
    private String nomeEmpresa;
    private PlanoPagamento planoPagamento;
    private Double saldo;
    private Double limite;

}
