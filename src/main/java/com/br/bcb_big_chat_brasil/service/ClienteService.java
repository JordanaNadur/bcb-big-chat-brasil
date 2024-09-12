package com.br.bcb_big_chat_brasil.service;

import com.br.bcb_big_chat_brasil.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> getAllClientes();

    Cliente getClienteById(int id);

    void createCliente(Cliente cliente);

    void updateCliente(Cliente cliente);

    void deleteCliente(int id);

}
