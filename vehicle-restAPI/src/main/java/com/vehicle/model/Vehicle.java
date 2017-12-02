/**
 * 
 */
package com.vehicle.model;

/**
 * @author ericfernandes
 * @created Dec 2, 2017
 */
public class Vehicle {

	private int Id;
	private int Year;
	private String Make;
	private String Model;

	public Vehicle() {
	}

	public Vehicle(int id, int year, String make, String model) {
		super();
		Id = id;
		Year = year;
		Make = make;
		Model = model;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((Make == null) ? 0 : Make.hashCode());
		result = prime * result + ((Model == null) ? 0 : Model.hashCode());
		result = prime * result + Year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (Id != other.Id)
			return false;
		if (Make == null) {
			if (other.Make != null)
				return false;
		} else if (!Make.equals(other.Make))
			return false;
		if (Model == null) {
			if (other.Model != null)
				return false;
		} else if (!Model.equals(other.Model))
			return false;
		if (Year != other.Year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [Id=" + Id + ", Year=" + Year + ", Make=" + Make + ", Model=" + Model + "]";
	}

}
