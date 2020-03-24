package com.example.core;
//DONE
/*
 * Create an ArrayList and insert integers 1 through 10. 
 * Display the ArrayList. Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result.
 * Remove the prime numbers from the ArrayList and 
 * print out the remaining ArrayList.
 */
import java.util.ArrayList;
import java.util.ListIterator;

public class Q19 {

	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static ArrayList<Integer> evenArr = new ArrayList<Integer>();
	public static ArrayList<Integer> oddArr = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// add 1-10
		for (int i = 0; i < 10; i++) {
			arr.add(i + 1);
		}
		System.out.println("Original array: " + arr);

		// take out even and print
		even(arr);

		// take out odd and print
		odd(arr);

		// take out prime and print
		prime(arr);
	}

	public static void even(ArrayList<Integer> e) {
		ListIterator<Integer> ev = e.listIterator();
		while (ev.hasNext()) {
			int temp = ev.next();
			if ((temp % 2) == 0) {
				evenArr.add(temp);
			}
		}
		System.out.println("Even numbers in array: " + evenArr);
	}

	public static void odd(ArrayList<Integer> e) {
		ListIterator<Integer> od = e.listIterator();
		while (od.hasNext()) {
			int temp = od.next();
			if ((temp % 2) != 0) {
				oddArr.add(temp);
			}
		}
		System.out.println("Odd numbers in array: " + oddArr);
	}

	public static void prime(ArrayList<Integer> e) {
		ListIterator<Integer> pr = e.listIterator();
			while (pr.hasNext()) {
			int temp = pr.next();
			if ((temp == 2) || (temp == 3) || (temp == 5) || (temp == 7) && (temp != 1)) {
				pr.remove();
			} else if (((temp % 2) != 0) && ((temp % 3) != 0) && ((temp % 5) != 0) && ((temp % 7) != 0)
					&& (temp != 1)) {
				pr.remove();
			}
		}
		System.out.println("Non - Prime numbers in array: " + arr);
	}

}
