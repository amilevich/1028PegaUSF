package problemz14;

import java.util.Date;
import java.util.Scanner;

public class Solution14 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("choose 1,2,3:");
		String choice = sc.nextLine();
		
		switch(choice) {
		case "1":
			System.out.println("Number to be square rooted:");
			float squareRoot = sc.nextFloat();
			System.out.println(Math.sqrt(squareRoot));
			break;
		case "2":
			Date date = new Date();
			System.out.println(date);
			break;
		case "3":
			String str = "I am learning Core Java";
			String[] strings = str.split(" ");
			for (int i=0; i<strings.length; i++) {
				System.out.println(strings[i]);
			}
			break;
			
		}
	}
	
	
	
}
