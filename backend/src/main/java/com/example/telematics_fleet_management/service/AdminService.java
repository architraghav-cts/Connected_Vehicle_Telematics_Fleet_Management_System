package com.example.telematics_fleet_management.service;

import com.example.telematics_fleet_management.model.User;
import com.example.telematics_fleet_management.repository.TripRepository;
import com.example.telematics_fleet_management.repository.UserRepository;
import com.example.telematics_fleet_management.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
    private final TripRepository tripRepository;

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    public AdminService(UserRepository userRepository, VehicleRepository vehicleRepository, TripRepository tripRepository) {
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
        this.tripRepository = tripRepository;
    }

    public List<User> getAllUsers() {
        logger.info("Fetching all users from the database");
        return userRepository.findAll();
    }

    public long getTotalUsers() {
        logger.info("Counting total users in the database");
        return userRepository.count();
    }

    public long getTotalVehicles() {
        logger.info("Counting total vehicles in the database");
        return vehicleRepository.count();
    }

    public long getTotalTrips() {
        logger.info("Counting total trips in the database");
        return tripRepository.count();
    }
}
