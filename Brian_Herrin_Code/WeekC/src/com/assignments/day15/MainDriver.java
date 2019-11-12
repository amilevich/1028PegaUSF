package com.assignments.day15;

import java.util.Scanner;

public class MainDriver {
	/*
	 * Bonus: 
	 	* Store customers in a Queue and have them receive their food in the order they ordered 
	 	* Format/style your menu/console
	 
	 * Please push your project to your Github branch before Tuesday, November 12th,
	 * 9 am. You will be showcasing your application during 1-1s. I will be
	 * expecting to see a demo on how it works and a technical explanation of how
	 * you chose to structure your code.
	 */
	public static boolean isEqualToString(String input, String comparedTo) {
		return input.equals(comparedTo);
	}
	
	public static void main(String[] args) {
		// Interact with the user and gets user’s input with the Scanner Class 
		Scanner sc = new Scanner(System.in);
		CustomerQueue line = new CustomerQueue();
		System.out.println("Hello, welcome to Revature Café simulations!");
		System.out.println("How many customers will need to be simulated?:");
		//sc.next();
		String temp;
		Order tempOrder = new Order(); //ArrayList<Item>
		Integer tempInt = sc.nextInt();
		Customer newCustomer = new Customer();
		System.out.println(tempInt + "? Here we go anyway!");
		Menu menu = new Menu();
		for(int i = 0; i < tempInt; i++) {
			System.out.println("Hello, welcome to Revature Cafe!");
			System.out.println("Here is our menu: ");
			System.out.println(" a \"Meal Combos\"");
			System.out.println(" b \"Food\"");
			System.out.println(" c \"Drinks\"");
			System.out.println("Type the letter next to your chosen option: ");
			temp = sc.next();
			if(isEqualToString(temp, "a")) {
				System.out.println(" a " + menu.getFoodItems().get(0).getName() + " " + menu.getFoodItems().get(1).getName() + " " +  menu.getDrinkItems().get(0).getName());
				System.out.println(" b Hotdog + Fries + Soda");
				System.out.println(" c Chicken Nuggets + Fries + Soda");
				temp = sc.next();
				if(isEqualToString(temp, "a")) {
					tempOrder.getItemList().add(menu.getFoodItems().get(0));
				} else if(isEqualToString(temp, "b")) {
					tempOrder.getItemList().add(menu.getFoodItems().get(1));
				} else if(isEqualToString(temp, "c")) {
					tempOrder.getItemList().add(menu.getFoodItems().get(2));
				} else {
					System.out.println("Your input here should be either \"a\" \"b\" or \"c\"");
				}
			} else if(isEqualToString(temp, "b")) {
				System.out.println(" a Hamburger");
				System.out.println(" b Fries");
				System.out.println(" c Hotdog");
				System.out.println(" d Chicken Nuggets");
				temp = sc.next();
				if(isEqualToString(temp, "a")) {
					tempOrder.getItemList().add(menu.getFoodItems().get(0));
				} else if(isEqualToString(temp, "b")) {
					tempOrder.getItemList().add(menu.getFoodItems().get(1));
				} else if(isEqualToString(temp, "c")) {
					tempOrder.getItemList().add(menu.getFoodItems().get(2));
				} else if(isEqualToString(temp, "d")) {
					tempOrder.getItemList().add(menu.getFoodItems().get(3));
				} else {
					System.out.println("Your input here should be either \"a\" \"b\" or \"c\"");
				}
			} else if(isEqualToString(temp, "c")) {
				System.out.println(" a Soda");
				System.out.println(" b Sweet Tea");
				System.out.println(" c Coffee");
				temp = sc.next();
				if(isEqualToString(temp, "a")) {
					tempOrder.getItemList().add(menu.getDrinkItems().get(0));
				} else if(isEqualToString(temp, "b")) {
					tempOrder.getItemList().add(menu.getDrinkItems().get(1));
				} else if(isEqualToString(temp, "c")) {
					tempOrder.getItemList().add(menu.getDrinkItems().get(2));
				} else {
					System.out.println("Your input here should be either \"a\" \"b\" or \"c\"");
				}
			} else {
				System.out.println("Your input here should be either \"a\" \"b\" or \"c\"");
			}
			System.out.println("Finally, what name should we shout out to get you your order?");
			temp = sc.next();
			newCustomer = new Customer(temp, tempOrder);
			System.out.println(newCustomer.toString());
			line.addCustomer(newCustomer);
			System.out.println("Okay, it will be ready in a few minutes.");
			newCustomer = new Customer();
			tempOrder = new Order();
		}
		
		System.out.println("***preparing food noises***");
		// Now simulates the orders being fulfilled 
		while(line.getLine().peek() != null) {
			System.out.println(line.toStringHeadCustomerName() + ", your" + line.toStringHeadCustomerOrder() + " is ready!");
			line.getLine().poll();
		}
		
		sc.close();
	}

}
