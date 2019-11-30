package com.parking.entity;

import java.sql.Date;
import java.sql.Time;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Reservation {
	private String ReservationID;
    private String CustomerID;
    private Date Date;
    private Time StartTime;
    private String PaymentId;
    private boolean Cancellation;
    private String GarageID;
    private boolean Paid;
	public String getReservationID() {
		return ReservationID;
	}
	public void setReservationID(String reservationID) {
		ReservationID = reservationID;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public Time getStartTime() {
		return StartTime;
	}
	public void setStartTime(Time startTime) {
		StartTime = startTime;
	}
	public String getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(String paymentId) {
		PaymentId = paymentId;
	}
	public boolean getCancellation() {
		return Cancellation;
	}
	public void setCancellation(boolean cancellation) {
		Cancellation = cancellation;
	}
	public String getGarageID() {
		return GarageID;
	}
	public void setGarageID(String garageID) {
		GarageID = garageID;
	}
	public boolean getPaid() {
		return Paid;
	}
	public void setPaid(boolean paid) {
		Paid = paid;
	}
}
