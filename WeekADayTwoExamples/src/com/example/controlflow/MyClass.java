package com.example.controlflow;

import java.util.Random;

public class MyClass {
	
	/*
	 * Control flow statements
	 * They break up the flow of execution by deploying decision making and loops,
	 * enabling the program to conditionally execute block of code
	 * 
	 * if -> runs block of code if true, "else if" is used to write mutually exclusive blocks of code,
	 * "else" will execute if nothing else did ( or if no condition was met)
	 * 
	 * for -> typically is used when you know for how long you want to loop,
	 * has a start, an end and an increment
	 * 
	 * switch -> useful when you are checking a variable against a lot of conditions/values
	 * 
	 * while -> typically used when you do not know for how long you want to loop but
	 * have you condition that needs to be satisfied
	 * 
	 * do while -> same as "while" but definitely will run at least once
	 * 
	 * "continue" go to the end of the loop and start the next iteration, can be used in switch and with loops
	 * 
	 * "break" goes to the end of the loop and breaks out of the loop, can be used within swiitch and loops
	 * 
	 * 
	 */
	
	
	public static void main(String[]args) {
		
		//if statement
		// a random number is generated, if the number is grater than zero
		//we print a message to the console
		
		Random r = new Random();
		// we are instantiating an object called "r" of type Random
		//int num = r.nextInt();
		//System.out.println(num);
		int num2 = 0;
		/*
		if ( num > 0) {
			System.out.println("The number " + num + " is positive.");
		} else if (num < 0){
			System.out.println("The number " + num + " is negative.");
			} else {
				System.out.println("The number is 0.");
			}*/
		
		
		/*
		 * switch statement
		 * the switch keyword is used to test a value from the variable
		 * or the expression against a list of values.
		 * The list of value
		 */
		
//		String country = "Switzerland";
//		switch(country) {
//		case"Switzerland":
//			System.out.println("Switzerland");
//			break;
//			
//		case"us":
//			System.out.println("United States");
//			break;
//			
//		case "turkey":
//			System.out.println("Turkey");
//			break;
//			
//		case "Dominican Republic":
//			System.out.println("D.R.");
//			break;
//			
//			default:
//				System.out.println("No match found");
//		}
 
		//while loop
		//allows code to be executed repeatedly base on a given boolean condition
		
//		int var = 0; // first part is initialization
//		int sum = 0;
//		
//		while(var < 10) {
//			// the statement will be executed until var = 10
//			//System.out.println(var);
//			var++; // increment by 1
//			sum = sum + var; // same thing as sum += var
//		}
//		
//		System.out.println("The sum is: " + sum);
		
		/*
		 * do while
		 */
//		
//		int count = 0;
//		do {
//			System.out.println(count);
//		}while (count != 0);
		
		/*
		 * for loop
		 * 3 parts of the loop:
		 * 1) initiate the counter i
		 * 2) specify a condition, when it is met, the statement inside the block is executed
		 * 3) counter is increased or decreased
		 */
//		
//		for(int i = 100; i > 38; i--) {
//			System.out.println(i);
//			i-=2;
//		}
		
		//continue let us print a list of numbers that cannot be devided by 2 without a remainder
		// print all off numbers
		int num3 = 0;
		while(num3 < 100) {
			num3++;
			
			if ((num3 % 2) == 0) {
				continue;
			}
			System.out.print(num3 + " ");
		}
	}

}
