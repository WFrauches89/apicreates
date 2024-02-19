package com.meuscruso.projetogof.springpatternsgof.service.implement;

import com.meuscruso.projetogof.springpatternsgof.model.Client;
import com.meuscruso.projetogof.springpatternsgof.model.Endereco;
import com.meuscruso.projetogof.springpatternsgof.repository.ClienteRepository;
import com.meuscruso.projetogof.springpatternsgof.repository.EnderecoRepository;
import com.meuscruso.projetogof.springpatternsgof.service.ClientService;
import com.meuscruso.projetogof.springpatternsgof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientServiceImplement implements ClientService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Client> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Client buscarPorId(Long id) {
        Optional<Client> cliente = clienteRepository.findById(id);
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + id));
    }
    private void salvarClienteComCep(Client cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
    @Override
    public void inserir(Client client) {
        salvarClienteComCep(client);
    }

    @Override
    public void atualizar(Long id, Client client) {
        Optional<Client> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(client);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
