package com.vehicle.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.model.Vehicle;
import com.vehicle.service.VehicleService;

/**
 * @author ericfernandes
 * @created Dec 2, 2017
 */
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

	private VehicleService service = VehicleService.getInstance();

	@GetMapping
	public Collection<Vehicle> getAllVehicles(@RequestParam(value = "make", required = false) String make,
			@RequestParam(value = "model", required = false) String model,
			@RequestParam(value = "year", required = false) Integer year) {
		
		System.out.println("Make: "+make+" |Model: "+model+" |Year: "+year);
		
		if(make!=null || model!=null || year !=null)
			if(year==null)
				return service.getAllVehicles(make, model, 0);
			else
				return service.getAllVehicles(make, model, year);
				
		return service.getAllVehicles();
	}

	@GetMapping(value = "/{id}")
	public Vehicle getVhicleById(@PathVariable int id) {
		return service.getVehicleById(id);
	}

	@PostMapping
	public void addVehicle(@RequestBody Vehicle vehicle) throws Exception {
		service.addVehicle(vehicle);
	}

	@PutMapping
	public void updateVehicle(@RequestBody Vehicle vehicle) {
		service.updateVehicle(vehicle);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteVehicle(@PathVariable int id) {
		service.deleteVehicle(id);
	}

}
