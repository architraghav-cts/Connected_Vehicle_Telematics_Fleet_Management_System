package com.example.telematics_fleet_management.service;

import com.example.telematics_fleet_management.model.DriverScore;
import com.example.telematics_fleet_management.repository.DriverScoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafetyService {

    private final DriverScoreRepository driverScoreRepository;
    private static final Logger logger = LoggerFactory.getLogger(SafetyService.class);

    public SafetyService(DriverScoreRepository driverScoreRepository) {
        this.driverScoreRepository = driverScoreRepository;
    }

    public List<DriverScore> getAllDriverScores() {
        logger.info("Fetching all driver scores from the database");
        return driverScoreRepository.findAll();
    }

    public long getTotalSafetyReports() {
        logger.info("Counting total safety reports in the database");
        return driverScoreRepository.count();
    }

    public double getAverageSafetyScore() {

        List<DriverScore> scores =
                driverScoreRepository.findAll();

        logger.info("Calculating average safety score from all driver scores");
        if (scores.isEmpty()) {
            return 0;
        }

        return scores.stream()
                .mapToDouble(DriverScore::getSafetyScore)
                .average()
                .orElse(0);
    }

    public int getTotalOverspeedEvents() {
        logger.info("Calculating total overspeed events from all driver scores");
        return driverScoreRepository.findAll()
                .stream()
                .mapToInt(DriverScore::getOverspeedCount)
                .sum();
    }

    public int getTotalHarshEvents() {
        logger.info("Calculating total harsh events from all driver scores");
        return driverScoreRepository.findAll()
                .stream()
                .mapToInt(DriverScore::getHarshEventCount)
                .sum();
    }
}
