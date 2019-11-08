package com.user.web.config;

import com.user.web.entity.Client;
import com.user.web.entity.User;
import com.user.web.entity.auxiliar.ClientRequest;
import com.user.web.entity.auxiliar.UserResponse;
import com.user.web.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class DBInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DBInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();
        List<User> users = new ArrayList<>();
        // Crete users
        users.add(new Client("client",
                "Nicolai",
                "Romero",
                "anromerom@unal.edu.co",
                "Calle falsa 123",
                "Bogotá D.C.",
                "Colombia",
                "31231233252",
                "client",
                passwordEncoder.encode("123"),
                "El dorado",
                "DC",
                "1112132",
                new HashSet<>()
        ));
        // Save to db
        this.userRepository.saveAll(users);
    }
}
