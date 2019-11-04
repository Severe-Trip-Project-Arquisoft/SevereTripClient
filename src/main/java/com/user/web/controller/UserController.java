package com.user.web.controller;

import com.user.web.entity.*;
import com.user.web.entity.auxiliar.ClientRequest;
import com.user.web.entity.auxiliar.ProviderRequest;
import com.user.web.entity.auxiliar.UserResponse;
import com.user.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value="Users Management System", description="Operations pertaining to customer in Users Management System")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String msg(){
        return "ST - USERS SERVICE AVAILABLE";
    }

    @DeleteMapping
    public String clearDB() {
        return userService.deleteAll();
    }

    @ApiOperation(value = "See all users.",response = List.class)
    @GetMapping("/all")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get user by internal database ID.",response = User.class)
    @GetMapping("/{generatedId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable(value = "generatedId") String generatedId){
        User user = userService.getUser(generatedId);
        if (user!= null){
            return ResponseEntity.ok(user.response());
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "Get user by username.",response = User.class)
    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable(value = "username") String id){
        User user = userService.getUserByUsername(id);
        if (user!= null){
            return ResponseEntity.ok(user.response());
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "Get availability of username.",response = Boolean.class)
    @GetMapping("/available/{userName}")
    public ResponseEntity<Boolean> checkAvailability(@PathVariable(value = "userName") String userName){
        return ResponseEntity.ok(userService.isAvailable(userName));
    }

    @ApiOperation(value = "Create new client.",response = String.class)
    @PostMapping(path ="/insert/client", consumes = "application/json")
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientRequest newClient){
        return createUser(newClient.createClient());
    }

    @ApiOperation(value = "Create new provider.",response = String.class)
    @PostMapping(path ="/insert/provider", consumes = "application/json")
    public ResponseEntity<String> createProvider(@Valid @RequestBody ProviderRequest newProvider) {
        return createUser(newProvider.createProvider());
    }

    private ResponseEntity<String> createUser(@Valid User newUser){
        User user = userService.getUserByUsername(newUser.getUsername());
        if (user==null){
            User created = userService.createUser(newUser);
            return new ResponseEntity<>(created.getId(),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Username not Available",HttpStatus.NO_CONTENT);
        }
    }


    @ApiOperation(value = "Update client by internal ID.")
    @PutMapping(path = "/update/client/{id}")
    public ResponseEntity updateClient(@RequestBody ClientRequest upUser, @PathVariable(value = "id") String id){
        User user = userService.getUser(id);
        try{
            if (user == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            } else {
                Client cli = upUser.createClient();
                cli.setId(id);
                userService.updateUser(cli);
                return new ResponseEntity(HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @ApiOperation(value = "Update provider by internal ID.")
    @PutMapping(path = "/update/provider/{id}")
    public ResponseEntity updateProvider(@RequestBody ProviderRequest upUser, @PathVariable(value = "id") String id){
        User user = userService.getUser(id);
        try{
            if (user == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            } else {
                Provider pro =  upUser.createProvider();
                pro.setId(id);
                userService.updateUser(pro);
                return new ResponseEntity(HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "Delete user by internal ID.")
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") String id){
        User user = userService.getUser(id);
        if (user!= null){
            userService.deleteUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
