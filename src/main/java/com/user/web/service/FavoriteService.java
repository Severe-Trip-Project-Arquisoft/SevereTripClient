package com.user.web.service;

import com.user.web.entity.Client;
import com.user.web.entity.User;
import com.user.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;



@Service
public class FavoriteService {

    private final UserRepository userRepository;
    @Autowired public FavoriteService(UserRepository userRepository) { this.userRepository = userRepository; }


    public boolean addFavorite(String clientId, String postId){
        User c = userRepository.getById(clientId);
        if(!c.getRole().equals("client") && !(c instanceof Client)) return false;
        Client client = (Client) c;
        boolean changed = client.addFavorite(postId);
        if(changed) userRepository.save(client);
        return changed;
    }

    public boolean removeFavorite(String clientId, String postId){
        User c = userRepository.getById(clientId);
        if(!c.getRole().equals("client") && !(c instanceof Client)) return false;
        Client client = (Client) c;
        boolean changed = client.removeFavorite(postId);
        if(changed) userRepository.save(client);
        return changed;
    }

    public HashSet<String> getFavorites(String clientId){

        User c = userRepository.getById(clientId);
        if(!c.getRole().equals("client") && !(c instanceof Client)) return new HashSet<>();
        Client client = (Client) c;
        return client.getFavorites();
    }



}
