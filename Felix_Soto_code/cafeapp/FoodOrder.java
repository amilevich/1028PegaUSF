package com.examples.cafeapp;

public class FoodOrder {
	private String name;
	private String meal;
	
	public FoodOrder(String name, String meal) {
		super();
		this.name = name;
		this.meal = meal;
		
	}
	public FoodOrder(String c) {
		this.name = c;
		this.meal = " ";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}

	@Override
	public String toString() {
		return "FoodOrder [name=" + name + ", meal=" + meal + "]";
	}
}