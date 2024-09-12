package com.br.bcb_big_chat_brasil.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class PlanoPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    public boolean isAtivo() {
        return true;
    }

}
