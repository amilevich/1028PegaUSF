package com.homework.cafe;

/*
 * Class that holds String's of menu items in LinkedList.
 */
import java.util.LinkedList;
import java.util.Queue;

public class FoodOrder { 
	
	Queue<String> foodList = new LinkedList<String>();
	
	private String subSandwhich = "Sub Sandwhich";
	private String soup = "Soup";
	private String chickenSandwhich = "Chicken Sandwhich";
	private String Steak = "Steak";
	private String breadedSteak = "Breaded Steak";
	private String burger = "Burger";
	private String veganBurger = "Vegan Burger";
	
	public FoodOrder() {
		
	}
	public Queue<String> getDrinks() {
		return foodList;
	}

	public String getSubSandwhich() {
		return subSandwhich;
	}

	public void setSubSandwhich(String subSandwhich) {
		this.subSandwhich = subSandwhich;
	}

	public String getSoup() {
		return soup;
	}

	public void setSoup(String soup) {
		this.soup = soup;
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
