package com.example.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.example.main.Food;
import com.example.main.Drink;

public class OrderScreen {

	// Create a queue of linked list type to store Order objects and
	// gain the built in methods of a linked list
	static Queue<Order> orderList = new LinkedList<Order>();

	// Create an array list to store food name, price, and description
	static ArrayList<Food> foodList = new ArrayList<Food>();
	// Create food objects for all the food on the menu
	static Food hamAndCheeseSandwich = new Food("Ham And Cheese Sandwich", 5);
	static Food baconLettuceTomato = new Food("Bacon Lettuce Tomato Sandwich", 7);
	static Food sausageEggEndCheese = new Food("Sausage Egg and Cheese Sandwich", 4);
	static Food grilledCheeseSandwich = new Food("Grilled Cheese Sandwich", 3);
	static Food clubSandwich = new Food("Club Sandwich", 6);

	// Create an array list to store drink type and price
	static ArrayList<Drink> drinkList = new ArrayList<Drink>();
	// Create drink objects for all the drinks on the menu
	static Drink coffee = new Drink("Coffee", 1);
	static Drink decafeCoffee = new Drink("Decafe Coffee", 1);
	static Drink espresso = new Drink("Espresso", 2);
	static Drink latte = new Drink("Latte", 3);
	static Drink cappuccino = new Drink("Cappacciuno", 3);
	static Drink tea = new Drink("Tea", 1);
	static Drink orangeJuice = new Drink("Orange Juice", 1);
	static Drink appleJuice = new Drink("Apple Juice", 1);
	static Drink water = new Drink("Water", 0);

	// Sum for drink price and food price
	static int drinkPriceSum = 0;
	static int foodPriceSum = 0;

	/*
	 * This method controls the functionality of the entire program from start to
	 * finish
	 */
	public static void getOrder() {
		System.out.println("Hello, Welcome to David's Cafe!");
		// Import scanner
		Scanner sc = new Scanner(System.in);

		// Create a while loop to loop through menu options while the current customer is creating
		// Their order. ordeComplete comes from whether the current customer would like to continue
		// adding items to their order
		String orderComplete = "y";
		while (orderComplete.equals("y")) {
			//Print menu options for drink and food
			System.out.println("What would you like to order today?\n" + "1 Drink\n" + "2 Food\n");

			// Collect menu choice
			int menuChoice = sc.nextInt();

			// Switch to correct menu from menu choice
			switch (menuChoice) {
			case 1:
				// Print a list of drinks on the menu
				System.out.println("What would you like to drink today?\n" + "1 Coffee;\r\n" + "2 Decafe Coffee;\r\n"
						+ "3 Espresso;\r\n" + "4 Latte;\r\n" + "5 Cappuccino;\r\n" + "6 Tea;\r\n" + "7 OrangeJuice;\r\n"
						+ "8 AppleJuice;\r\n" + "9 Water");
				// Get drink choice and switch to corresponding case
				// Logic for switch statement
				// If customer chooses 5 switch to that case then add the Drink object to the
				// drinksList ArrayList
				int drinkChoice = sc.nextInt();
				switch (drinkChoice) {
				case 1:
					System.out.println(coffee);
					drinkList.add(coffee);
					break;
				case 2:
					System.out.println(decafeCoffee);
					drinkList.add(decafeCoffee);
					break;
				case 3:
					System.out.println(espresso);
					drinkList.add(espresso);
					break;
				case 4:
					System.out.println(latte);
					drinkList.add(latte);
					break;
				case 5:
					System.out.println(cappuccino);
					drinkList.add(cappuccino);
					break;
				case 6:
					System.out.println(tea);
					drinkList.add(tea);
					break;
				case 7:
					System.out.println(orangeJuice);
					drinkList.add(orangeJuice);
					break;
				case 8:
					System.out.println(appleJuice);
					drinkList.add(appleJuice);
					break;
				case 9:
					System.out.println(water);
					drinkList.add(water);
					break;
				}
				// Print the drink choice so the user can see what they ordered
				System.out.println(drinkList);
				break;
			case 2:
				// Print food menu
				System.out.println("What would you like to eat today?\n" + "1 Ham And CheeseSandwich\r\n"
						+ "2 Bacon Lettuce Tomato\r\n" + "3 Sausage Egg And CheeseSandwich\r\n"
						+ "4 Grilled Cheese Sandwich\r\n" + "5 Club Sandwich\r\n");
				// Get food item choice
				int foodChoice = sc.nextInt();
				// Logic for switch statement
				//  Switch to that food choice then add the Food object to the
				// foodList ArrayList
				switch (foodChoice) {
				case 1:
					System.out.println(hamAndCheeseSandwich);
					foodList.add(hamAndCheeseSandwich);
					break;
				case 2:
					System.out.println(baconLettuceTomato);
					foodList.add(baconLettuceTomato);
					break;
				case 3:
					System.out.println(sausageEggEndCheese);
					foodList.add(sausageEggEndCheese);
					break;
				case 4:
					System.out.println(grilledCheeseSandwich);
					foodList.add(grilledCheeseSandwich);
					break;
				case 5:
					System.out.println(clubSandwich);
					foodList.add(clubSandwich);
					break;
				}
				break;
			}

			// Ask if the customer would like to add anything else to their order
			// y for will iterate the while loop again
			// n will satisfy condition of while loop and continue the program
			System.out.println("Would you like to add more items? (y = yes & n = no)");
			orderComplete = sc.next().toLowerCase();
		}

		// Get customer name for the order
		System.out.println("May I get the name for the order?");
		String customerName = sc.next();
		
		//Loop through each item in drinks list and sum them
		for (Drink drink : drinkList) {
			drinkPriceSum += drink.getDrinkPrice();
		}
		//Loop through each item food list and sum them
		for (Food food : foodList) {
			foodPriceSum += food.getFoodPrice();
		}

		//Combine the sum of food and drinks to get order total
		int orderTotal = (drinkPriceSum + foodPriceSum);
		
		// Create a new order object for the current customer
		Order currentOrder = new Order(customerName, drinkList, foodList, orderTotal);
		// Print the customer object so user can see their full order
		System.out.println(currentOrder);
		// Add the current order to the LinkedList
		orderList.add(currentOrder);
		// Check if the line is empty
		System.out.println("Is there anyone else in line? (y = yes & n = no)");
		String isLineEmpty = sc.next().toLowerCase();

		// If line is empty  print the linked list with each order
		switch (isLineEmpty) {
		case "n":
			// Loop through the linked list and print it
			for (Order s : orderList) {
				String output = s.toString();
				System.out.println(output);
			} 
			// Close scanner
			sc.close();
			break;
		// If there are people in line call the getOrder method recursively and add more orders
		// to the LinkedList
		case "y":
			drinkList = new ArrayList<Drink>();
			foodList = new ArrayList<Food>();
			orderTotal = 0;
			foodPriceSum = 0;
			drinkPriceSum = 0;
			getOrder();
		}
	}

}
