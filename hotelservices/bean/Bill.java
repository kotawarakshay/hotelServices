package com.cg.hotelservices.bean;

public class Bill {
	
	private String customerId;
	private int days;
	private int bill;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "Bill [customerId=" + customerId + ", days=" + days + ", bill=" + bill + "]";
	}
	
	

}
