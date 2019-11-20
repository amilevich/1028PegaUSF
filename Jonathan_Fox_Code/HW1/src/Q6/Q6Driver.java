package Q6;

import java.util.Scanner;

public class Q6Driver {
	public static final boolean one = true;
	
	//Write a program to determine if an integer is even without using the modulus operator (%)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		
		System.out.printf("Enter a  number to see if it's even. 0 to quit.\n");
		while(one) {
			try {
				i = Integer.valueOf(input.nextLine());
				
				if(i == 0) System.exit(0);
				
				//print whether or not the right-most bit is 0
				System.out.printf("%s\n", ((i&0x00000001) == 0) ? "true" : "false");
			}
			catch(NumberFormatException e) { System.out.printf("Incorrect Input\n"); }
		}
	}

}
