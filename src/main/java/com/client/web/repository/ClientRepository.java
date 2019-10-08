package com.client.web.repository;

import com.client.web.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {

    Client findFirstByClientId(String clientId);
}
