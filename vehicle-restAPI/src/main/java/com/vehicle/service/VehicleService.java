package com.vehicle.service;

import java.util.Collection;

import com.vehicle.dao.VehicleDAOImpl;
import com.vehicle.model.Vehicle;

/**
 * @author ericfernandes
 * @created Dec 2, 2017
 */
public class VehicleService {

	private VehicleDAOImpl directory = VehicleDAOImpl.getInstance();
	
	private VehicleService() {
	}

	private static VehicleService instance = null;

	synchronized static public VehicleService getInstance() {
		if (instance == null)
			instance = new VehicleService();
		return instance;
	}

	public Collection<Vehicle> getAllVehicles() {
		return directory.getAllVehicles();
	}

	public Vehicle getVehicleById(int id) {
		return directory.getVehicleById(id);
	}

	public void addVehicle(Vehicle vehicle) {
		directory.addVehicle(vehicle);
	}

	public void updateVehicle(Vehicle vehicle) {
		addVehicle(vehicle);
	}

	public void deleteVehicle(int id) {
		directory.deleteVehicle(id);
	}

}
