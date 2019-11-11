package com.example.main;

import java.util.ArrayList;
import java.util.Scanner;
import com.example.main.Food;

public class OrderScreen {
	
	// Create an array list to store food name, price, and description
	ArrayList<Food> foodList = new ArrayList<Food>();
	
	Food hamAndCheeseSandwich = new Food("Ham And Cheese Sandwich", 5, "Classic ham and cheese sandwich on american bread");
	Food baconLettuceTomato = new Food("Bacon Lettuce Tomato Sandwich", 7, "Classic BLT sandwich served on wheat bread");
	Food sausageEggEndCheese = new Food("Sausage Egg and Cheese Sandwich", 4, "Sausage egg and cheese sandwich served on a english muffin");
	Food grilledCheeseSandwich = new Food("Grilled Cheese Sandwich", 3, "Childhood classic grilled cheese beefed up with three mystery cheeses served on white bread.");
	Food clubSandwich = new Food("Club Sandwich", 6, "Fan favorite club sandwich with the addition of bacon served as a triple decker");	
	
	// Create an array list to store drink type and price
	ArrayList<Drink> drinkList = new ArrayList<Drink>();
	
	Drink coffee = new Drink("Coffee", 1);
	Drink decafeCoffee = new Drink("Decafe Coffee", 1);
	Drink espresso = new Drink("Espresso", 2);
	Drink latte = new Drink("Latte", 3);
	Drink cappuccino = new Drink("Cappacciuno", 3);
	Drink tea = new Drink("Tea", 1);
	Drink orangeJuice = new Drink("Orange Juice", 1);
	Drink appleJuice = new Drink("Apple Juice", 1);
	Drink water = new Drink("Water", 0);
	
	/*
	 * This method controls the functionality of the entire program from start to finish
	 */
	public static void getOrder() {
		System.out.println("Hello, Welcome to David's Cafe!");
		Scanner sc = new Scanner(System.in);
		
		String orderComplete = "y";
		while(orderComplete == "y") {
			System.out.println("What would you like to order today?\n"
					+ "1 Drink\n"
					+ "2 Food\n");
			
			int orderChoice = sc.nextInt();
			
			switch(orderChoice) {
			case 1:
				System.out.println("What would you like to drink today?\n"+
						"1 Coffee;\r\n" + 
						"2 Decafe Coffee;\r\n" + 
						"3 Espresso;\r\n" + 
						"4 Latte;\r\n" + 
						"5 Cappuccino;\r\n" + 
						"6 Machiato;\r\n" + 
						"7 Tea;\r\n" + 
						"8 OrangeJuice;\r\n" + 
						"9 AppleJuice;\r\n" + 
						"10 CranberryJuice;\r\n" + 
						"11 Water");
				@SuppressWarnings("unused") int foodChoice = sc.nextInt();
						break;
			case 2:
				System.out.println("What would you like to eat today?\n"+
						"1 Ham And CheeseSandwich\r\n" + 
						"2 Bacon Lettuce Tomato\r\n" + 
						"3 Sausage Egg And CheeseSandwich\r\n" + 
						"4 Grilled Cheese Sandwich\r\n" + 
						"5 Club Sandwich\r\n" + 
						"6 Cuban Sandich\r\n" + 
						"7 Gyro\r\n" + 
						"8 French Fries\r\n" + 
						"9 Potato Chips\r\n" + 
						"10 Potato Salad\r\n" + 
						"11 Side Salad\r\n" + 
						"12 Macaroni Salad");
				@SuppressWarnings("unused") int drinkChoice = sc.nextInt();
						break;
			}
			
			System.out.println("Would you like to add more items? (y = yes & n = no)");
			orderComplete = sc.next().toLowerCase();
		}
		System.out.println("Is there anyone else in line?");
		String isLineEmpty = sc.next().toLowerCase();
		
		switch(isLineEmpty){
		case "y":
			//Add complete order and print queue
		case "n":
			getOrder();
		}
	}

}
