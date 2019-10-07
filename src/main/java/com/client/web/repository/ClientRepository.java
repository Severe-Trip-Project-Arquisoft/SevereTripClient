package com.client.web.repository;

import com.client.web.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ClientRepository extends MongoRepository<Client, Serializable> {

    Client findFirstByClientId(String clientId);

}
