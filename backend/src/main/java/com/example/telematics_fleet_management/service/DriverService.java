package com.example.telematics_fleet_management.service;

import com.example.telematics_fleet_management.model.DriverScore;
import com.example.telematics_fleet_management.model.Trip;
import com.example.telematics_fleet_management.model.User;
import com.example.telematics_fleet_management.repository.DriverScoreRepository;
import com.example.telematics_fleet_management.repository.TripRepository;
import com.example.telematics_fleet_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final UserRepository userRepository;
    private final TripRepository tripRepository;
    private final DriverScoreRepository driverScoreRepository;

    public DriverService(
            UserRepository userRepository,
            TripRepository tripRepository,
            DriverScoreRepository driverScoreRepository) {

        this.userRepository = userRepository;
        this.tripRepository = tripRepository;
        this.driverScoreRepository = driverScoreRepository;
    }

    // Since only one driver exists in the system
    public User getDriver() {
        return userRepository.findById(3).orElse(null);
    }



    public long getTotalTrips() {

        User driver = getDriver();

        if (driver == null) {
            return 0;
        }

        return tripRepository.countByDriver(driver);
    }

    public double getTotalDistance() {

        User driver = getDriver();

        if (driver == null) {
            return 0;
        }

        List<Trip> trips =
                tripRepository.findByDriver(driver);

        return trips.stream()
                .mapToDouble(Trip::getDistanceKm)
                .sum();
    }

    public List<Trip> getRecentTrips() {

        User driver = getDriver();

        if (driver == null) {
            return List.of();
        }

        return tripRepository.findByDriver(driver);
    }

    public List<DriverScore> getDriverScores() {

        User driver = getDriver();

        if (driver == null) {
            return List.of();
        }

        return driverScoreRepository.findByDriver(driver);
    }
}
