package com.simple.vm;

public class SalesCoffeeVO {
	
	private String coffeeType;
	private int salesAmount;
	
	public SalesCoffeeVO() {
		// TODO Auto-generated constructor stub
	}

	public SalesCoffeeVO(String coffeeType, int salesAmount) {
		this.coffeeType = coffeeType;
		this.salesAmount = salesAmount;
	}

	public String getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	@Override
	public String toString() {
		return "SalesCoffeeVO [CoffeeType=" + coffeeType + ", salesAmount=" + salesAmount + "]";
	}
}
