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
        users.add(new Client(
                "client",
                "Nicolai",
                "Romero",
                "nicolaiKaiba@gmail.com",
                "cll 1 sur No.4 -57",
                "Bogota",
                "Colombia",
                "3112009876",
                "CLIENT",
                passwordEncoder.encode("123"),
                "Aeropuerto internacional Jonathan Brando",
                "Cundinamarca",
                "11001",
                new HashSet<>()
        ));
        // Save to db
        this.userRepository.saveAll(users);
    }
}
