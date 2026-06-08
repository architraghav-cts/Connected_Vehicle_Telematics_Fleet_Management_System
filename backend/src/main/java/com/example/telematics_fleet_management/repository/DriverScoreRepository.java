package com.example.telematics_fleet_management.repository;

import com.example.telematics_fleet_management.model.DriverScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverScoreRepository extends JpaRepository<DriverScore,Integer> {
}
