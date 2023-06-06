package com.test.api.cliente.repository;

import com.test.api.cliente.entity.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void createPlanet_WithValidData_ReturnsPlanet() {
        Client client = new Client(null,"teste","email","12039123");
        Client planet = clientRepository.save(client);

        Client sut = testEntityManager.find(Client.class, planet.getId());

        Assertions.assertEquals(client.getName(),sut.getName());
    }

    @Test
    public void deleteClient() {
        Client client = new Client(null,"teste","email","12039123");
        Client planet = clientRepository.save(client);
        //testEntityManager.detach(planet);
        clientRepository.deleteById(planet.getId());
        Client sut = testEntityManager.find(Client.class, planet.getId());

        Assertions.assertNull(sut);
    }
}
