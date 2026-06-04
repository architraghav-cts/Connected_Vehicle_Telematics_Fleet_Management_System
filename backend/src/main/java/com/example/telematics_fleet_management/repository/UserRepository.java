package com.example.telematics_fleet_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.telematics_fleet_management.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
