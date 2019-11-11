package com.example.main;

public class Order {

	private String customer;
	private Drink drinkOrder;
	private Food foodOrder;
	
	public Order(String customer, Drink drinkOrder, Food foodOrder) {
		super();
		this.customer = customer;
		this.drinkOrder = drinkOrder;
		this.foodOrder = foodOrder;
	}

	public Order(String customer, Drink drinkOrder) {
		super();
		this.customer = customer;
		this.drinkOrder = drinkOrder;
	}

	public Order(String customer, Food foodOrder) {
		super();
		this.customer = customer;
		this.foodOrder = foodOrder;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Drink getDrinkOrder() {
		return drinkOrder;
	}

	public void setDrinkOrder(Drink drinkOrder) {
		this.drinkOrder = drinkOrder;
	}

	public Food getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(Food foodOrder) {
		this.foodOrder = foodOrder;
	}

	@Override
	public String toString() {
		return (customer + "ordered a " + drinkOrder + "to drink and " + foodOrder + " for food");
	}
	
	
	
	
}
