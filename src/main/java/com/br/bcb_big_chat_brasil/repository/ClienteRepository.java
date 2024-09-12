package com.br.bcb_big_chat_brasil.repository;

import com.br.bcb_big_chat_brasil.entity.Cliente;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Cliente> findAll() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    public Cliente findById(int id) {
        return entityManager.find(Cliente.class, id);
    }

    public void save(Cliente cliente) {
        entityManager.persist(cliente);
    }

    public void update(Cliente cliente) {
        entityManager.merge(cliente);
    }

    public void deleteById(int id) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }
}
