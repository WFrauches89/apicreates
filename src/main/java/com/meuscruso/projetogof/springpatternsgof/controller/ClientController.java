package com.meuscruso.projetogof.springpatternsgof.controller;


import com.meuscruso.projetogof.springpatternsgof.model.Client;
import com.meuscruso.projetogof.springpatternsgof.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> buscarTodos() {
        return ResponseEntity.ok(clientService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Client> inserir(@RequestBody Client cliente) {
        clientService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> atualizar(@PathVariable Long id, @RequestBody Client cliente) {
        clientService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clientService.deletar(id);
        return ResponseEntity.ok().build();
    }


}
