package com.example.telematics_fleet_management.utils;

import com.example.telematics_fleet_management.model.Vehicle;
import com.example.telematics_fleet_management.model.enums.VehicleStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DummyVehicleGenerator {
    private static final Logger logger = LoggerFactory.getLogger(DummyVehicleGenerator.class);
    public List<Vehicle> generateVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle(
                "VIN1234567890",
                12345,
                "Sedan",
                "ABC123",
                VehicleStatus.ACTIVE
        ));

        logger.info("Generated dummy vehicles");
        return vehicles;
    }