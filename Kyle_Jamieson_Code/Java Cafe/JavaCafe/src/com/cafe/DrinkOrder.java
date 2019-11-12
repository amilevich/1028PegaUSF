package com.cafe;

public class DrinkOrder 
{
	private String drink;
	
	public DrinkOrder()
	{
		drink = new String("no drink");
	}
	
	public String getDrink()
	{
		return drink;
	}
	
	public void setDrink(String _drink)
	{
		drink = new String(_drink);
	}
}
