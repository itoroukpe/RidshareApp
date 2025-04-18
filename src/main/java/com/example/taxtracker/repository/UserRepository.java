package com.example.taxtracker.repository;

import com.example.taxtracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// --- UserRepository.java ---
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
