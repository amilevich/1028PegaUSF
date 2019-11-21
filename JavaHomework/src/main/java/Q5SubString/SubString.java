package Q5SubString;

import java.util.Scanner;

public class SubString {

	public static void main(String[] args) {
		//Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  
		//Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
		
		Scanner sc = new Scanner(System.in);
		int idx=0;
		
		System.out.println("Please enter a string:");
		String s = sc.nextLine();
		
		do {
			System.out.println("Enter the index that you wish to print up to:");
			idx = sc.nextInt();
		}while (idx<=0 || idx>=s.length());
		
		System.out.print("The substring, starting at the beginning and running to the cut off index of your choice, is: \n\"");
		for (int i = 0; i<idx; i++) {
			System.out.print(s.charAt(i));
		}
		System.out.print("\"");
	}
}
