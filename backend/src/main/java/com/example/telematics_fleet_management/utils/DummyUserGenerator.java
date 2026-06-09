package com.example.telematics_fleet_management.utils;

import com.example.telematics_fleet_management.model.DriverScore;
import com.example.telematics_fleet_management.model.User;
import org.springframework.stereotype.Component;

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
                DriverScore.ADMIN
        ));

        users.add(new User(
                "Fleet Manager",
                "fleet@gmail.com",
                "fleet123",
                DriverScore.FLEET_MANAGER
        ));

        users.add(new User(
                "Driver One",
                "driver@gmail.com",
                "driver123",
                DriverScore.DRIVER
        ));

        users.add(new User(
                "Safety Officer",
                "safety@gmail.com",
                "safety123",
                DriverScore.SAFETY_OFFICER
        ));

        users.add(new User(
                "Service Engineer",
                "service@gmail.com",
                "service123",
                DriverScore.SERVICE_ENGINEER
        ));

        users.add(new User(
                "Operations Analyst",
                "analyst@gmail.com",
                "analyst123",
                DriverScore.OPERATIONS_ANALYST
        ));

        return users;
    }
}