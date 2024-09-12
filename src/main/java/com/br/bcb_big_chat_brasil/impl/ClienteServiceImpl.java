package com.br.bcb_big_chat_brasil.impl;

import com.br.bcb_big_chat_brasil.entity.Cliente;
import com.br.bcb_big_chat_brasil.repository.ClienteRepository;
import com.br.bcb_big_chat_brasil.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void createCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }
}
