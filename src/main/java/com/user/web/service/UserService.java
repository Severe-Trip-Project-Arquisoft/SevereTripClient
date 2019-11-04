package com.user.web.service;

import com.user.web.entity.User;
import com.user.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(String userId){
        return userRepository.getById(userId);
    }

    public User getUserByUsername(String userId){
        return userRepository.findFirstByUsername(userId);
    }

    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    public void updateUser(User upUser){
        userRepository.save(upUser);
    }

    public void deleteUser(User delUser){
        userRepository.delete(delUser);
    }

    public boolean isAvailable(String username){
        return !userRepository.existsByUsername(username);
    }

    public String deleteAll() {
        userRepository.deleteAll();
        return "DB cleared.";
    }
}