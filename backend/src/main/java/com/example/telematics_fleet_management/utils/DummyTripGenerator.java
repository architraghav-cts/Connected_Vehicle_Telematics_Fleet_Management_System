package com.example.telematics_fleet_management.utils;

import com.example.telematics_fleet_management.model.Trip;
import com.example.telematics_fleet_management.model.User;
import com.example.telematics_fleet_management.model.Vehicle;
import com.example.telematics_fleet_management.model.enums.TripStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class DummyTripGenerator {
    private final Random random = new Random();

    public Trip generate(Vehicle vehicle, User driver) {

        LocalDateTime start =
                LocalDateTime.now()
                        .minusHours(random.nextInt(24));

        LocalDateTime end =
                start.plusHours(1 + random.nextInt(10));

        Trip trip = new Trip();

        trip.setVehicle(vehicle);
        trip.setDriver(driver);
        trip.setStartTime(start);
        trip.setEndTime(end);
        trip.setDistanceKm(
                50 + random.nextDouble() * 450
        );

        trip.setTripStatus(TripStatus.COMPLETED);
        return trip;
    }
}