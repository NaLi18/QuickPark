package com.parking.entity;


public class Garage {
	private String GarageID;
    private String Location;
    private String city;
    private Double latitude;
    private Double longitude;
    private Integer Capacity;
    private String Section[];
    private Integer spot;
    private String Name;
    private String OwnerID;
    private Double unitPrice;
    private Double Rate;
    
	public String getGarageID() {
		return GarageID;
	}
	public void setGarageID(String garageID) {
		GarageID = garageID;
	}
	public void setRate(Double rate) {
		Rate = rate;
	}
	public Double getRate() {
		return Rate;
	}
	public void setUnitPrice(Double UnitPrice) {
		unitPrice = UnitPrice;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setLatitude(Double Latitude) {
		latitude = Latitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLongitude(Double Longitude) {
		longitude = Longitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public String[] getSection() {
		return Section;
	}
	public void setSection(String[] section) {
		Section = section;
	}
	public void setSpot(Integer Spot) {
		spot = Spot;
	}
	public Integer getSpot() {
		return spot;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
