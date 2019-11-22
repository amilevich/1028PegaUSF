package homework1;


import java.util.Date;
import java.util.Scanner;

public class SwitchStatemen {
	
	public void switchStatement() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose Please:");
		System.out.println("1. find square root");
		System.out.println("2. Display Date");
		System.out.println("3. Split a string");

		int option;
		System.out.println("Choose please");
		option=scanner.nextInt();
		int number;
		switch(option) {
		case 1:
			System.out.println("enter a number please: ");
			number = scanner.nextInt();
			
			
			int a =(int) Math.sqrt(number);
			
			System.out.println("The Squareroot of " + number + " is " + a);
			System.out.println();
			break;
			
		case 2:
			System.out.println("today's date is: ");
			Date l = new Date();
			System.out.println(l);
			
			break;
			
		case 3:
			String s = "I am learning Core Java";
			String[] array=s.split(" ");
			for(int i = 0; i<array.length; i++) {
				System.out.println(array[i]);
				
			}
			
			
			break;
			
		}
	}

}
