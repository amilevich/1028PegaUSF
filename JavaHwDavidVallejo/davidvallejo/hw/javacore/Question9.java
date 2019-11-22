package davidvallejo.hw.javacore;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 
 * Question 9: 
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the
 * prime numbers to the console.
 * ==================================================================
 * 
 */
public class Question9 {
	public static void main(String[] args) {

		ArrayList<Integer> thePrimeInteger = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			thePrimeInteger.add(i + 1);
		}
		primePrinter(thePrimeInteger);

	}

	public static void primePrinter(ArrayList<Integer> n) {
/*Iterating through the array and finding the prime intergers*/
		Iterator<Integer> p = n.iterator();
		while (p.hasNext()) {
			int les = p.next();
			if ((les == 2) || (les == 3) || (les == 5) || (les == 7) && (les != 1)) {
				System.out.println(les);
			} else if (((les % 2) != 0) && ((les % 3) != 0) && ((les % 5) != 0) && ((les % 7) != 0)
					&& (les != 1)) {
				System.out.println(les);
			}
		}

	}

}
