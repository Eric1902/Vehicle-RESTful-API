package com.vehicle.dao;

import java.util.Collection;

import com.vehicle.model.Vehicle;

/**
 * @author ericfernandes
 * @created Dec 2, 2017
 */
public interface VehicleDAO {

	public Collection<Vehicle> getAllVehicles();

	public Vehicle getVehicleById(int id);

	public void addVehicle(Vehicle vehicle) throws Exception;

	public void updateVehicle(Vehicle vehicle);

	public void deleteVehicle(int id);

}
