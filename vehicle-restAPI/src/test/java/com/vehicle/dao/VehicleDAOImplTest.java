package com.vehicle.dao;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
	public void getVehiclesFiltered() throws Exception {

		Map<Integer, Vehicle> verify = new ConcurrentHashMap<>();

		Vehicle vehicle1 = new Vehicle(101, 2017, "MyMake", "Accord");
		Vehicle vehicle2 = new Vehicle(102, 2017, "MyMake", "City");
		Vehicle vehicle3 = new Vehicle(103, 2017, "NotMyMake", "Camry");
		dao.addVehicle(vehicle1);
		dao.addVehicle(vehicle2);
		dao.addVehicle(vehicle3);

		verify.put(101, vehicle1);
		verify.put(102, vehicle2);

		Collection<Vehicle> result1 = dao.getAllVehicles("MyMake", null, 0);
		Collection<Vehicle> result2 = verify.values();

		assertEquals(true, areEqual(result1, result2));
	}

	private boolean areEqual(Collection<Vehicle> result1, Collection<Vehicle> result2) {

		if (result1.toString().equals(result2.toString()))
			return true;
		return false;
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
