package com.test.api.cliente.service;

import com.test.api.cliente.entity.Client;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {


    ResponseEntity deleteClient(Long client);
}
