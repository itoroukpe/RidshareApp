package com.example.taxtracker.service;
import org.springframework.beans.factory.annotation.Autowired; // 👈 Add this
import org.springframework.stereotype.Service;

import com.example.taxtracker.repository.UserRepository; // Example of another import

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// --- AuthService.java ---
@Service
public class AuthService {
    @Autowired private UserRepository userRepository;

    public User register(User user) {
        // password hashing, mfa flag logic here
        return userRepository.save(user);
    }

    public Optional<User> login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password)); // hash check in real app
    }
}



    // Other service logic...
}
