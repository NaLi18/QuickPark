package com.parking.entity;


public class Garage {
	private String GarageID;
    private String Location;
    private Integer Capacity;
    private String Name;
    private String OwnerID;
	public String getGarageID() {
		return GarageID;
	}
	public void setGarageID(String garageID) {
		GarageID = garageID;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Integer getCapacity() {
		return Capacity;
	}
	public void setCapacity(Integer capacity) {
		Capacity = capacity;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getOwnerID() {
		return OwnerID;
	}
	public void setOwnerID(String ownerID) {
		OwnerID = ownerID;
	}
}
