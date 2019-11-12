package com.cafe.app;

import java.util.Scanner;

public class DrinkOrder {

	private int size;
	private int drinkOrder;
	public static final boolean validInput = false;
	public static Scanner cdo = new Scanner(System.in);
	FoodOrder fd = new FoodOrder();
	public static int flagFood = 0;

	// Getters and setters

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getDrinkOrder() {
		return drinkOrder;
	}

	public void setDrinkOrder(int drinkOrder) {
		this.drinkOrder = drinkOrder;
	}

	@Override
	public String toString() {
		return "Your drink order of " + drinkOrder + " in size " + size + " is ready.";
	}

	public void cusDrinkOrder() {
		int temp;
		System.out.println("Welcome to the cafe.  Here are your drink options: ");
		System.out.println("1 Hot Coffee");
		System.out.println("2 Iced coffee");
		System.out.print("What would you like today: ");
		while (!validInput) {
			int flag2 = 0;
			temp = cdo.nextInt();
			switch (temp) {
			// Hot Coffee
			case 1:
				setDrinkOrder(temp);
				// set drink size
				setSize(drinkSize());
				if (flagFood == 1) {
					fd.cusFoodOrder();
					flagFood = 0;
				}
				break;
			// Iced coffee
			case 2:
				setDrinkOrder(temp);
				//set drink size
				setSize(drinkSize());
				if (flagFood == 1) {
					fd.cusFoodOrder();
					flagFood = 0;
				}
				break;
			default:
				System.out.print("Please give a valid drink: ");
				break;
			}
			if (flag2 == 0) {
				break;
			}
		}
	}

	private static int drinkSize() {
		int temp2;
		int temp3;
		System.out.println("Please select a drink size for your coffee.  Here are the following options: ");
		System.out.println("1 Small");
		 System.out.println("2 Medium");
		 System.out.println("3 Large");
		System.out.print("What size would you like today: ");
		temp2 = cdo.nextInt();
		while (!validInput) {
			int flag = 0;
			switch (temp2) {
			// Small
			case 1:
				System.out.println("Thank you.  Your order will be out shortly.");
				System.out.print("Would you like to order food?  Please enter 1 for yes and 2 for no: ");
				while (!validInput) {
					temp3 = cdo.nextInt();
					switch (temp3) {
					case 1:
						flagFood = 1;
						break;
					case 2:
						System.out.println("Okay.  Please wait for your drink.");
						break;
					default:
						System.out.print("Please enter 1 for yes or 2 for no: ");
						flag = 1;
						break;
					}
					break;
				}break;
				
			//Medium	
			case 2:
				System.out.println("Thank you.  Your order will be out shortly.");
				System.out.print("Would you like to order food?  Please enter 1 for yes and 2 for no: ");
				while (!validInput) {
					temp3 = cdo.nextInt();
					switch (temp3) {
					case 1:
						flagFood = 1;
						break;
					case 2:
						System.out.println("Okay.  Please wait for your drink.");
						break;
					default:
						System.out.print("Please enter 1 for yes or 2 for no: ");
						flag = 1;
						break;
					}break;
				}break;
			
			//Large
			case 3:
				System.out.println("Thank you.  Your order will be out shortly.");
				System.out.print("Would you like to order food?  Please enter 1 for yes and 2 for no: ");
				while (!validInput) {
					temp3 = cdo.nextInt();
					switch (temp3) {
					case 1:
						flagFood = 1;
						break;
					case 2:
						System.out.println("Okay.  Please wait for your drink.");
						break;
					default:
						System.out.print("Please enter 1 for yes or 2 for no: ");
						flag = 1;
						break;
					}break;
				}break;
			default:
				System.out.print("Please give a valid drink size: ");
				break;
			}
			if (flag == 0) {
				break;
			}
		}
		return temp2;
	}
}