package com.example.telematics_fleet_management.utils;

import com.example.telematics_fleet_management.model.FuelLog;
import com.example.telematics_fleet_management.model.Vehicle;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component

public class DummyFuelLogGenerator {

    private final Random random = new Random();

    public FuelLog generate(Vehicle vehicle) {

        double litres = 20 + random.nextInt(50);

        FuelLog fuelLog = new FuelLog();

        fuelLog.setVehicle(vehicle);

        fuelLog.setRefillDate(

                LocalDate.now().minusDays(random.nextInt(30))

        );

        fuelLog.setLitresRefilled(litres);

        fuelLog.setOdometerReading(

                10000 + random.nextInt(90000)

        );

        fuelLog.setCostAmount(

                litres * 95

        );

        return fuelLog;

    }

}
