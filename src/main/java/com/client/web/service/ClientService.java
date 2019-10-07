package com.client.web.service;

import com.client.web.entity.Client;
import com.client.web.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClient(String clientId){ return clientRepository.findFirstBy(clientId); }
    public Client createClient(Client newClient){

        return clientRepository.save(newClient);
    }

    public Client updateClient(Client upClient){
        return clientRepository.save(upClient);
    }

}