package com.example.telematics_fleet_management.service;

import com.example.telematics_fleet_management.model.DriverScore;
import com.example.telematics_fleet_management.model.Trip;
import com.example.telematics_fleet_management.model.User;
import com.example.telematics_fleet_management.repository.DriverScoreRepository;
import com.example.telematics_fleet_management.repository.TripRepository;
import com.example.telematics_fleet_management.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DriverService {
    private final UserRepository userRepository;
    private final TripRepository tripRepository;
    private final DriverScoreRepository driverScoreRepository;
    private static final Logger logger = LoggerFactory.getLogger(DriverService.class);

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
        logger.info("Fetching driver with ID 3 from the database");
        return userRepository.findById(3).orElse(null);
    }



    public long getTotalTrips() {

        User driver = getDriver();

        if (driver == null) {
            return 0;
        }
        logger.info("Counting total trips for driver with ID 3");
        return tripRepository.countByDriver(driver);
    }

    public double getTotalDistance() {

        User driver = getDriver();

        if (driver == null) {
            return 0;
        }

        List<Trip> trips =
                tripRepository.findByDriver(driver);

        logger.info("Calculating total distance for driver with ID 3");
        return trips.stream()
                .mapToDouble(Trip::getDistanceKm)
                .sum();
    }

    public List<Trip> getRecentTrips() {

        User driver = getDriver();

        if (driver == null) {
            return List.of();
        }
        logger.info("Fetching recent trips for driver with ID 3");
        return tripRepository.findByDriver(driver);
    }

    public List<DriverScore> getDriverScores() {

        User driver = getDriver();

        if (driver == null) {
            return List.of();
        }

        logger.info("Fetching driver scores for driver with ID 3");
        return driverScoreRepository.findByDriver(driver)
                .stream()
                .sorted(Comparator.comparingInt(DriverScore::getScoreId).reversed())
                .toList();
    }
}
