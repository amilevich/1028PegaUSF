package Q4;

import java.util.Scanner;

public class Q4Driver {

	//Write a program to compute N factorial.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Input a number to calculate factorial or a negative number to quit.\n");
		while(input.hasNext()) {
			int n, fact;
			
			try {
				//convert next input line into integer n
				n = Integer.valueOf(input.nextLine());
				
				if(n < 0) System.exit(0);
				
				//from 2 to n, multiply all numbers together
				fact = 1;
				for(int i=2; i<=n; i++) fact*=i;
				
				System.out.printf("%d\n", fact);
			}
			catch(NumberFormatException e) { System.out.printf("Input an integer.\n"); }
		
		}
		
		input.close();
	}

}
