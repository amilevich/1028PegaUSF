package com.homework.cafe;

import java.util.LinkedList;

public class FoodOrder {
	
	LinkedList<String> foodList = new LinkedList<String>();
	
	private String subSandwhich = "Sub Sandwhich";
	private String soup = "Soup";
	private String chickenSandwhich = "Chicken Sandwhich";
	private String Steak = "Steak";
	private String breadedSteak = "Breaded Steak";
	private String burger = "Burger";
	private String veganBurger = "Vegan Burger";
	
	public FoodOrder() {
		
	}

	public String getSubSandwhich() {
		return subSandwhich;
	}

	public void setSubSandwhich(String subSandwhich) {
		subSandwhich = subSandwhich;
	}

	public String getSoup() {
		return soup;
	}

	public void setSoup(String soup) {
		soup = soup;
	}

	public String getChickenSandwhich() {
		return chickenSandwhich;
	}

	public void setChickenSandwhich(String chickenSandwhich) {
		this.chickenSandwhich = chickenSandwhich;
	}

	public String getSteak() {
		return Steak;
	}

	public void setSteak(String steak) {
		Steak = steak;
	}

	public String getBreadedSteak() {
		return breadedSteak;
	}

	public void setBreadedSteak(String breadedSteak) {
		this.breadedSteak = breadedSteak;
	}

	public String getBurger() {
		return burger;
	}

	public void setBurger(String burger) {
		this.burger = burger;
	}

	public String getVeganBurger() {
		return veganBurger;
	}

	public void setVeganBurger(String veganBurger) {
		this.veganBurger = veganBurger;
	}
	
	public String toString() {
		
		if(foodList.isEmpty()) {
			return "NONE";
		}
		else {
		String temp = "Food: [";
		for(String x:foodList) {
			temp += x + ", ";
		}
		temp = temp.substring(0,temp.lastIndexOf(','));
		temp += "]";
		return temp;
		}
		
	}
	
	
}
