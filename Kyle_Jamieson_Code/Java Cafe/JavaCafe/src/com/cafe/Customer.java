package com.cafe;

public class Customer 
{
	private DrinkOrder drink;
	private FoodOrder food;
	
	public Customer()
	{
		food = new FoodOrder();
		food.setFood("no food");
		drink = new DrinkOrder();
		drink.setDrink("no drink");
	}
	
	public void setDrink(String _drink)
	{
		drink.setDrink(_drink);
	}
	
	public void setFood(String _food)
	{
		food.setFood(_food);
	}
	
	public String toString()
	{
		return "Customer given " + food.getFood() + " and " + drink.getDrink();
	}
}
