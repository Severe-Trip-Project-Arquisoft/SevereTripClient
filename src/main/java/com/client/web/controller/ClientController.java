package com.client.web.controller;

import com.client.web.entity.Client;
import com.client.web.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String msg(){
        return "CLIENTS AVAILABLE";
    }
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

    @PutMapping(path ="/insertClient", consumes = "application/json")
    public ResponseEntity<Long> updateClient(@RequestBody Client client) {
        Client cli = clientService.getClient(client.getClientId() );
        if (!cli.equals(null) && cli.getId()== client.getId()){
            clientService.updateClient(client);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
