package com.techelevator.model;
//properties of repair cost taken from database

public class Price {
	private int price;
	private int repairId;
	private String repairType;
	
	public Price(int price, int repairId, String repairType) {
		this.price = price;
		this.repairId = repairId;
		this.repairType = repairType;
	}
	
	public Price() {}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getRepairId() {
		return repairId;
	}
	
	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}
	
	public String getRepairType() {
		return repairType;
	}
	
	public void setRepairType(String repairType) {
		this.repairType = repairType;
	}
}