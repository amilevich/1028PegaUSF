package com.example.main;

public class Food {
	
	// Declare variables
	private String foodName;
	private int foodPrice;

	// Define a constructor to instantiate Food objects	
	public Food(String foodName, int foodPrice) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}

	// Getters and setters for food variables
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	// Override to string to format the food output
	@Override
	public String toString() {
		return "Food: " + foodName + ". Food Price: " + foodPrice + ".";
	}

}
