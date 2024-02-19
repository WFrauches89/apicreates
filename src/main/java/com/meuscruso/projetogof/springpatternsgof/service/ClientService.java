package com.meuscruso.projetogof.springpatternsgof.service;

import com.meuscruso.projetogof.springpatternsgof.model.Client;

public interface ClientService {

    Iterable<Client> buscarTodos();

    Client buscarPorId(Long id);

    void inserir(Client client);

    void atualizar(Long id, Client client);

    void deletar(Long id);
}
