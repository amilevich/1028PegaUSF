package davidvallejo.hw.javacore;

import java.util.ArrayList;
import java.util.ListIterator;

/*
 * 
 * Question 19: Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
 * Add all the even numbers up and display the result. Add all the odd numbers up
 * and display the result. Remove the prime numbers from the ArrayList and print
 * out the remaining ArrayList.
 * 
 */
public class Question19 {
	public static ArrayList<Integer> allNumArray = new ArrayList<Integer>();
	public static ArrayList<Integer> allEvenArray = new ArrayList<Integer>();
	public static ArrayList<Integer> allOddsArray = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// add 1-10
		for (int i = 0; i < 10; i++) {
			allNumArray.add(i + 1);
		}
		System.out.println("Original array: " + allNumArray);

		
		even(allNumArray);//printing the even array

		
		odd(allNumArray);//printing the odd variables

		
		prime(allNumArray);//taking the prime variable out of the array and printing
	}

	public static void even(ArrayList<Integer> e) {
		ListIterator<Integer> evenVar = e.listIterator();
		while (evenVar.hasNext()) {
			int temp = evenVar.next();
			if ((temp % 2) == 0) {
				allEvenArray.add(temp);
			}
		}
		System.out.println("Even numbers in array: " + allEvenArray);
	}

	public static void odd(ArrayList<Integer> e) {
		ListIterator<Integer> od = e.listIterator();
		while (od.hasNext()) {
			int temp = od.next();
			if ((temp % 2) != 0) {
				allOddsArray.add(temp);
			}
		}
		System.out.println("Odd numbers in array: " + allOddsArray);
	}

	public static void prime(ArrayList<Integer> e) {
		ListIterator<Integer> pr = e.listIterator();
			while (pr.hasNext()) {
			int temp = pr.next();
			if ((temp == 2) || (temp == 3) || (temp == 5) || (temp == 7) && (temp != 1)) {
				pr.remove();//removing the prime numbers out of the array list
			} else if (((temp % 2) != 0) && ((temp % 3) != 0) && ((temp % 5) != 0) && ((temp % 7) != 0)
					&& (temp != 1)) {
				pr.remove();
			}
		}
		System.out.println("These are the non prime numbers in the array: " + allNumArray);
	}
}
