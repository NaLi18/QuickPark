package com.parking.entity;

public class Message {
	private String MessageID;
	private String MessageContent;
	private String Reciever;
	private String Sender;
	public String getMessageID() {
		return MessageID;
	}
	public void setMessageID(String messageID) {
		MessageID = messageID;
	}
	public String getMessageContent() {
		return MessageContent;
	}
	public void setMessageContent(String messageContent) {
		MessageContent = messageContent;
	}
	public String getReciever() {
		return Reciever;
	}
	public void setReciever(String reciever) {
		Reciever = reciever;
	}
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}
}
