// --- File: OtpController.java ---
package com.rondus.taxtracker.controller;

import com.rondus.taxtracker.service.EmailService;
import com.rondus.taxtracker.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/otp")
public class OtpController {
    @Autowired private EmailService emailService;
    @Autowired private OtpService otpService;

    @PostMapping("/send")
    public String sendOtp(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String otp = otpService.generateOtp(email);
        emailService.sendOtp(email, otp);
        return "OTP sent to " + email;
    }

    @PostMapping("/verify")
    public boolean verifyOtp(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String otp = body.get("otp");
        return otpService.verifyOtp(email, otp);
    }
}
