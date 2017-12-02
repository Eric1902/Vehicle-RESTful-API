package com.vehicle.dao;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.vehicle.model.Vehicle;

/**
 * @author ericfernandes
 * @created Dec 2, 2017
 */
public class VehicleDAOImpl implements VehicleDAO {

	private Map<Integer, Vehicle> vehicleDirectory = new ConcurrentHashMap<>();

	private VehicleDAOImpl() {
		vehicleDirectory.put(1, new Vehicle(1, 2017, "Honda", "Accord"));
		vehicleDirectory.put(2, new Vehicle(2, 2010, "Toyota", "Camry"));
		vehicleDirectory.put(3, new Vehicle(3, 2015, "Tesla", "Speedster"));
	}

	private static VehicleDAOImpl instance = new VehicleDAOImpl();

	synchronized static public VehicleDAOImpl getInstance() {
		return instance;
	}

	@Override
	public Collection<Vehicle> getAllVehicles() {
		return vehicleDirectory.values();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		if (vehicleDirectory.containsKey(id))
			return vehicleDirectory.get(id);
		return null;
	}

	@Override
	public void addVehicle(Vehicle vehicle) {
		vehicleDirectory.put(vehicle.getId(), vehicle);
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		addVehicle(vehicle);
	}

	@Override
	public void deleteVehicle(int id) {
		if (vehicleDirectory.containsKey(id))
			vehicleDirectory.remove(id);
	}

}
