package com.homework.algorthim;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainDriver implements Comparator, Q15Operants{

	public static void main(String[] args) {
		
//		// Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
//		Q1BubbleSort bubbleSort = new Q1BubbleSort();
//		int[] arr = {1,0,5,6,3,2,3,7,9,8,4}; 
//		
//		// Before the bubble sort
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println("Before the bubble sort: "+ arr[i]);
//		}
//		
//		//Bubble Sort method ACTIVATE!
//		bubbleSort.bubbleSort(arr);
//		
//		// After the bubble sort
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println("After the bubble sort: "+arr[i]);
//		}
		
//***************************************************************************************************************************************************************************
		
		
//		//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0. 
//		Q2Fibonacci printFib = new Q2Fibonacci();
//		printFib.printFib(25);
		
//***************************************************************************************************************************************************************************

		//Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
//		Q3ReverseString reverse = new Q3ReverseString();
//		reverse.reverseString("hello");

//***************************************************************************************************************************************************************************
		
		//Q4. Write a program to compute N factorial.
//		Q4Factorial factorial = new Q4Factorial();
//		System.out.println(factorial.factorial(5));

//***************************************************************************************************************************************************************************
		
		//Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
//		Q5SubString subString = new Q5SubString();
//		System.out.println(subString.subString("Hello World", 6));
//		

//***************************************************************************************************************************************************************************
		
		//Q6. Write a program to determine if an integer is even without using the modulus operator (%).
//		Q6Even even = new Q6Even();
//		even.even(10);
		
//***************************************************************************************************************************************************************************
		
		//Q7. Sort two employees based on their name, department, and age using the Comparator interface.
//		Q7Comparator comparator = new Q7Comparator("Victory", "26", "Software");
//		Q7Comparator comparator1 = new Q7Comparator("Anthony, ", "24", "Software Eng");
//		Q7Comparator comparator2 = new Q7Comparator("Leroy", "20", "Software Engineer");
//
//		ArrayList<Q7Comparator> comparatorList = new ArrayList<Q7Comparator>();
//		comparatorList.add(comparator);
//		comparatorList.add(comparator1);
//		comparatorList.add(comparator2);
//		
//		// unsorted
//		for(int i = 0; i < comparatorList.size(); i++) {
//			System.out.println(comparatorList);
//		}
//		
//		//Sort by name
//		Collections.sort(comparatorList, new sortName());
//		for(int i = 0; i < comparatorList.size(); i++) {
//			System.out.println(comparatorList);
//		}
//		
//		//Sort by age
//		Collections.sort(comparatorList, new sortAge());
//		for(int i = 0; i < comparatorList.size(); i++) {
//			System.out.println(comparatorList);
//		}
//		
//		//Sort by department
//		Collections.sort(comparatorList, new sortDepartment());
//		for(int i = 0; i < comparatorList.size(); i++) {
//			System.out.println(comparatorList);
//		}
//		

	
//***************************************************************************************************************************************************************************
	
	//Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
		//“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did” 
//
//		Q8Palindromes palindromes = new Q8Palindromes();
//		palindromes.arrayList();
		
//***************************************************************************************************************************************************************************

	//Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
//		Q9PrimeNumbers prime = new Q9PrimeNumbers();
//		prime.primeNum();

		
//***************************************************************************************************************************************************************************

	//Q10. Find the minimum of two numbers using ternary operators.
//		Q10MinNum min = new Q10MinNum();
//		min.minTwoNum(5, 10);

//***************************************************************************************************************************************************************************
	//Q11.  Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.
//		Q11AccessPackage q11 = new Q11AccessPackage();
//		q11.q11();
	
//***************************************************************************************************************************************************************************

	//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
//		Q12EnhancedLoop enLo = new Q12EnhancedLoop();
//		enLo.enhancedLoop();

//***************************************************************************************************************************************************************************

	//Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
		Q13Triangle q13 = new Q13Triangle();
		q13.triangle();

//***************************************************************************************************************************************************************************
		
	//Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
//		Case 1: Find the square root of a number using the Math class method. 
//		Case 2: Display today’s date.
//		Case 3: Split the following string and store it in a string array. 
//				“I am learning Core Java
//		Q14SwitchCase switchs = new Q14SwitchCase();
//		switchs.switchCase();
//***************************************************************************************************************************************************************************

	//Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  Create a class that implements this interface and provides appropriate functionality to carry out the required operations. Hard code two operands in a test class having a main method that calls the implementing class.

//		Q11Override override = new Q11Override();
//		System.out.println(override.addition(5, 10));
//		System.out.println(override.subtraction(5, 10));
//		System.out.println(override.multiply(5, 10));
//		System.out.println(override.divide(10, 5));
		
//***************************************************************************************************************************************************************************

	//Q16. Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).	
	
//		Q16Command command = new Q16Command();
//		command.command(args);
		//go to run config, pass arg
		
//***************************************************************************************************************************************************************************

//		Q17. Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. Enter principal, rate and time through the console using the Scanner class. 
//		Interest = Principal* Rate* Time

//		Q17Interest interest = new Q17Interest();
//		interest.interest();
		
//***************************************************************************************************************************************************************************
		
		//Q18. Write a program having a concrete subclass that inherits three abstract methods from a superclass. Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: 
//		Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
//		Convert all of the lower case characters to uppercase in the input string, and return the result. 
//		Convert the input string to integer and add 10, output the result to the console.
//
//		Q18SubClass q18 = new Q18SubClass();
//		System.out.println(q18.uppercase("Qoei"));
//		System.out.println(q18.lowercase("(OQoewue"));
//		System.out.println(q18.convertToInt("12341234"));

//***************************************************************************************************************************************************************************

		//Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
		
//		Q19 q19 = new Q19();
//		q19.stuff();
		
//***************************************************************************************************************************************************************************

		//Q20. Create a notepad file called Data.txt and enter the following: 
//		Mickey:Mouse:35:Arizona
//		Hulk:Hogan:50:Virginia
//		Roger:Rabbit:22:California
//		Wonder:Woman:18:Montana
//
//		Write a program that would read from the file and print it out to the screen in the following format:
//
//		Name: Mickey Mouse
//		Age: 35 years
//		State: Arizona State
		
//	Q20 q20 = new Q20();
//	q20.readCharacterStream("Q20");
	}
	
}