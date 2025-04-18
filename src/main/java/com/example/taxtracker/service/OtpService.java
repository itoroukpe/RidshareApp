// --- File: OtpService.java ---
package com.rondus.taxtracker.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class OtpService {
    private final Map<String, String> otpStorage = new HashMap<>();

    public String generateOtp(String email) {
        String otp = String.valueOf(100000 + new Random().nextInt(900000));
        otpStorage.put(email, otp);
        return otp;
    }

    public boolean verifyOtp(String email, String inputOtp) {
        String storedOtp = otpStorage.get(email);
        return storedOtp != null && storedOtp.equals(inputOtp);
    }
}
