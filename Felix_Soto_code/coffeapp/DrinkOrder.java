package com.examples.cafeapp;

public class DrinkOrder {
	String name;
	String drink;
	
	public DrinkOrder(String name, String drink) {
		super();
		this.name = name;
		this.drink = drink;
		
	}
	public DrinkOrder(String c) {
		this.name = c;
		this.drink = " ";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	
	@Override
	public String toString() {
		return "DrinkOrder [name=" + name + ", drink=" + drink + "]";
	}
}
