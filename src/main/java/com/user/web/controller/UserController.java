package com.user.web.controller;

import com.user.web.entity.Client;
import com.user.web.entity.Provider;
import com.user.web.entity.User;
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

    @Autowired
    private UserService userService;

    @GetMapping
    public String msg(){
        return "ST - USERS SERVICE AVAILABLE";
    }

    @ApiOperation(value = "See all users.",response = List.class)
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Get user by internal database ID.",response = User.class)
    @GetMapping("/{generatedId}")
    public ResponseEntity<User> getUser(@PathVariable(value = "generatedId") String generatedId){
        User user = userService.getUser(generatedId);
        if (user!= null){
            return ResponseEntity.ok(user);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "Get user by username.",response = User.class)
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(value = "username") String id){
        User user = userService.getUserByUsername(id);
        if (user!= null){
            return ResponseEntity.ok(user);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "Get availability of username.",response = Boolean.class)
    @GetMapping("/available/{userName}")
    public ResponseEntity<Boolean> checkAvailability(@PathVariable(value = "userName") String userName){
        return ResponseEntity.ok(userService.isAvailable(userName));
    }

    @ApiOperation(value = "Create new client",response = String.class)
    @PostMapping(path ="/insert/client", consumes = "application/json")
    public ResponseEntity<String> createClient(@Valid @RequestBody Client newClient){
        return createUser(newClient);
    }

    @ApiOperation(value = "Create new provider",response = String.class)
    @PostMapping(path ="/insert/provider", consumes = "application/json")
    public ResponseEntity<String> createProvider(@Valid @RequestBody Provider newProvider) {
        return createUser(newProvider);
    }

    private ResponseEntity<String> createUser(@Valid User newUser){
        User user = userService.getUserByUsername(newUser.getUsername());
        if (user==null){
            User created = userService.createUser(newUser);
            return new ResponseEntity<>(created.getId(),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Username not Available",HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "Update user by internal ID")
    @PutMapping(path = "/update/{id}")
    public void updateUser(@RequestBody @Valid User upUser, @PathVariable(value = "id") String id){
        User user = userService.getUser(id);
        if (user!= null){
            userService.updateUser(upUser);
        }else{
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "Delete user by internal ID")
    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable(value = "id") String id){
        User user = userService.getUser(id);
        if (user!= null){
            userService.deleteUser(user);
        }else{
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
