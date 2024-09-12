package com.br.bcb_big_chat_brasil.controller;

import lombok.Data;

@Data
public class IncluirCreditosRequest {

    private Long clienteId;
    private Double valor;


    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
