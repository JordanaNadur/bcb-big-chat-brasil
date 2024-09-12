package com.br.bcb_big_chat_brasil.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SendMessageController {

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody SendMessageRequest request) {
        // Verificar tipo de plano de pagamento do cliente
        // ...
        // Verificar créditos do cliente (se pre-pago)
        // ...
        // Enviar mensagem
        // ...
        return ResponseEntity.ok("Mensagem enviada com sucesso!");
    }
}

