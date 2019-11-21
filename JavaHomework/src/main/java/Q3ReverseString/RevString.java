package Q3ReverseString;

import java.util.Scanner;

public class RevString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter a String to be reversed: ");
		String s = sc.nextLine();
		int l = s.length();
		
		System.out.println("\nYour initial  string is: "+s);
		
		for (int i = l-1; i>=0; i--) {
			s += s.charAt(i);
		}
		
		s=s.substring(l);
		
		System.out.println("Your reversed string is: "+s);
	}
}
