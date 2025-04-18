package com.example.taxtracker.repository;

import com.example.taxtracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

// --- ExpenseRepository.java ---
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(Long userId);
}
