package cafeBae;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Food {

	public static int size;

	public static void menu() {
		int temp = 0;
		boolean ordering = true;
		{

			BigAle sprite = new BigAle("Sprite", 2, "lg", true);// menu items
			BigAle Donuts = new BigAle("Donuts", 3, "sm", false);
			BigAle Fruit = new BigAle("Fruit", 5, "med", false);

			System.out.println("\nHello what would u like to eat?");

			Queue<BigAle> m = new LinkedList<BigAle>();
			do {
				System.out.println("enter 1 for Sprite ");
				System.out.println("enter 2 for Donuts ");
				System.out.println("enter 3 for Fruit");
				System.out.println("enter 0 when Done");

				Scanner Fd = new Scanner(System.in);
				String cus = Fd.nextLine();
				switch (cus) {// menu
				case "1":
					System.out.println("added sprite");
					m.add(sprite);// add to queue
					temp += sprite.price;
					System.out.println("Queue: " + m);
					break;

				case "2":
					m.add(Donuts);
					temp += Donuts.price;
					System.out.println("added donut");
					System.out.println("Queue: " + m);
					break;

				case "3":
					m.add(Fruit);
					temp += Fruit.price;
					System.out.println("added fruit");
					System.out.println("Queue: " + m);
					break;

				case "0":
					System.out.println("\nyour order is " + m);
					size = m.size();
					System.out.println("your order total is $" + temp);

					ordering = false;// ending loop/order

					break;

				default:
					System.out.println("order not found");
					break;
				}
				if (cus != "0") {
					System.out.println("anything else?");

				}
			} while (ordering);

		}
	}
}
