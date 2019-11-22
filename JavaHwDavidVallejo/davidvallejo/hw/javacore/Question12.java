package davidvallejo.hw.javacore;

import java.util.ArrayList;

/*
 * 
 * Question 12: Write a program to store numbers from 1 to 100 in an array. Print out all the
 * even numbers from the array. Use the enhanced FOR loop for printing out the
 * numbers.
 * 
 */
public class Question12 {
	public static void main(String[] args) {

		ArrayList<Integer> test = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			test.add(i + 1);
		}
		Object[] num = test.toArray();
		printEven(num);

	}

	public static void printEven(Object[] num) {
		for (Object i : num) {
			int temp = (int) i;
			if ((temp % 2) == 0) {
				System.out.println(i);
			}

		}
	}
}
