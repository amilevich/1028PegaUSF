package com.examples.cafeapp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {
		
		boolean open = true;
		Queue<String> customerQueue = new LinkedList<>();
		Queue<String> orderQueue = new LinkedList<>();
		
		while(open) {
			open = work(customerQueue, orderQueue);
		}		
	}
	
	public static String getName() {
		Scanner sc = new Scanner(System.in);
		menu();
		System.out.println("Please input your name");
		return sc.nextLine();

	}
	public static String takeFoodOrder(String name) {
		Scanner sc = new Scanner(System.in);
		FoodOrder m = new FoodOrder(name);
		menu();
		System.out.println("Which meal from the list do you want? ");
		m.setMeal(sc.nextLine());
		System.out.println("");
		System.out.println("Thank you for placing your order! You will be attended soon.");
		System.out.println("");
		return m.toString();
	}
	public static String takeDrinkOrder(String name) {
		Scanner sc = new Scanner(System.in);
		DrinkOrder d = new DrinkOrder(name);
		menu();
		d.setName(name);
		System.out.println("Which drink from the list do you want? ");
		d.setDrink(sc.nextLine());
		System.out.println("");
		System.out.println("Thank you for placing your order! You will be attended soon.");
		System.out.println("");
		
		return d.toString();
	}

	public static void menu() {
		System.out.println("Welcome to Rocky's Hideout! Please check out our menu!");
		System.out.println("");
		System.out.println("*****************************************");
		System.out.println("                   Menu                  ");
		System.out.println("*****************************************");
		System.out.println("");
		System.out.print("Meals:                            Drinks:");
		System.out.println("");
		System.out.println("");
		System.out.print("Chicken sandwich                     Soda");
		System.out.println("");
		System.out.print("Hamburger                    Orange juice");
		System.out.println("");
		System.out.print("Pancakes                             Milk");
		System.out.println("");
		System.out.print("Waffles                     Hot chocolate");
		System.out.println("");
		System.out.print("Eggs and Bacon                      Coffe");
		System.out.println("");
		System.out.println("");
	}
	
	public static boolean work(Queue<String> customer, Queue<String> order) {
		Scanner sc = new Scanner(System.in);
		boolean i = true;
		
		System.out.println("Currently in the line: "+ customer.toString());
		System.out.println("Pending order: " + order.toString());
		System.out.println("");
		System.out.println("1. New customer arrives");
		System.out.println("2. Customer orders a meal");
		System.out.println("3. Customer orders a drink");
		System.out.println("4. Customer orders a combo");
		System.out.println("5. Order gets processed");
		System.out.println("6. Exit");
		System.out.println("");
		System.out.println("Please select a number from the list.");
		int menuSelect = sc.nextInt();
		
		switch (menuSelect) {
		case 1:
			customer.add(getName());
			break;
		case 2:
			order.add(takeFoodOrder(customer.peek()));
			customer.remove();
			break;
		case 3:
			order.add(takeDrinkOrder(customer.peek()));
			customer.remove();
			break;
		case 4:
			order.add(takeFoodOrder(customer.peek()));		
			order.add(takeDrinkOrder(customer.peek()));	
			customer.remove();		
			break;
		case 5:
			System.out.println(order.peek());		
			order.remove();
			break;
		case 6:
			i = false;
			System.out.println("Thank you for your time. Please come again soon!");
			break;
		}
		return i;
	}
}