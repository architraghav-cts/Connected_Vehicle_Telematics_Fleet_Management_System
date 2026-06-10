package com.example.telematics_fleet_management.utils;


import com.example.telematics_fleet_management.model.ServiceRecord;
import com.example.telematics_fleet_management.model.Vehicle;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class DummyServiceRecordGenerator {
    private final Random random = new Random();
    public ServiceRecord generate(Vehicle vehicle) {

        String[] services = {
                "Engine Oil Change",
                "Brake Service",
                "Tyre Replacement",
                "Battery Replacement",
                "General Inspection"
        };

        LocalDate serviceDate =
                LocalDate.now().minusDays(random.nextInt(180));
        ServiceRecord record = new ServiceRecord();
        record.setVehicle(vehicle);
        record.setServiceDate(serviceDate);
        record.setServiceType(
                services[random.nextInt(services.length)]
        );

        record.setOdometerReading(
                10000 + random.nextInt(100000)
        );

        record.setServiceCost(
                2000.0 + random.nextInt(20000)

        );

        record.setNextServiceDueDate(

                serviceDate.plusMonths(3)

        );

        return record;

    }

}
