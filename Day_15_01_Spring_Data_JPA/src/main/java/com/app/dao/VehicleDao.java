package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Long> {
	Optional<Vehicle> findByVid(Long id);
}
