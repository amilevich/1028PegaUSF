package com.example.main;

public class Food {

	private String foodName;
	private double foodPrice;
	private String foodDescription;
	
	public Food(String foodName, int foodPrice, String foodDescription) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodDescription = foodDescription;
	}


	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	
	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}


	
}
