package com.frontend;
import com.kitchen.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MainDriver {
	
	public static List<MenuItem> createMenu() {
		List<MenuItem> listOfFood = new ArrayList<MenuItem>();
		MenuItem coffee = new Drink("coffee", 1);
		MenuItem tea = new Drink("tea", 1);
		MenuItem croissant = new Food("croissant", 1);
		MenuItem muffin = new Food("muffin", 1);
		MenuItem staleBread = new Food("staleBread", 1);
		MenuItem orangeJuice = new Drink("orange juice", 1);
		MenuItem appleJuice = new Drink("apple juice", 1);

		listOfFood.add(coffee);
		listOfFood.add(tea);
		listOfFood.add(croissant);
		listOfFood.add(muffin);
		listOfFood.add(staleBread);
		listOfFood.add(orangeJuice);
		listOfFood.add(appleJuice);

		return listOfFood;
	}

	public static void outputMenu(List<MenuItem> menu) {
		int j = 0;
		for (MenuItem i : menu) {
			System.out.println("[" + j + "]" + i.getName() + "(" + "£" + i.getPrice() + ")");
			j++;
		}
	}

	public static void outputOrder(List<MenuItem> foods) {
		// System.out.println("You're order:");
		double sum = 0;
		System.out.println("Your current order is: ");
		for (MenuItem i : foods) {
			System.out.print(i.getName() + " ");
			sum += i.getPrice();
		}
		System.out.println(" ");
		System.out.println("The subtotal price comes to: " + sum);
		System.out.println("");
	}

	public static void outputFinalOrder(List<MenuItem> foods) {
		double sum = 0;
		for (MenuItem i : foods) {
			System.out.print(i.getName() + " ");
			sum += i.getPrice();
		}
		System.out.println("");
		System.out.println("The total price comes to: " + sum);
		System.out.println("\n");
	}

	public static List<MenuItem> takeOrder(Scanner in, List<MenuItem> customerOrder, List<MenuItem> foodList) {
		System.out.println("What would you like to add to your order?");
		int food = in.nextInt();
		switch (food) {
		case 0:
			customerOrder.add(foodList.get(food));
			break;
		case 1:
			customerOrder.add(foodList.get(food));
			break;
		case 2:
			customerOrder.add(foodList.get(food));
			break;
		case 3:
			customerOrder.add(foodList.get(food));
			break;
		case 4:
			customerOrder.add(foodList.get(food));
			break;
		case 5:
			customerOrder.add(foodList.get(food));
			break;
		case 6:
			customerOrder.add(foodList.get(food));
			break;
		}

		String input = in.nextLine();
		if (input.equals("no")) {
			return customerOrder;
		} else if (input.equals("yes")) {
			customerOrder = takeOrder(in, customerOrder, foodList);
		}

		return customerOrder;
	}

	public static void finalOrders(Queue<List<MenuItem>> customerOrders) {
		System.out.println("\n");
		System.out.println("All orders have been completed");
		
		int k = 1;
		for (List<MenuItem> j : customerOrders) {
			System.out.println("Customer " + k + ", your order has been completed:");
			System.out.println("Your order consists of:");
			outputFinalOrder(j);
			k++;
		}

	}

	public static void orderingFood(List<MenuItem> customerOrder, Scanner in) {
		boolean ordering = true;
		while (ordering) {

			takeOrder(in, customerOrder, foodItems);

			outputOrder(customerOrder);
			System.out.println("\n" + "Would you like to add anything else to your order?");
			String input = in.nextLine();
			if (input.equals("no")) {
				ordering = false;
			}

		}
		customerOrders.add(customerOrder);
		System.out.println("Are you the last person in the queue?");
		String lastPerson = in.nextLine();
		if (lastPerson.equals("yes")) {
			System.out.println("Congratulations for being the last.");
			System.out.println("You get the prize of being last.");
			customerOrdering = false;

		} else if (lastPerson.equals("no")) {
			System.out.println("Then stop screwing around and send the next person forward.");
			System.out.println("\n");
		}
	}

	static boolean customerOrdering = true;
	static List<MenuItem> foodItems = createMenu();
	static Queue<List<MenuItem>> customerOrders = new LinkedList<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Hi, welcome to my definitley not evil cafe. Here's our menu:");
		while (customerOrdering) {
			List<MenuItem> customerOrder = new ArrayList<>();
			outputMenu(foodItems);
			orderingFood(customerOrder, in);
		}
		finalOrders(customerOrders);
	}
}
	
	

