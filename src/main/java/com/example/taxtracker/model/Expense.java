package com.example.taxtracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private double amount;

    private LocalDate date;

    // Optional: link to a user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense() {
    }

    public Expense(String category, double amount, LocalDate date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // Full constructor with user
    public Expense(String category, double amount, LocalDate date, User user) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.user = user;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

