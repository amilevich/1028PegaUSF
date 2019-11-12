package com.cafe;

public class FoodOrder 
{
	private String food;
	
	public FoodOrder()
	{
		food = new String("no food");
	}
	
	public String getFood()
	{
		return food;
	}
	
	public void setFood(String _food)
	{
		food = new String(_food);
	}

}
