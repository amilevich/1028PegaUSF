package davidvallejo.hw.javacore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 
 * Question 14: Write a program that demonstrates the switch case. Implement the
 * following functionalities in the cases:
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today’s date.
 * Case 3: Split the following string and store it in a string array.
 * 
 * “I am learning Core Java”
 * 
 */
public class Question14 {
	public static void main(String[] args) {

		int chx = 3;
		while (chx > 0) {
			System.out.println("Showing case: " + chx);
			switch (chx) {
			case 1:
				int n = 25;
				System.out.println(Math.sqrt(n));
				break;
			case 2:
				DateFormat dateForm = new SimpleDateFormat("MM/dd/yyy");
				Date date = new Date();
				System.out.println(dateForm.format(date));
				break;
			case 3:
				String str = "I am learning Core Java";
				String arr[] = str.split(" ");
				for(String i : arr) {
					System.out.println(i);
				}
				break;
			}
			chx--;
			System.out.println("---------------------");
		}
	}

}
