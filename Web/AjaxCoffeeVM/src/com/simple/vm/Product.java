package com.simple.vm;

public class Product {
	int pID;
	String pName;
	int pPrice;
	int pAmount;
	String pImageUrl;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product( String pName, int pPrice, int pAmount, String pImageUrl) {
		
		this.pName = pName;
		this.pPrice = pPrice;
		this.pAmount = pAmount;
		this.pImageUrl = pImageUrl;
	}
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpAmount() {
		return pAmount;
	}
	public void setpAmount(int pAmount) {
		this.pAmount = pAmount;
	}
	public String getpImageUrl() {
		return pImageUrl;
	}
	public void setpImageUrl(String pImageUrl) {
		this.pImageUrl = pImageUrl;
	}

	@Override
	public String toString() {
		return "Product [pID=" + pID + ", pName=" + pName + ", pPrice=" + pPrice + ", pAmount=" + pAmount
				+ ", pImageUrl=" + pImageUrl + "]";
	}
	
}
