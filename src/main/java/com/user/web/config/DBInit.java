package com.user.web.config;

import com.user.web.entity.Client;
import com.user.web.entity.User;
import com.user.web.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        // Crete users
        List<User> users = new ArrayList<>();
        users.add(new Client("anromerom",
                "Alberto Nicolai",
                "Romero Martinez",
                "anromerom@unal.edu.co",
                "Calle falsa 123",
                "Bogotá D.C.",
                "Colombia",
                "3123123252",
                "CLIENT",
                passwordEncoder.encode("123"),
                "El Dorado",
                "DC",
                "110111"
        ));
        // Save to db
        this.userRepository.saveAll(users);
    }
}
