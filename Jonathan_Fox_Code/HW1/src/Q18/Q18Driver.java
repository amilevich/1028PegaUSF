package Q18;

import java.util.Scanner;

public class Q18Driver {
	
	// Write a program having a concrete subclass that inherits three abstract
	// methods from a superclass. Provide the following three implementations in the
	// subclass corresponding to the abstract methods in the superclass:
	//1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	//2. Convert all of the lower case characters to uppercase in the input string, and return the result. 
	//3. Convert the input string to integer and add 10, output the result to the console.

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s;
		Disgusting work = new StuffToDo(); //reads like a book
		
		System.out.printf("Feed me a string.\n");
		
		s = input.nextLine();
		
		System.out.printf("hasUpper: %s\n", work.hasUpper(s)?"true":"false");
		System.out.printf("toUpper: %s\n", work.toUpper(s));
		try { System.out.printf("toInt + 10: %d", work.toInt(s)); }
		catch(NumberFormatException e) {System.out.printf("toInt failed.\n"); }
		
		input.close();
	}
	
	private static abstract class Disgusting{
		public abstract boolean hasUpper(String s);
		public abstract String toUpper(String s);
		public abstract int toInt(String s);
	}
	
	public static class StuffToDo extends Disgusting{
		@Override
		public boolean hasUpper(String s) {
			if(s.equals(s.toLowerCase())) return false;
			return true;
		}

		@Override
		public String toUpper(String s) { return s.toUpperCase(); }

		@Override
		public int toInt(String s) throws NumberFormatException{ return Integer.valueOf(s) + 10; }
	}
}
