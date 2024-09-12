package com.br.bcb_big_chat_brasil.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Mensagem {
    private int id;
    private String texto;
    private Date dataEnvio;
    private Cliente remetente;
    private Cliente destinatario;

}
