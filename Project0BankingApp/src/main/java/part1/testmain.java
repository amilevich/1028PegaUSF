package part1;

import java.util.Scanner;

public class testmain {

	public static void main(String[] args) {
		
		Client c = new Client();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first name: ");
		String f = sc.nextLine();
		System.out.println("Enter the last name: ");
		String l = sc.nextLine();
		c.setName(f, l);
		
		int count = 0;
		sc = new Scanner(System.in);
		System.out.println("What month were you born in? (1-12)");
		int m = sc.nextInt();

		
		while (m<1 || m>12) {
			count++;
			if (count>=3) {
				System.out.println("Number of tries exceeded."); 
				break;}
			System.out.println("Incorrect input, please try again.");
			System.out.println("What month were you born in? (1-12)");
			m = sc.nextInt();
		}
		
		System.out.println("month is: "+m);

	}

}
