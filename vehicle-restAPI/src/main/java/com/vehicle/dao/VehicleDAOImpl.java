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

	private Map<Integer, Vehicle> directory = new ConcurrentHashMap<>();

	private VehicleDAOImpl() {
		directory.put(1, new Vehicle(1, 2017, "Honda", "Accord"));
		directory.put(2, new Vehicle(2, 2017, "Toyota", "Camry"));
		directory.put(3, new Vehicle(3, 2017, "Tesla", "Speedster"));
		directory.put(4, new Vehicle(1, 2015, "Honda", "Civic"));
		directory.put(5, new Vehicle(2, 2015, "Toyota", "Prius"));
		directory.put(6, new Vehicle(3, 2015, "Tesla", "Model3"));
	}

	private static VehicleDAOImpl instance = new VehicleDAOImpl();

	synchronized static public VehicleDAOImpl getInstance() {
		return instance;
	}

	@Override
	public Collection<Vehicle> getAllVehicles() {
		return directory.values();
	}

	@Override
	public Collection<Vehicle> getAllVehicles(String make, String model, int year) {
		Map<Integer, Vehicle> results = new ConcurrentHashMap<>();
		Vehicle vehicle = null;

		for (Integer key : directory.keySet()) {
			vehicle = directory.get(key);
			if (make != null) {
				if (vehicle.getMake().equalsIgnoreCase(make))
					results.put(vehicle.getId(), vehicle);
			} else if (model != null) {
				if (vehicle.getModel().equalsIgnoreCase(model))
					results.put(vehicle.getId(), vehicle);
			} else if (year != 0) {
				if (vehicle.getYear() == year)
					results.put(vehicle.getId(), vehicle);
			}
		}
		return (Collection<Vehicle>) results.values();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		if (directory.containsKey(id))
			return directory.get(id);
		return null;
	}

	@Override
	public void addVehicle(Vehicle vehicle) throws Exception {
		if (isValid(vehicle))
			directory.put(vehicle.getId(), vehicle);
		else
			throw new Exception("Invalid vehicle parameters!");
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		if (directory.containsKey(vehicle.getId()))
			directory.put(vehicle.getId(), vehicle);
	}

	@Override
	public void deleteVehicle(int id) {
		if (directory.containsKey(id))
			directory.remove(id);
	}

	private boolean isValid(Vehicle vehicle) {
		if (vehicle.getMake() != null && vehicle.getMake().length() > 0 && vehicle.getModel() != null
				&& vehicle.getModel().length() > 0 && 1950 <= vehicle.getYear() && vehicle.getYear() <= 2050)
			return true;
		return false;
	}

}
