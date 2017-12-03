package com.vehicle.service;

import java.util.Collection;

import com.vehicle.dao.VehicleDAOImpl;
import com.vehicle.model.Vehicle;

/**
 * @author ericfernandes
 * @created Dec 2, 2017
 */
public class VehicleService {

	private VehicleDAOImpl dao = VehicleDAOImpl.getInstance();
	
	private VehicleService() {
	}

	private static VehicleService instance = null;

	synchronized static public VehicleService getInstance() {
		if (instance == null)
			instance = new VehicleService();
		return instance;
	}

	public Collection<Vehicle> getAllVehicles() {
		return dao.getAllVehicles();
	}

	public Vehicle getVehicleById(int id) {
		return dao.getVehicleById(id);
	}

	public void addVehicle(Vehicle vehicle) throws Exception {
		dao.addVehicle(vehicle);
	}

	public void updateVehicle(Vehicle vehicle) {
		dao.updateVehicle(vehicle);
	}

	public void deleteVehicle(int id) {
		dao.deleteVehicle(id);
	}

}
