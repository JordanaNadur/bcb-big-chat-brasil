package com.br.bcb_big_chat_brasil.controller;

public class AlterarLimiteRequest {

    private Long clienteId;
    private Double novoLimite;

    // Getters and Setters
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Double getNovoLimite() {
        return novoLimite;
    }

    public void setNovoLimite(Double novoLimite) {
        this.novoLimite = novoLimite;
    }
}
