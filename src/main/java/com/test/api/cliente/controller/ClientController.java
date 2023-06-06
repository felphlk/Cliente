package com.test.api.cliente.controller;

import com.test.api.cliente.entity.Client;
import com.test.api.cliente.repository.ClientRepository;
import com.test.api.cliente.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @PostMapping()
    public ResponseEntity<Client> saveClients(@RequestBody Client client){
        log.info(client.toString());
        Client clientSaved = clientRepository.save(client);
        return ResponseEntity.ok(clientSaved);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId){
        log.info(clientId.toString());
        return clientService.deleteClient(clientId);
    }

}
