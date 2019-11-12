package com.assignments.day15;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Item> foodItems = new ArrayList<Item>();
	private ArrayList<Item> drinkItems = new ArrayList<Item>();
	private ArrayList<Item> combos = new ArrayList<Item>();
	
	public Menu() {
		foodItems.add(new Item("Hamburger", 2.00f));
		foodItems.add(new Item("Fries", 1.50f));
		foodItems.add(new Item("Hotdog", 1.00f));
		foodItems.add(new Item("Chicken Nuggets", 0.75f));
		
		drinkItems.add(new Item("Soda", 1.50f));
		drinkItems.add(new Item("Sweet Tea", 1.00f));
		drinkItems.add(new Item("Coffee", 0.50f));
	}

	public ArrayList<Item> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(ArrayList<Item> foodItems) {
		this.foodItems = foodItems;
	}
	
	public ArrayList<Item> getDrinkItems() {
		return drinkItems;
	}

	public void setDrinkItems(ArrayList<Item> drinkItems) {
		this.drinkItems = drinkItems;
	}

	public ArrayList<Item> getCombos() {
		return combos;
	}

	public void setCombos(ArrayList<Item> combos) {
		this.combos = combos;
	}
}
