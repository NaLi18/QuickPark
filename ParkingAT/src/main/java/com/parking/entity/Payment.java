package com.parking.entity;

import java.sql.Date;

public class Payment {
	private String PaymentId;
    private String CardNumber;
    private Date ExpireDate;
    private String PaymentType;
    private String CVS;
    private String UserID;
	public String getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(String paymentId) {
		PaymentId = paymentId;
	}
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	public Date getExpireDate() {
		return ExpireDate;
	}
	public void setExpireDate(Date expireDate) {
		ExpireDate = expireDate;
	}
	public String getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}
	public String getCVS() {
		return CVS;
	}
	public void setCVS(String cVS) {
		CVS = cVS;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
}
