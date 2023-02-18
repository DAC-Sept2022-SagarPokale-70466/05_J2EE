package com.app.service;

import com.app.pojos.Vehicle;

public interface VehicleService {

	void addVehicle(Vehicle vehicle);

	Vehicle findVehicle(Long vid);

	void updateVehicle(Vehicle vehicle);

	void deleteVehicle(Long vid);

}
