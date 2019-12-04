package com.parking.entity;


public class GarageOwner {
	private String GarageOwnerID;
    private String Name;
    private String Password;
    private String email;
    private String Phone;
	public String getGarageOwnerID() {
		return GarageOwnerID;
	}
	public void setGarageOwnerID(String garageOwnerID) {
		GarageOwnerID = garageOwnerID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
}
