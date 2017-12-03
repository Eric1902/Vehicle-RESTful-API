package com.vehicle.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vehicle.model.Vehicle;

/**
 * @author ericfernandes
 * @created Dec 2, 2017
 */
public class VehicleDAOImplTest {

	private final VehicleDAOImpl dao = VehicleDAOImpl.getInstance();

	@Test
	public void getVehicle() throws Exception {
		
		Vehicle vehicle = new Vehicle(1, 2017, "Honda", "Accord");

		assertEquals(dao.getVehicleById(1), vehicle);
	}

	@Test
	public void postVehicle() throws Exception {

		Vehicle vehicle1 = new Vehicle(102, 1950, "Make1", "Model1");
		Vehicle vehicle2 = new Vehicle(103, 2050, "Make2", "Model2");
		dao.addVehicle(vehicle1);
		dao.addVehicle(vehicle2);

		assertEquals(dao.getVehicleById(102), vehicle1);
		assertEquals(dao.getVehicleById(103), vehicle2);
	}

	@Test
	public void updateVehicleTest() throws Exception {

		Vehicle vehicle = new Vehicle(102, 1950, "Make1", "Model1");
		dao.addVehicle(vehicle);
		dao.updateVehicle(new Vehicle(102, 1951, "updatedMake", "updatedModel"));

		vehicle = dao.getVehicleById(102);

		assertEquals(vehicle.getYear(), 1951);
		assertEquals(vehicle.getMake(), "updatedMake");
		assertEquals(vehicle.getModel(), "updatedModel");
	}

	@Test
	public void deleteVehicleTest() throws Exception {

		Vehicle vehicle = new Vehicle(999, 2000, "Make", "Model");
		dao.addVehicle(vehicle);
		dao.deleteVehicle(999);

		assertEquals(dao.getVehicleById(999), null);
	}
}
