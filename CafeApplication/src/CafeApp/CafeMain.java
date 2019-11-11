package CafeApp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CafeMain {

	public static void main(String[] args) {

		boolean ordering = true;
		while (ordering) {

			System.out.println("Welcome to CharDee MacDennis 2: Electirc Bugaloo! Please select what you would like!");
			System.out.println("1 Drinks");
			System.out.println("2 Food");
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();

			Queue<FoodOrder> queue = new LinkedList<FoodOrder>();
			try {
				int ordernumber = Integer.parseInt(name);
				if (ordernumber == 1) {
					System.out.println("1 - Sprite - $1.00");
					System.out.println("2 - Coke - $1.00");
					System.out.println("3 - Tea - $1.50");
					System.out.println("4 - Beer - $3.00");
					int value = scan.nextInt();

					FoodOrder order = null;
					if (value == 1)
						order = new FoodOrder("Sprite", 1.00);
					else if (value == 2)
						order = new FoodOrder("Coke", 1.00);
					else if (value == 3)
						order = new FoodOrder("Tea", 1.50);
					else if (value == 4)
						order = new FoodOrder("Beer", 3.00);
					else {
						System.out.println("Please enter a correct choice.");
						return;
					}
					queue.add(order);
				} else if (ordernumber == 2) {
					System.out.println("1 - Burger - $3.50");
					System.out.println("2 - Chicken Sandwich - $3.00");
					System.out.println("3 - Tacos - $4.50");
					System.out.println("4 - Salad - $3.00");
					int value = scan.nextInt();
					FoodOrder order = null;
					if (value == 1)
						order = new FoodOrder("Burger", 3.50);
					else if (value == 2)
						order = new FoodOrder("Chicken Sandwich", 3.00);
					else if (value == 3)
						order = new FoodOrder("Tacos", 4.50);
					else if (value == 4)
						order = new FoodOrder("Salad", 3.00);
					else {
						System.out.println("Please enter a correct choice.");
						return;
					}
					queue.add(order);
				}
				for (FoodOrder i : queue) {

					System.out.println("Current Queue: " + i.foodName +" $"+ i.foodCost);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
