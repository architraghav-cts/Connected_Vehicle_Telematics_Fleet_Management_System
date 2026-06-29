package com.example.telematics_fleet_management.service;

import com.example.telematics_fleet_management.model.Trip;
import com.example.telematics_fleet_management.repository.TripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private static final Logger logger = LoggerFactory.getLogger(TripService.class);

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips() {
        logger.info("Fetching all trips from the database");
        return tripRepository.findAll();
    }

    public long getTotalTrips() {
        logger.info("Counting total trips in the database");
        return tripRepository.count();
    }
}
