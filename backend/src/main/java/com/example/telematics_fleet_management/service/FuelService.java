package com.example.telematics_fleet_management.service;

import com.example.telematics_fleet_management.model.FuelLog;
import com.example.telematics_fleet_management.repository.FuelLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelService {

    private final FuelLogRepository fuelLogRepository;
    private static final Logger logger = LoggerFactory.getLogger(FuelService.class);

    public FuelService(FuelLogRepository fuelLogRepository) {
        this.fuelLogRepository = fuelLogRepository;
    }

    public List<FuelLog> getAllFuelLogs() {
        logger.info("Fetching all fuel logs from the database");
        return fuelLogRepository.findAll();
    }

    public long getTotalFuelLogs() {
        logger.info("Counting total fuel logs in the database");
        return fuelLogRepository.count();
    }

    public double getTotalFuelConsumed() {
        logger.info("Calculating total fuel consumed from all fuel logs");
        return fuelLogRepository.findAll()
                .stream()
                .mapToDouble(FuelLog::getLitresRefilled)
                .sum();
    }

    public double getTotalFuelCost() {
        logger.info("Calculating total fuel cost from all fuel logs");
        return fuelLogRepository.findAll()
                .stream()
                .mapToDouble(FuelLog::getCostAmount)
                .sum();
    }

    public double getAverageRefillAmount() {

        List<FuelLog> logs = fuelLogRepository.findAll();

        if (logs.isEmpty()) {
            return 0;
        }
        logger.info("Calculating average refill amount from all fuel logs");
        return logs.stream()
                .mapToDouble(FuelLog::getLitresRefilled)
                .average()
                .orElse(0);
    }
}