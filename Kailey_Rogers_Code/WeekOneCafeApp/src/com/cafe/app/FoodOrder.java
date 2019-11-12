package com.cafe.app;

import java.util.Scanner;

public class FoodOrder {

	private int foodOrder;
	public static final boolean validInput = false;

	// Getters and Setters
	public int getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(int foodOrder) {
		this.foodOrder = foodOrder;
	}
	
	
	@Override
	public String toString() {
		return "Your food order of " + foodOrder + " is ready.";
	}


	public void cusFoodOrder() {
		Scanner cfo = new Scanner(System.in);
		int temp;
		System.out.println("Here are our food options: ");
		System.out.println("1 Cake Pop");
		System.out.println("2 Lemon Pound Cake");
		System.out.println("3 Pumpkin Pound Cake");
		System.out.println("4 Chocolate Chip Cookie");

		System.out.print("What food would you like today: ");
		while (!validInput) {
			temp = cfo.nextInt();
			switch (temp) {
			case 1:
				System.out.println("Perfect.  Your drink plus your cake pop will be out shortly.");
				setFoodOrder(temp);
				break;
			case 2:
				System.out.println("Perfect.  Your drink plus your lemon pound cake will be out shortly.");
				setFoodOrder(temp);
				break;
			case 3:
				System.out.println("Perfect.  Your drink plus your pumpkin pound cake will be out shortly.");
				setFoodOrder(temp);
				break;
			case 4:
				System.out.println("Perfect.  Your drink plus your chocolate chip cookies will be out shortly.");
				setFoodOrder(temp);
				break;
			default:
				System.out.println("Please give me an actual food we sell here.");
				break;
			}break;
		}
	}
}
