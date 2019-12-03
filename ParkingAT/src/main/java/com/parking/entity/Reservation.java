package com.parking.entity;

import java.sql.Date;
import org.bson.types.ObjectId;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class Reservation {
    private String userID;
    private String checkInDate;
    private String checkOutDate;
    private String checkInTime;
    private String checkOutTime;
    private String paymentId;
    //private boolean Cancellation;
    private String GarageID;
    private boolean isPaid;
    private String spots;
    private double price;
    
	public String getUserID() {
		return userID;
	}
	public void setUserID(String customerID) {
		userID = customerID;
	}
	public String getStartTime() {
		return checkInTime;
	}
	public void setStartTime(String checkin) {
		checkInTime = checkin;
	}
	public String getEndTime() {
		return checkOutTime;
	}
	public void setEndTime(String time) {
		checkOutTime= time;
	}
	public String getStartDate() {
		return checkInDate;
	}
	public void setStartDate(String checkin) {
		checkInDate = checkin;
	}
	public String getEndDate() {
		return checkOutDate;
	}
	public void setEndDate(String time) {
		checkOutDate= time;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGarageID() {
		return GarageID;
	}
	public void setGarageID(String garageID) {
		GarageID = garageID;
	}
	public boolean getPaid() {
		return isPaid;
	}
	public void setPaid(boolean paid) {
		isPaid = paid;
	}
	public void setSpots(String spot){
		spots = spot;
	}
	public String getSpots(){
		return spots;
	}
}
