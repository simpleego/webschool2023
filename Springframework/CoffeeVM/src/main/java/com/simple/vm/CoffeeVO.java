package com.simple.vm;

public class CoffeeVO {
	
	private int pID;
	private String pName;
	private int pPrice;
	private String pImageUrl;
	
	public CoffeeVO() {
		// TODO Auto-generated constructor stub
	}

	public CoffeeVO(int pID, String pName, int pPrice, String pImageUrl) {		
		this.pID = pID;
		this.pName = pName;
		this.pPrice = pPrice;
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

	public String getpImageUrl() {
		return pImageUrl;
	}

	public void setpImageUrl(String pImageUrl) {
		this.pImageUrl = pImageUrl;
	}

	@Override
	public String toString() {
		return "CoffeeVO [pID=" + pID + ", pName=" + pName + ", pPrice=" + pPrice + ", pImageUrl=" + pImageUrl + "]";
	}
}
