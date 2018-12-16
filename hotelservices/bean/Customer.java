package com.cg.hotelservices.bean;

import java.util.Date;

public class Customer {
	
	private String customerName;
	private String customerId;
	private String customerPhoneNumber;
	private String checkInDate;
	private String checkOutDate;
	private String roomType;
	
	
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", customerPhoneNumber="
				+ customerPhoneNumber + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", roomType=" + roomType + "]";
	}
	
	
	

	
	
	
}
