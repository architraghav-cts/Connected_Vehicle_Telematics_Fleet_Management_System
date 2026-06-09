package com.example.telematics_fleet_management.utils;

import com.example.telematics_fleet_management.model.DriverScore;
import com.example.telematics_fleet_management.model.User;
import com.example.telematics_fleet_management.model.Vehicle;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class DummyDriverScoreGenerator {

    private final Random random = new Random();

    public DriverScore generate(User driver, Vehicle vehicle) {

        DriverScore score = new DriverScore();

        score.setDriver(driver);

        score.setVehicle(vehicle);

        score.setScoringDate(

                LocalDate.now()

                        .minusDays(random.nextInt(30))

        );

        int harshEventCount = random.nextInt(6); //

        int overspeedCount = random.nextInt(8);

        score.setHarshEventCount(

                harshEventCount

        );

        score.setOverspeedCount(

                overspeedCount

        );

        double safetyScore = 100.0;

        safetyScore -= harshEventCount * 8;

        safetyScore -= overspeedCount * 5;

        if (safetyScore < 0) {

            safetyScore = 0;

        }

        score.setSafetyScore(

                Math.round(safetyScore * 100.0) / 100.0

        );

        return score;

    }

}

