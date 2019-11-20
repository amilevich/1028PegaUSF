package com.menu;

public class DrinksMenu {
	
	private String drinkName;
	private int drinkPrice;
	private int qty;
	public DrinksMenu(String drinkName, int drinkPrice, int qty) {
		super();
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.qty=qty;
		
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
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public void print() {
		String temp = this.getDrinkName() + "-"+ this.getQty();
		System.out.println(temp);
	}
	
	

}
