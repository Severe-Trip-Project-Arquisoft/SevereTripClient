package com.user.web.config;

import com.user.web.entity.User;
import com.user.web.entity.auxiliar.UserResponse;
import com.user.web.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
        User admin = new User("admin",
                "daniel",
                "pinzon",
                "daapinzonchunal.edu.co",
                "calle falsa #123",
                "bogota",
                "colombia",
                "3014016265",
                "ADMIN",
                "admin") {
            @Override
            public UserResponse response() {
                return null;
            }
        };

        List<User> users = Arrays.asList(admin);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
