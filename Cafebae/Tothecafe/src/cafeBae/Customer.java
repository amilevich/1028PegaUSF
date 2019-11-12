package cafeBae;

import java.util.LinkedList;
import java.util.Queue;

public class Customer extends Food {

	public static void custy() {

		Queue<Integer> hd = new LinkedList<Integer>();
		for (int i = 1; i < 4; i++) { // queue for customer
			while (true) {
				Food.menu();// calling menu method
				System.out.println("this many items are ordered " + Food.size);
				if (Food.size > 0) {

					hd.add(i);// add to the queue
					System.out.println("customer number is " + i);// printing customer number
					System.out.println("Customer Queue: " + hd.size());// printing customer number
					break;
				} else {
					System.out.println("No order next customer");
					System.out.println("Customer Queue: " + hd.size());// printing customer number

				}

			}

			
		}
		custy();// recursion
	}
}
