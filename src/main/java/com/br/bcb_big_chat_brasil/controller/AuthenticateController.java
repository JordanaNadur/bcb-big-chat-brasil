package com.br.bcb_big_chat_brasil.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AuthenticateController {

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticateRequest request) {
        // Verificar credenciais do usuário
        // ...
        // Gerar token de autenticação
        String token = UUID.randomUUID().toString();
        return ResponseEntity.ok(token);
    }
}

