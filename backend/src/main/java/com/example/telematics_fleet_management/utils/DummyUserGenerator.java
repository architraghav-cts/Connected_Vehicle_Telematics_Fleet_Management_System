package com.example.telematics_fleet_management.utils;
import com.example.telematics_fleet_management.model.User;
import org.springframework.stereotype.Component;
import com.example.telematics_fleet_management.model.enums.Role;

import java.util.ArrayList;
import java.util.List;

@Component
public class DummyUserGenerator {
    public List<User> generateUsers() {

        List<User> users = new ArrayList<>();

        users.add(new User(
                "Admin User",
                "admin@gmail.com",
                "admin123",
                Role.ADMIN
        ));

        users.add(new User(
                "Fleet Manager",
                "fleet@gmail.com",
                "fleet123",
                Role.FLEET_MANAGER
        ));

        users.add(new User(
                "Driver One",
                "driver@gmail.com",
                "driver123",
                Role.DRIVER
        ));

        users.add(new User(
                "Safety Officer",
                "safety@gmail.com",
                "safety123",
                Role.SAFETY_OFFICER
        ));

        users.add(new User(
                "Service Engineer",
                "service@gmail.com",
                "service123",
                Role.SERVICE_ENGINEER
        ));

        users.add(new User(
                "Operations Analyst",
                "analyst@gmail.com",
                "analyst123",
                Role.OPERATIONS_ANALYST
        ));

        return users;
    }
}