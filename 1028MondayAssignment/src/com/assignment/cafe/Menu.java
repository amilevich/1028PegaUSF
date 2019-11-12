package com.assignment.cafe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
	//scanner instantiation and objects
	//-------------------------------------------------------------------
	Scanner input = new Scanner(System.in);
	Food f = new Food();
	Drinks d = new Drinks();
	Queue<String>orderList = new LinkedList<String>(); //creating the queue to store orders
	//variables
	private double subTotal;
	private double total;
	private double foodPrice1 = (double)3.25; //i have to format my doubles to read the decumals
	private double foodPrice2 = (double)5.50;
	private double foodPrice3 = (double)6.55;
	private double drinkPrice1 = (double)1.25;
	private double drinkPrice2 = (double)1.25;
	private double drinkPrice3 = (double)1.25;
	private double itemPrice;
	private String foodType;
	private String drinkType;
	private boolean ordering = true;
	int choice;
	int food = 0;
	int drink = 0;
	int counter=0;
//-------------------------------------------------------------------------------------------
	//my methods
	public void MainMenu() {
		
		System.out.println("________________WELCOME TO CAFE_____________________");
		System.out.println("______________________Menu__________________________");
		System.out.println("______________________FOOD__________________________");
		System.out.println("1. Ham and Cheese  Sandwich....................$3.25");
		System.out.println("2. Egg and Cheese  Sandwich....................$4.25");
		System.out.println("3. Egg and Sausage Sandwich....................$5.35");
		System.out.println("______________________DRINKS________________________");
		System.out.println("4. Apple Juice.................................$1.25");
		System.out.println("5. Orange Juice................................$1.25");
		System.out.println("6. Tomato Juice................................$1.25");
		do {
			
			System.out.print("Please enter your odrer or (7) to finish: ");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				food = 1;
				itemFoodPrice(food);
				break;
			case 2:
				food = 2;
				itemFoodPrice(food);
				break;
			case 3:
				food = 3;
				itemFoodPrice(food);
				break;
			case 4:
				drink = 4;
				itemDrinkPrice(drink);
				break;
			case 5:
				drink = 5;
				itemDrinkPrice(drink);
				break;
			case 6:
				drink = 6;
				itemDrinkPrice(drink);
				break;
			case 7:
				finish();
				break;
			default:
				System.out.println("invalid option");
			}
		} while (ordering);
		System.out.println("Total: " +"$"+ total);
	}
//---------------------------------------------------------------
	//ItemFoodPrice method, takes argument of food item
	
	public double itemFoodPrice(int food) {
		
		if(food == 1) {
			foodType = "Ham and Cheese Sandwich"; 
			f.setFoodType(foodType);
			orderList.add(foodType);//adding to the list
			System.out.println(f.getFoodType());
			f.setFoodPrice(foodPrice1);
			itemPrice = f.getFoodPrice();
			System.out.println("Price: " +"$"+ itemPrice);
		}else if(food == 2) {
			foodType = "Egg and Bacon Sandwich";
			f.setFoodType(foodType);
			orderList.add(foodType);//adding to the list
			System.out.println(f.getFoodType());
			f.setFoodPrice(foodPrice2);
			itemPrice = f.getFoodPrice();
			System.out.println("Price: " +"$"+ itemPrice);
		}else if(food == 3) {
			foodType = "Egg and Sausage Sandwich";
			f.setFoodType(foodType);
			orderList.add(foodType);//adding to the list
			System.out.println(f.getFoodType());
			f.setFoodPrice(foodPrice3);
			itemPrice = f.getFoodPrice();
			System.out.println("Price: " +"$"+ itemPrice);
		}else {
			System.out.println("not a valid food option!");
		}
		qty();
		return itemPrice;
	}
//----------------------------------------------------------------
	//itemDrinkPrice method, it takes an argument of drink item
	public double itemDrinkPrice(int drink) {
		if(drink == 4) {
			drinkType = "Apple Juice";
			d.setDrinkType(drinkType);
			orderList.add(drinkType);//adding to the list
			System.out.println(d.getDrinkType());
			d.setDrinkPrice(drinkPrice1);
			itemPrice = d.getDrinkPrice();
			System.out.println("Price: " +"$"+ itemPrice);
		}else if(drink == 5) {
			drinkType = "Orange Juice";
			d.setDrinkType(drinkType);
			orderList.add(drinkType);//adding to the list
			System.out.println(d.getDrinkType());
			d.setDrinkPrice(drinkPrice2);
			itemPrice = d.getDrinkPrice();
			System.out.println("Price: " +"$"+ itemPrice);
		}else if(drink == 6) {
			drinkType = "Tomato Juice";
			d.setDrinkType(drinkType);
			orderList.add(drinkType);//adding to the list
			System.out.println(d.getDrinkType());
			d.setDrinkPrice(drinkPrice3);
			itemPrice = d.getDrinkPrice();
			System.out.println("Price: " +"$"+ itemPrice);
		}else {
			System.out.println("not a valid drink option!");
		}
		qty();
		return itemPrice;
	}
//------------------------------------------------------------------
	//Quantity method
	public double qty() {
		System.out.println("How many:  ");
		double qty = input.nextDouble();
		subTotal(qty, itemPrice);
		return qty;
	}
	//the subtotal method that calculates the subtotal of each order
	public double subTotal(double qty, double itemprice) {
		 subTotal = qty*itemprice;
		System.out.println("subTotal: " +"$"+ subTotal);
		total += subTotal;
		return subTotal;
	}
	//finish method that ends the whole program
	public void finish() {
		System.out.println("................................................");
		System.out.println("................................................");
		System.out.println("Total:.............................. "+"$"+ total);
		System.out.println("thank you for your order.");
		System.out.println("____________________________________________________");
		String orderTotal = String.valueOf(total);
		orderList.add(orderTotal);//adding the total to the list as well
		Object[] obj = {orderList};//adding list to the object array 
		
		for(int i =0; i<obj.length; i++) {
			counter++;
			System.out.println("Order # " + counter );
			System.out.println(obj[i].toString());
		}
		System.out.println("____________________________________________________");
		
		MainMenu();
	}
	public String toString() {
		return foodType + " " + drinkType + " ";
	}
	
}
