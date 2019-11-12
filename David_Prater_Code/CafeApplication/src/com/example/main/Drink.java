package com.example.main;

public class Drink {

	// Private methods
	private String drinkName;
	private int drinkPrice;

	// Constructor to create drink objects
	public Drink(String drinkName, int drinkPrice) {
		super();
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
	}

	// Getters and setters for drink variables
	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getDrinkPrice() {
		return drinkPrice;
	}

	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}

	// Override to string to format the drink output
	@Override
	public String toString() {
		return "Drink: " + drinkName + ". Drink Price: " + drinkPrice + ".";
	}

}
