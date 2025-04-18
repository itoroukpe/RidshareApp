package com.rondus.taxtracker.service;

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
