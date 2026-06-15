package com.example.telematics_fleet_management.controller;


import com.example.telematics_fleet_management.model.User;
import com.example.telematics_fleet_management.service.AuthService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {

        this.authService = authService;

    }

    @GetMapping("/")

    public String showLoginPage() {

        return "login";

    }
    @PostMapping("/login")

    public String login(@RequestParam String email, @RequestParam String password, Model model) {

        User user = authService.validateUser(email, password);

        if (user == null) {

            model.addAttribute("error", "Invalid Email or Password");

            return "login";

        }

        switch (user.getRole()) {

            case ADMIN:

                return "redirect:/admin/dashboard";

            case FLEET_MANAGER:

                return "redirect:/fleet/dashboard";

            case DRIVER:

                return "redirect:/driver/dashboard";

            case SERVICE_ENGINEER:

                return "redirect:/service/dashboard";

            case SAFETY_OFFICER:

                return "redirect:/safety/dashboard";

            case OPERATIONS_ANALYST:

                return "redirect:/analyst/dashboard";

            default:

                return "redirect:/";

        }

    }

}
