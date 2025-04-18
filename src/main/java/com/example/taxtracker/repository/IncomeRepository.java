package com.example.taxtracker.repository;

import com.example.taxtracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

// --- IncomeRepository.java ---
public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUserId(Long userId);
}
