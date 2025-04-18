package com.example.taxtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        model.addAttribute("userEmail", session.getAttribute("userEmail"));
        model.addAttribute("premium", session.getAttribute("premium"));
        return "dashboard";
    }
}

