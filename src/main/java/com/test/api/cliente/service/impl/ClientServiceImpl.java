package com.test.api.cliente.service.impl;

import com.test.api.cliente.entity.Client;
import com.test.api.cliente.repository.ClientRepository;
import com.test.api.cliente.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity deleteClient(Long clientId){

        clientRepository.deleteById(clientId);
        return ResponseEntity.ok().build();
    };
}
