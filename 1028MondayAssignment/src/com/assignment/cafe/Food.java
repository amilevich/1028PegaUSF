package com.assignment.cafe;

public class Food {
	//variables declared here
	private double subTotal;
	private double Total;
	private double foodPrice;
	private String foodType;
	
	public String toString() {
		return foodType + " " + foodPrice + " " + Total + " " + subTotal;
	}
	//getters and setters for accessing the data
	public double getSubTotal() {
		return subTotal;
	}
	//method that sets sub total(not necessary)
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	//method that gets the total price of the food
	public double getTotal() {
		return Total;
	}
	//method that sets the total(not needed)
	public void setTotal(double total) {
		Total = total;
	}
	//method that gets the price of the food
	public double getFoodPrice() {
		return foodPrice;
	}
	//method that sets the price of the food(not needed)
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	//the method that returns  the type of food
	public String getFoodType() {
		return foodType;
	}
	//this method sets the food type
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
}

