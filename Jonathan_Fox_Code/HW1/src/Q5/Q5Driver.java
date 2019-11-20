package Q5;

import java.util.Scanner;

public class Q5Driver {
	final static boolean one = true;

	// Write a substring method that accepts a string str and an integer idx and
	// returns the substring contained between 0 and idx-1 inclusive. Do NOT use any
	// of the existing substring methods in the String, StringBuilder, or
	// StringBuffer APIs.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s;
		int i;
		
		while (one) {
			System.out.printf("Input a string to get the substring of. Or type \"-1\" to quit.\n");
			
			s = input.nextLine();
			if(s.equals("-1")) System.exit(0);
			
			System.out.printf("Now enter the index from which to take the substring.\n");
			
			try {
				//convert input to integer
				i = Integer.valueOf(input.nextLine());
				
				s = substr(s, i);
				if(s == null) error();
				else System.out.printf("%s\n", s);
			}
			catch(NumberFormatException e) { error(); }
			
			
		}

	}
	
	public static void error() { System.out.printf("Incorrect Input.\n"); }

	public static String substr(String str, int idx) {
		String s = "";
		
		//if incorrect index, return null
		if(idx < 0 || idx >= str.length()) return null;
		
		//from idx to end of str, append characters to s
		for(int i = idx; i < str.length(); i++) s += String.format("%c", str.charAt(i));
		return s;
	}

}
