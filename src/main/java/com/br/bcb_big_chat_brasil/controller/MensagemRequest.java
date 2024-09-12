package com.br.bcb_big_chat_brasil.controller;

import lombok.Data;

@Data
public class MensagemRequest {
    private Long clienteId;
    private String phoneNumber;
    private String mensagem;
    private boolean whatsapp;

    // getters and setters

    public MensagemRequest(Long clienteId, String phoneNumber, String mensagem, boolean whatsapp) {
        if (clienteId == null) {
            throw new NullPointerException("Cliente ID não informado");
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new NullPointerException("Número de telefone não informado");
        }
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new NullPointerException("Mensagem não informada");
        }
        this.clienteId = clienteId;
        this.phoneNumber = phoneNumber;
        this.mensagem = mensagem;
        this.whatsapp = whatsapp;
    }
}