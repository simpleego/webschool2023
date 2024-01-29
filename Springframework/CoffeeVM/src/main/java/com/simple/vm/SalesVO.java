package com.simple.vm;

public class SalesVO {
	
	private int amount;
	private int salesPrice;
	private int pID;
	
	public SalesVO() {
		// TODO Auto-generated constructor stub
	}

	public SalesVO(int amount, int salesPrice, int pID) {
		this.amount = amount;
		this.salesPrice = salesPrice;
		this.pID = pID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	@Override
	public String toString() {
		return "SalesVO [amount=" + amount + ", salesPrice=" + salesPrice + ", pID=" + pID + "]";
	}
}
