package com.example.cafe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainDriver {

	public static Scanner sc = new Scanner(System.in);
	public static String yn;

	public static void main(String[] args) {
		Queue<Customer> cl = new LinkedList<Customer>();
		int customerNum = 1;
		int customerCalled = 0;
		while (true) {
			if (customerNum == 101) { // after 100 customers start over customer numbering
				customerNum = 1;
			}
			if (customerCalled == 2) { // call out order ready for customers after every 2
				System.out.println("---------------------------------");
				System.out.println("Order Ready for number " + cl.peek().getNum() + ", " + cl.peek().getName());
				while (!cl.peek().drinks.isEmpty()) {
					System.out.print(cl.peek().drinks.peek().toString() + " ");
					cl.peek().drinks.pop();
				}
				System.out.println();
				while (!cl.peek().foods.isEmpty()) {
					System.out.print(cl.peek().foods.peek().toString() + " ");
					cl.peek().foods.pop();
				}
				System.out.println();
				System.out.println("Enjoy your order!");
				cl.remove();
				customerCalled = 0;
			} else { // ask customer what they want to do
				System.out.println("---------------------------------");
				System.out.println("Hello, welcome to Cafe Revature");
				System.out.println("Would you like to order?");
				System.out.println("Enter 1: Yes or 2: No");
				checkYN();
				if (yn.equals("1")) {
					Customer c = new Customer();
					if ((c.drinks.isEmpty()) && (c.foods.isEmpty())) { // if customer decided not to order anything
																		// anymore
						System.out.println(
								"You chose not to order. If you wish to make an order please get in line again.");
						continue;
					}
					c.setNum(customerNum);
					System.out.println("Please enter your name for the order");
					c.setName(sc.nextLine());
					cl.add(c);
					System.out.println("Your food order was: " + c.foods);
					System.out.println("Your drink order was: " + c.drinks);
					System.out.println("Thank you for your order " + c.getName() + ". Your number is " + customerNum);
					System.out.println("Your name and number will be called after 1-2 customers");
					customerNum++;
					customerCalled++;
				} else { // customer does not want to order anymore
					System.out
							.println("You chose not to order. If you wish to make an order please get in line again.");
					continue;
				}
			}
		}
	}

	private static void checkYN() {
		while (true) {
			yn = sc.nextLine();
			if (yn.equals("1") || yn.equals("2")) {
				break;
			} else {
				System.out.println("Invalid. Please enter 1 or 2");
			}
		}
	}

}
