package com.parking.entity;

public class Customer {
	private String DriverLicenceId;
    private String Name;
    private String Password;
    private String phone;
    private String email;
	public String getDriverLicenceId() {
		return DriverLicenceId;
	}
	public void setDriverLicenceId(String driverLicenceId) {
		DriverLicenceId = driverLicenceId;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
