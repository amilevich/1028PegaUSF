package com.customer;

import java.util.ArrayList;

import com.menu.DrinksMenu;
import com.menu.FoodMenu;

public class Customer {
	
	private String name;
	private ArrayList<FoodMenu> food;
	private ArrayList<DrinksMenu> drinks;
	private int totalCost;
	
	
	
	public Customer(String name, ArrayList<FoodMenu> food, ArrayList<DrinksMenu> drinks) {
		super();
		this.name = name;
		this.food = food;
		this.drinks = drinks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<FoodMenu> getFood() {
		return food;
	}
	public void setFood(ArrayList<FoodMenu> food) {
		this.food = food;
	}
	public ArrayList<DrinksMenu> getDrinks() {
		return drinks;
	}
	public void setDrinks(ArrayList<DrinksMenu> drinks) {
		this.drinks = drinks;
	}
	public int getTotalCost() {
		return totalCost;
	}
	
	
	public int getAllCost() {
	int cost=0;
		
		for(int i=0; i<this.food.size(); i++) {
			cost +=(this.food.get(i).getPrice()*this.food.get(i).getQuantity());
		}
		for(int i=0; i<this.drinks.size(); i++) {
			cost+=(this.drinks.get(i).getDrinkPrice()*this.drinks.get(i).getQty());
		}
	return cost;
		
	}
	
	
	
	@Override
	public String toString() {
		String temp="";
		for(int i=0; i<this.getFood().size(); i++) {
			temp+= " "+ this.getFood().get(i).getName()+"-"+this.getFood().get(i).getQuantity();
		}
		for(int i=0; i<this.getDrinks().size(); i++) {
			temp+=" "+ this.getDrinks().get(i).getDrinkName()+"-"+this.getDrinks().get(i).getQty();
		}
		return temp;
	}
	public void printDetails() {
		
		for(int i=0; i<this.getFood().size(); i++) {
			this.getFood().get(i).toString();
		}
		
		for(int i=0; i<this.getDrinks().size(); i++) {
			this.getDrinks().get(i).toString();
		}
		
		
	}
	
	
	
	
	
	
	

}
