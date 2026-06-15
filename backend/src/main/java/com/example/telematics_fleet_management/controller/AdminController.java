package com.example.telematics_fleet_management.controller;

import com.example.telematics_fleet_management.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("totalUsers",
                adminService.getTotalUsers());

        return "admin/dashboard";
    }

    @GetMapping("/admin/users")
    public String users(Model model) {

        List<User> users = adminService.getAllUsers();

        model.addAttribute("users", users);

        return "admin/user";
    }
}