package com.br.bcb_big_chat_brasil.controller;

import com.br.bcb_big_chat_brasil.entity.Cliente;
import com.br.bcb_big_chat_brasil.entity.PlanoPagamento;
import com.br.bcb_big_chat_brasil.repository.ClienteRepository;
import com.br.bcb_big_chat_brasil.repository.PlanoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/backoffice")
public class BackofficeController {

    @Autowired
    private ClienteRepository clienteRepository;
    private PlanoPagamentoRepository planoPagamentoRepository;

    @PostMapping("/incluir-creditos")
    public ResponseEntity<String> incluirCreditos(@RequestBody IncluirCreditosRequest request) {
        Long clienteId = request.getClienteId();
        Double valor = request.getValor();

        Cliente cliente = clienteRepository.findById(Math.toIntExact(clienteId));
        cliente.setSaldo(cliente.getSaldo() + valor);
        clienteRepository.save(cliente);

        return ResponseEntity.ok("Créditos incluídos com sucesso!");
    }

    @GetMapping("/consultar-saldo")
    public ResponseEntity<Double> consultarSaldo(@RequestParam Long clienteId) {
        Cliente cliente = clienteRepository.findById(Math.toIntExact(clienteId));
        return ResponseEntity.ok(cliente.getSaldo());
    }

    @PostMapping("/alterar-limite")
    public ResponseEntity<String> alterarLimite(@RequestBody AlterarLimiteRequest request) {
        Long clienteId = request.getClienteId();
        Double novoLimite = request.getNovoLimite();

        Cliente cliente = clienteRepository.findById(Math.toIntExact(clienteId));
        cliente.setLimite(novoLimite);
        clienteRepository.save(cliente);

        return ResponseEntity.ok("Limite alterado com sucesso!");
    }

    @PostMapping("/alterar-plano")
    public ResponseEntity<String> alterarPlano(@RequestBody AlterarPlanoRequest request) {
        Long clienteId = request.getClienteId();
        Long novoPlanoId = request.getNovoPlanoId();

        Optional<Cliente> clienteOptional = Optional.ofNullable(clienteRepository.findById(Math.toIntExact(clienteId)));
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            Optional<PlanoPagamento> planoOptional = planoPagamentoRepository.findById(novoPlanoId);
            if (planoOptional.isPresent()) {
                PlanoPagamento novoPlano = planoOptional.get();
                cliente.setPlanoPagamento(novoPlano);
                clienteRepository.save(cliente);
                return ResponseEntity.ok("Plano alterado com sucesso!");
            } else {
                return ResponseEntity.badRequest().body("Plano de pagamento não encontrado");
            }
        } else {
            return ResponseEntity.badRequest().body("Cliente não encontrado");
        }
    }

    @GetMapping("/ver-dados-cliente")
    public ResponseEntity<Cliente> verDadosCliente(@RequestParam Long clienteId) {
        Cliente cliente = clienteRepository.findById(Math.toIntExact(clienteId));
        return ResponseEntity.ok(cliente);
    }

}
