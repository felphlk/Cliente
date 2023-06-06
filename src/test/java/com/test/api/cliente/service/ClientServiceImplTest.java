package com.test.api.cliente.service;

import com.test.api.cliente.repository.ClientRepository;
import com.test.api.cliente.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {

    @InjectMocks
    ClientServiceImpl clientService;

    @Mock
    ClientRepository clientRepository;

    @Test
    public void testDeleteClient(){

        doNothing().when(clientRepository).deleteById(anyLong());
        ResponseEntity responseEntity = clientService.deleteClient(anyLong());

        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);


    }
}
