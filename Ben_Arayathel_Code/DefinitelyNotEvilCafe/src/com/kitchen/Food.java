package com.kitchen;

public class Food extends MenuItem{
	
	public Food() {
		super();
	}
	public Food(String name,double price) {
		super(name,price,"This is a food item, human, with nutrition.");
	}
	
}
