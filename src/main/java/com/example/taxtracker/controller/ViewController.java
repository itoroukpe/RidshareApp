import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


// --- ViewController.java ---
package com.rondus.taxtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/verify-otp")
    public String showOtpPage() {
        return "otp-verify";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/fleet-dashboard")
    public String showFleetDashboard() {
    return "fleet-dashboard";
}
}



