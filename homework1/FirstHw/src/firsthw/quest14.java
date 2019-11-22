package firsthw;

import java.util.Date;
import java.util.Scanner;

public class quest14 {
	public static void main(String[] args) {

		Scanner fk = new Scanner(System.in);
		boolean exit = false;

		do {
			System.out.println(
					"Enter 1 for square root\n Enter 2 for todays day\nEnter 3 to learn core java\n Enter 4 to exit\n");
			int choice = fk.nextInt();
			fk.nextLine();

			switch (choice) {
			case 1:
				sqrt();
				break;
			case 2: 
				date();
				break;
			case 3: 
				splitString();
				break;
			case 4: 
				exit = true;
				break;
			default:

				break;
			}
		} while (!exit);
	}

	private static void splitString() {
		String input = "I am learning core java.";
		String arr[] = { "", "", "", "", "" };
		int count = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				count++;
			} else {
				arr[count] += input.charAt(i);
			}
		}

		System.out.println("the split string is: ");
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}

	}

	private static void date() {
		Date date = new Date();
		System.out.println("today's date is: " + date);
	}

	public static void sqrt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		double num = sc.nextInt();
		sc.nextLine();

		System.out.println("square root is: " + Math.sqrt(num));

	}

}
