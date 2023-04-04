package com.dronefeeder.dronefeeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dronefeeder.dronefeeder.model.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {};