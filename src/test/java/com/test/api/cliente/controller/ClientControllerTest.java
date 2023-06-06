package com.test.api.cliente.controller;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.api.cliente.entity.Client;
import com.test.api.cliente.repository.ClientRepository;
import com.test.api.cliente.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;


    @Test
    void testFindAll() throws Exception {
        Client client = new Client(null,"teste","email","12039123");
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);
        when(clientRepository.findAll()).thenReturn(clientList);

        mockMvc.perform(get("/client")
                .content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(clientList)));

    }
}
