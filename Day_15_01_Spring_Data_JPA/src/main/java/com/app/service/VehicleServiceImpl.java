package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dao.VehicleDao;
import com.app.pojos.User;
import com.app.pojos.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDao vehicleRepo;

	private List<Vehicle> vehicles;

	@Override
	public void addVehicle(Vehicle vehicle) {
		vehicleRepo.save(vehicle);

	}

	@Override
	public Vehicle findVehicle(Long vid) {
		return vehicleRepo.findByVid(vid)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! ,Vehicle not found!!!!"));
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		vehicleRepo.save(vehicle);
	}

	@Override
	public void deleteVehicle(Long vid) {
		Vehicle vehicle = vehicleRepo.findByVid(vid)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! ,Vehicle not found!!!!"));
		vehicleRepo.delete(vehicle);
	}

}
