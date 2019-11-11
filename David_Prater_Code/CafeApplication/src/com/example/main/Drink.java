package com.example.main;

import java.util.HashMap;

public class Drink {
	
	private String drinkName;
	private int drinkPrice;
	
	HashMap<String, Double> drinkStorage = new HashMap<String, Double>();
	
	public Drink(String drinkName, int drinkPrice) {
		super();
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
	}



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
	
	
	
	
}
