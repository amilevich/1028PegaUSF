package com.assignment.cafe;

public class Drinks {
	//variables declared here private because they only belong to this class
	private double subTotal;
	private double Total;
	private String drinkType;
	private double drinkPrice;

	//getters and setters
	//get subTotal
	public double getSubTotal() {
		return subTotal;
	}
	//set the subTotal(but not necessary)
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	//get total of the drinks
	public double getTotal() {
		return Total;
	}
	//setter for total (but not necessary)
	public void setTotal(double total) {
		Total = total;
	}
	//the method that gets the price of the drink
	public double getDrinkPrice() {
		return drinkPrice;
	}
	//the set method that sets the drink price(not necessary)
	public void setDrinkPrice(double drinkPrice) {
		this.drinkPrice = drinkPrice;
	}
	//method that returns the type of drink
	public String getDrinkType() {
		return drinkType;
	}
	//method that sets the type of drink
	public void setDrinkType(String drinkType) {
		this.drinkType = drinkType;
	}
	
	
}
