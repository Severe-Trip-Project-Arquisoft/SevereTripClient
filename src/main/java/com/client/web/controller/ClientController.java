package com.client.web.controller;

import com.client.web.entity.Client;
import com.client.web.repository.ClientRepository;
import com.client.web.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value="Clients Management System", description="Operations pertaining to customer in Clients Management System")
@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
    private ClientRepository clientRepository;

    @GetMapping
    public String msg(){

        return "CLIENTS AVAILABLE";
    }

    @ApiOperation(value = "View a client")
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable(value = "id") String id){
        Client cli = clientService.getClient(id);
        if (cli!= null){
            return ResponseEntity.ok(cli);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path ="/insertClient", consumes = "application/json")
    public ResponseEntity<Long> createClient(@RequestBody Client client) {
            Client cli = clientService.getClient(client.getClientId());
            if (cli==null){
                clientService.createClient(client);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

    @PutMapping(path = "/updateClient/{id}")
    public void updateClient(@RequestBody Client client, @PathVariable(value = "id") String id){
        Client cli = clientService.getClient(id);
        if (cli!= null){
            clientService.deleteClient(cli);
            clientService.createClient(client);
        }else{
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/deleteClient/{id}")
    public void deleteClient(@PathVariable(value = "id") String id){
        Client cli = clientService.getClient(id);
        if (cli!= null){
            clientService.deleteClient(cli);
        }else{
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
