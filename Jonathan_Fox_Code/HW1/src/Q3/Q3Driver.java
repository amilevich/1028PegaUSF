package Q3;

import java.util.Scanner;

public class Q3Driver {

	//Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line;
		int l;
		
		System.out.printf("type a string to be reversed. type \"quit\" to quit.\n");
		while(input.hasNext()) {
			line = input.nextLine();
			
			if(line.equals("quit")) System.exit(0);
			
			l = line.length();
			//go backwards through the string, appending each character
			for(int i=0; i<l; i++) line = line.concat(String.format("%c", line.charAt(l-1-i)));
			//take the substring from the end of the original string onwards
			line = line.substring(l);
			System.out.printf("%s\n", line);
			
		}
		
		input.close();
	}
}
