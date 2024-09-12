package com.br.bcb_big_chat_brasil.service;

import com.br.bcb_big_chat_brasil.entity.PlanoPagamento;
import com.br.bcb_big_chat_brasil.repository.PlanoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoPagamentoService {

    @Autowired
    private PlanoPagamentoRepository planoPagamentoRepository;

    public PlanoPagamento findById(Long id) {
        Optional<PlanoPagamento> planoOptional = planoPagamentoRepository.findById(id);
        return planoOptional.orElseThrow(() -> new RuntimeException("Plano de pagamento não encontrado"));
    }

    public List<PlanoPagamento> findAll() {
        return planoPagamentoRepository.findAll();
    }

    public PlanoPagamento save(PlanoPagamento planoPagamento) {
        return planoPagamentoRepository.save(planoPagamento);
    }

    public void delete(Long id) {
        planoPagamentoRepository.deleteById(id);
    }
}
