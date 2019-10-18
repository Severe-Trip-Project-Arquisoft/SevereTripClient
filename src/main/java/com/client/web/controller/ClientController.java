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

import java.util.List;

@Api(value="Clients Management System", description="Operations pertaining to customer in Clients Management System")
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

    @ApiOperation(value = "See all clients",response = List.class)
    @GetMapping("/allClients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @ApiOperation(value = "Get client by internal Id",response = Client.class)
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable(value = "id") String id){
        Client cli = clientService.getClient(id);
        if (cli!= null){
            return ResponseEntity.ok(cli);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Insert client",response = String.class)
    @PostMapping(path ="/insertClient", consumes = "application/json")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
            Client cli = clientService.getClientByCustId(client.getClientId());
            if (cli==null){
                Client created = clientService.createClient(client);
                return new ResponseEntity<>(created.getId(),HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

    @ApiOperation(value = "Update client by internal Id")
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

    @ApiOperation(value = "Delete client by internal Id")
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
