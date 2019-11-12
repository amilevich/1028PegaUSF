package com.cafe_app;



public class DrinkOrder  {

	// private variable declaration
	private String drinkName;
	private String customer;
	private String foodOrder;
	
	//constructor getting customer name drink and type of food
	public DrinkOrder(String customer, String drinkName, String foodOrder) {
		super();
		this.drinkName = drinkName;
		this.customer = customer;
		this.foodOrder = foodOrder;
	}
	//getters & setters
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	
	public String getFoodOrder() {
		return foodOrder;
	}
	public void setFoodOrder(String foodOrder) {
		this.foodOrder = foodOrder;
	}
	//to String method
	@Override
	public String toString() {
		return customer + " " + drinkName + " " + foodOrder;
	}

}
