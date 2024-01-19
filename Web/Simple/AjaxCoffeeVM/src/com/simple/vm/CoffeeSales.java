package com.simple.vm;


public class CoffeeSales {
	String coffeeType;
	int amount;
	
	
	public CoffeeSales() {
	}
	
	public CoffeeSales(String coffeeType, int amount) {
		this.coffeeType = coffeeType;
		this.amount = amount;
	}
	
	public String getCoffeeType() {
		return coffeeType;
	}
	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CoffeeSales [coffeeType=" + coffeeType + ", amount=" + amount + "]";
	}	
	
}
