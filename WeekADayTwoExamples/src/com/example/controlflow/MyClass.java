package com.example.controlflow;

import java.util.Random;

public class MyClass {
	
	/*
	 * Control flow statements?
	 * They break up the flow of execution by employing decision making and
	 * loops, enabling the program to conditionally execute blocks
	 * of code
	 * 
	 * if -> runs block of code if true, "else if" is used to write
	 * mutually exclusive blocks of code, "else" will execute
	 * if nothing else did (or if no condition was met)
	 * 
	 * for -> typically is used when you know for how long you want to loop,
	 * has a start, an end and an increment
	 * 
	 * switch -> useful when you are checking a variable against
	 * a lot of conditions/values
	 * 
	 * while -> typically used when you do not know for how long you want to 
	 * loop but have you condition that needs to be satisfied
	 * 
	 * do-while -> same as while, but definitely will run at least once
	 * 
	 * "continue" - go to the end of the loop and start the next iteration
	 * can be used in switch and with loops
	 * 
	 * "break" - go to the end of the loop and breaks out of the loop
	 * can be used within switch and loops
	 * 
	 */
	
	public static void main(String[] args) {
		
		//if statement
		//a random number is generated, if the number is greater than 0,
		//we print a message to the console
		
		Random r = new Random();
		// we are instantiating an object called "r" of type Random
		int num = r.nextInt();
		//System.out.println(num);
		
		int num2 = 0;
		
//		if(num > 0) {
//			System.out.println("The number " + num + " is positive.");
//		} else if (num < 0) {
//			System.out.println("The number " + num + " is negative.");
//		} else {
//			System.out.println("The number is 0.");
//		}
//		
		
		//switch statement
		/*
		 * the switch keyword is used to test a value from the variable
		 * or the expression against a list of values. 
		 * The list of values is presented with the "case" keyword
		 * if the values match, the case is executed
		 * 
		 * there is an optional default statement that is executed
		 * no matter if a match is found
		 * 
		 * break keyword is typically found at the end of each case
		 * to terminate the loop
		 */
		
//		String country = "Switzerland";
//		switch(country) {
//		case "Switzerland":
//			System.out.println("Switzerland");
//			break;
//		case "us":
//			System.out.println("United States");
//			break;
//		case "turkey":
//			System.out.println("Turkey");
//			break;
//		case "dominican republic":
//			System.out.println("DR");
//			break;
//		default:
//			System.out.println("No match found");
//		}
		
		//while loop
		//allows code to be executed repeatedly based on a
		//given boolean condition
		
		int var = 0; //first part is initialization
		int sum = 0;
		
		while(var < 10) {
			//the statement will be executed until var = 10
			var++; //we increment by 1
			sum = sum + var; //same thing as sum += var
			//System.out.println("the sum is: " + sum);
		}
		//System.out.println("the sum is: " + sum);
		
		//do while
//		int count = 0;
//		do {
//			//System.out.println("burn");
//		} while (count != 1); {
//			//means not equals
//		}
		
		//for loop
		/*
		 * 3 parts of the loop:
		 * 1) initiate the counter i 
		 * 2) specify a condition, when it is  met, the statement
		 * inside the block is executed
		 * 3) counter is increased or decreased
		 */
		
//		for(int i = 100; i>38; i--) {
//			System.out.println(i);
//			i-=2;
//		}
		
		//continue keyword
		//let us print a list of numbers that cannot be divided by 2
		//without a remainder
		//print all odd numbers
		
		int num3 = 0;
		while(num3 < 100) {
			num3++;
			
			if((num3 % 2) == 0) { // = is assignment, == is comparison
				continue;
			}
			System.out.print(num3 + " ");
		}
		
	}

}
