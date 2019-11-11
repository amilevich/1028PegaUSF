package CafeApp;

import java.util.Scanner;

public class Menu {
	public double subTotal;
	public static double runningTotal;
	private static double itemPrice;
	static boolean ordering = true;
	static Scanner input = new Scanner(System.in);
	static double j = 0.0;

	public static void main(String[] args) {
		int menuOption;
		int foodItem = 0;
		input = new Scanner(System.in);
		double runningTotal = 0;
		while (ordering) {
			menu();
			menuOption = input.nextInt();
			switch (menuOption) {
			case 1:
				foodItem = 1;
				runningTotal += ItemPrice(foodItem);
				break;
			case 2:
				foodItem = 2;
				runningTotal += ItemPrice(foodItem);
				break;
			case 3:
				foodItem = 3;
				runningTotal += ItemPrice(foodItem);
				break;
			case 4:
				done(runningTotal);
				break;
			default:
				System.out.println("Invalid option.");
			}
		}
		System.out.println("Total amount due: $" + runningTotal);
	}

public static void menu() {
System.out.println("Welcome to CharDee MacDennis 2: Electric Boogaloo!");
System.out.println("Please choose what you would like to order \n1. Burger ($2.00) \n2. Fries ($1.50)\n3. Soda ($1.00) \n4. Exit");
}

	public static double ItemPrice(int foodItem) {
		if (foodItem == 1) {
			// burger= $2.00
			System.out.println("You've ordered a burger");
			itemPrice = 2.00;
		}
		if (foodItem == 2) {
			// fries = $1.50
			System.out.println("You've ordered fries");
			itemPrice = 1.50;
		}
		if (foodItem == 3) {
			// soda = $1.00
			System.out.println("You've ordered a soda");
			itemPrice = 1.00;
		}
		quantity();
		return j;
	}

	public static double quantity() {
		System.out.println("Enter quantity ");
		double quantity = input.nextDouble();
		subTotal(quantity, itemPrice);
		return quantity;
	}

	public static double subTotal(double quantity, double itemPrice) {
		double subTotal = quantity * itemPrice;
		System.out.println("Subtotal: $" + subTotal);
		j = subTotal;
		return subTotal;
	}

	public static void done(double runningTotal) {
		ordering = false;
		System.out.println("Enjoy your meal!");
	}
}