package com.br.bcb_big_chat_brasil.controller;

public class AlterarPlanoRequest {

    private Long clienteId;
    private Long novoPlanoId;

    // Getters and Setters
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getNovoPlanoId() {
        return novoPlanoId;
    }

    public void setNovoPlanoId(Long novoPlanoId) {
        this.novoPlanoId = novoPlanoId;
    }
}
