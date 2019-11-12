package com.assignment.cafe;

public class MenuItem{
	
	public double price;
	public String itemType;
	
	MenuItem(String itemType, double price){
		this.price = price;
		this.itemType = itemType;
		
	}
	
	public void viewMenuItem() {
		System.out.println("food: "+ itemType.toString() + " " +"price: "+ price);
		
	}
	
	

	}