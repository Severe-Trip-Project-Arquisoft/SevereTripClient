package com.user.web.service;

import com.user.web.entity.User;
import com.user.web.repository.UserRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findFirstByUsername(s);
        Collection<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(  user.getUsername(),   user.getPassword(), authorities );
    }

}