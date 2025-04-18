import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


// --- File: EmailService.java ---
package com.rondus.taxtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired private JavaMailSender mailSender;

    public void sendOtp(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your OTP Code");
        message.setText("Use this code to complete your login: " + otp);
        mailSender.send(message);
    }
}
