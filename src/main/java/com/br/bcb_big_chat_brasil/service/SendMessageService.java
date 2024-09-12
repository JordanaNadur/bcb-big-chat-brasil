package com.br.bcb_big_chat_brasil.service;

import com.br.bcb_big_chat_brasil.entity.Cliente;
import com.br.bcb_big_chat_brasil.entity.PlanoPagamento;
import com.br.bcb_big_chat_brasil.enun.PlanoPagamentoEnum;
import com.br.bcb_big_chat_brasil.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMessageService {

    @Autowired
    private ClienteRepository clienteRepository;

    private PlanoPagamentoEnum planoPagamentoEnum;

    public void sendMessage(Long clienteId, String phoneNumber, boolean isWhatsApp, String messageText) {
        Cliente cliente = clienteRepository.findById(Math.toIntExact(clienteId));

        PlanoPagamento planoPagamento = cliente.getPlanoPagamento();
        if (planoPagamento == null) {
            throw new RuntimeException("Plano de pagamento não encontrado");
        }

        if (planoPagamentoEnum == PlanoPagamentoEnum.PRE_PAGO) {
            Double saldo = cliente.getSaldo();
            if (saldo == null) {
                throw new RuntimeException("Saldo não informado");
            }

            Double custoMensagem = 0.25;
            if (saldo < custoMensagem) {
                throw new RuntimeException("Saldo insuficiente");
            }

            cliente.setSaldo(saldo - custoMensagem);
            clienteRepository.save(cliente);
        } else if (planoPagamentoEnum == PlanoPagamentoEnum.POS_PAGO) {
            Double limite = cliente.getLimite();
            if (limite == null) {
                throw new RuntimeException("Limite não informado");
            }

            Double custoMensagem = 0.25;
            if (limite < custoMensagem) {
                throw new RuntimeException("Limite excedido");
            }

            cliente.setLimite(limite - custoMensagem);
            clienteRepository.save(cliente);
        }

        // Enviar mensagem
        // ...
    }
}