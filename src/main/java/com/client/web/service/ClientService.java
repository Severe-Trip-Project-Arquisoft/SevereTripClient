package com.client.web.service;

import com.client.web.entity.Client;
import com.client.web.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClient(String clientId){

        return clientRepository.getById(clientId);
    }

    public Client getClientByCustId(String clientId){

        return clientRepository.findFirstByClientId(clientId);
    }

    public Client createClient(Client newClient){

        return clientRepository.save(newClient);
    }

    public Client updateClient(Client upClient){

        return clientRepository.save(upClient);
    }

    public void deleteClient(Client delClient){

        clientRepository.delete(delClient);
    }

    public boolean isAvailable(String userName){
        return !clientRepository.existsByClientId(userName);
    }
}