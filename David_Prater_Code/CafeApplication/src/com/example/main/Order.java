package com.example.main;

import java.util.ArrayList;

public class Order {

	// Create private methods to encapsulate the class
	private String customer;
	private ArrayList<Drink> drinkOrder;
	private ArrayList<Food> foodOrder;
	private int price;
	
	// Create a constructor to create Order objects
	public Order(String customer, ArrayList<Drink> drinkOrder, ArrayList<Food> foodOrder, int price) {
		super();
		this.customer = customer;
		this.drinkOrder = drinkOrder;
		this.foodOrder = foodOrder;
		this.setPrice(price);
	}

	// Create getters and setters for all variables in the class
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public ArrayList<Drink> getDrinkOrder() {
		return drinkOrder;
	}

	public void setDrinkOrder(ArrayList<Drink> drinkOrder) {
		this.drinkOrder = drinkOrder;
	}

	public ArrayList<Food> getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(ArrayList<Food> foodOrder) {
		this.foodOrder = foodOrder;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	// Override to string to print Order objects
	// i.e. David
	//		Food Order: Club Sandwich
	//		Drink Order: Coffee
	//		Order total: $6
	@Override
	public String toString() {
		return (customer + "\nFood Order: \n" + foodOrder + "\nDrink Order: \n" + drinkOrder + ".\nOrder Total: $" + price + ".\n");
	}	
	
}
