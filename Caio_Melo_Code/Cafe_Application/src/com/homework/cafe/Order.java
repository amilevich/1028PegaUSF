package com.homework.cafe;

import java.util.Scanner;

public class Order {

	
	
	private String name;
	protected DrinkOrder drinks = new DrinkOrder();
	private FoodOrder foods = new FoodOrder();
	
	public Order() {
		
	}

	public void orderDrink() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please make a selection:");
		System.out.println("[1]Coffee");
		System.out.println("[2]DecafeCoffee");
		System.out.println("[3]Espresso");
		System.out.println("[4]Latte");
		System.out.println("[5]Cappuccino");
		System.out.println("[6]Machiato");
		System.out.println("[7]Tea");
		System.out.println("[8]Orange Juice");
		System.out.println("[9]Apple Juice");
		System.out.println("[10]Cranberry Juice");
		System.out.println("[11]Water");
		System.out.println("[0]Go Back");
		int input = sc.nextInt();

		switch (input) {
		case 0:
			MainDriver.prompt(this);
		case 1:
			drinks.drinksList.add(drinks.getCoffee());
			System.out.println("Coffee added to order!");
			break;
		case 2:
			drinks.drinksList.add(drinks.getDecafeCoffee());
			System.out.println("Decafe Coffee added to order!");
			break;
		case 3:
			drinks.drinksList.add(drinks.getEspresso());
			System.out.println("Espresso added to order!");
			break;
		case 4:
			drinks.drinksList.add(drinks.getLatte());
			System.out.println("Latte added to order!");
			break;
		case 5:
			drinks.drinksList.add(drinks.getCappuccino());
			System.out.println("cappuccino added to order!");
			break;
		case 6:
			drinks.drinksList.add(drinks.getMachiato());
			System.out.println("Machiato added to order!");
			break;
		case 7:
			drinks.drinksList.add(drinks.getTea());
			System.out.println("Tea added to order!");
			break;
		case 8:
			drinks.drinksList.add(drinks.getOrangeJuice());
			System.out.println("Orange Juice added to order!");
			break;
		case 9:
			drinks.drinksList.add(drinks.getAppleJuice());
			System.out.println("Apple Juice added to order!");
			break;
		case 10:
			drinks.drinksList.add(drinks.getCranberryJuice());
			System.out.println("Cranberry Juice added to order!");
			break;
		case 11:
			drinks.drinksList.add(drinks.getWater());
			System.out.println("Water added to order!");
			break;
		default:
			System.out.println("Please make a proper selection:");
			orderDrink();

		}
	
		rePrompt();

	}
	
	public void orderFood() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please make a selection:");
		System.out.println("[1]Sub Sandwhich");
		System.out.println("[2]Soup");
		System.out.println("[3]Chicken Sandwhich");
		System.out.println("[4]Steak");
		System.out.println("[5]Breaded Steak");
		System.out.println("[6]Burger");
		System.out.println("[7]Vegan Burger");
		System.out.println("[0]Go Back");
		int input = sc.nextInt();

		switch (input) {
		case 0:
			MainDriver.prompt(this);
		case 1:
			foods.foodList.add(foods.getSubSandwhich());
			System.out.println("Sub Sandwhich added to order!");
			break;
		case 2:
			foods.foodList.add(foods.getSoup());
			System.out.println("Soup added to order!");
			break;
		case 3:
			foods.foodList.add(foods.getChickenSandwhich());
			System.out.println("Chicken Sandwhich added to order!");
			break;
		case 4:
			foods.foodList.add(foods.getSteak());
			System.out.println("Steak added to order!");
			break;
		case 5:
			foods.foodList.add(foods.getBreadedSteak());
			System.out.println("Breaded Steak added to order!");
			break;
		case 6:
			foods.foodList.add(foods.getBurger());
			System.out.println("Burger added to order!");
			break;
		case 7:
			foods.foodList.add(foods.getVeganBurger());
			System.out.println("vegan Burger added to order!");
			break;
		default:
			System.out.println("Please make a proper selection:");
			orderFood();

		}
	rePrompt();

	}
	
	public void rePrompt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to order another item?");
		System.out.println("[1]Yes");
		System.out.println("[2]No");
		int input = sc.nextInt();
	
		switch(input) {
		case 1: MainDriver.prompt(this);
			break;
		case 2:	
			System.out.println(this.toString());
			
			break;
		}
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DrinkOrder getDrinks() {
		return drinks;
	}

	public void setDrinks(DrinkOrder drinks) {
		this.drinks = drinks;
	}

	public FoodOrder getFood() {
		return foods;
	}

	public void setFood(FoodOrder food) {
		this.foods = food;
	}
	
	public String toString() {
		
		String orderTemp = this.name +"'s order:" +drinks.toString()+ " " + foods.toString();
		
		return orderTemp;
	}
	
	
}
