package com.br.bcb_big_chat_brasil.controller;

import com.br.bcb_big_chat_brasil.entity.PlanoPagamento;
import com.br.bcb_big_chat_brasil.service.PlanoPagamentoService;
import com.br.bcb_big_chat_brasil.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final SendMessageService sendMessageService;
    private final PlanoPagamentoService planoPagamentoService;

    private final MensagemRequest mensagemRequest;

    @Autowired
    public MessageController(SendMessageService sendMessageService, PlanoPagamentoService planoPagamentoService, MensagemRequest mensagemRequest) {
        this.sendMessageService = sendMessageService;
        this.planoPagamentoService = planoPagamentoService;
        this.mensagemRequest = mensagemRequest;
    }

    @PostMapping("/enviar-mensagem")
    public ResponseEntity<String> sendMessage(MensagemRequest mensagemRequest) {
        try {
            // Verificar se o plano de pagamento está ativo antes de enviar a mensagem
            Long clienteId = mensagemRequest.getClienteId();
            if (clienteId == null) {
                return new ResponseEntity<>("Cliente ID não informado", HttpStatus.BAD_REQUEST);
            }

            PlanoPagamento planoPagamento = planoPagamentoService.findById(clienteId);
            if (planoPagamento == null) {
                return new ResponseEntity<>("Plano de pagamento não encontrado", HttpStatus.NOT_FOUND);
            }

            if (!planoPagamento.isAtivo()) {
                return new ResponseEntity<>("Plano de pagamento inativo", HttpStatus.FORBIDDEN);
            }

            String phoneNumber = mensagemRequest.getPhoneNumber();
            if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
                return new ResponseEntity<>("Número de telefone não informado", HttpStatus.UNPROCESSABLE_ENTITY);
            }

            String messageText = mensagemRequest.getMensagem();
            if (messageText == null || messageText.trim().isEmpty()) {
                return new ResponseEntity<>("Mensagem não informada", HttpStatus.UNPROCESSABLE_ENTITY);
            }

            boolean isWhatsApp = mensagemRequest.isWhatsapp();

            sendMessageService.sendMessage(clienteId, phoneNumber, isWhatsApp, messageText);
            return new ResponseEntity<>("Mensagem enviada com sucesso!", HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao enviar mensagem: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
