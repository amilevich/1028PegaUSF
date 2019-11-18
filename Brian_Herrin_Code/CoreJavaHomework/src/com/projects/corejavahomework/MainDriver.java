package com.projects.corejavahomework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.projects.corejavahomework1.Question11Class;

public class MainDriver {
	static void printListPretty(List<Employee> list) {
		System.out.println("Employees: ");
		for(Employee a : list) {
			System.out.println(a);
		}
	}
	
	// Q1 work
	public static Integer[] BubbleSort(Integer arr[]){
		//System.out.println("BubbleSort Integer[]: ");
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					arr[i] = arr[i] + arr[j];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
				}
			}
			//System.out.print(" " + i + ": " + arr[i] + " ");
		}
		//System.out.println("");
		return arr;
	}
	
	// Q2 work
	public static int printFibo(int input, int n1, int n2) {
		if(n1 == 0 && n2 ==1) {
			System.out.print("0 ");
			input = input - 1;
		}
		int n3 = n1 + n2;
		if(input > 0) {
			n1 = n2;
			n2 = n3;
			System.out.print(n3 + " ");
			//return printFibo(input-n1, i, n1, n2);
			return printFibo(input-1, n1, n2);
		} else {
			n1 = 0; n2 = 1;
			System.out.println("");
			return 0;
		}
	}
	
	// Q3 work
	public static String reversingString(char[] toReverse, int start, int end) {
		while(start < end) {
			toReverse[start] ^= toReverse[end];
			toReverse[end] ^= toReverse[start];
			toReverse[start] ^= toReverse[end];
			
			++start;
			--end;
		}
		return String.valueOf(toReverse);
	}
	public static String reverseString(String toReverse) {
		return reversingString(toReverse.toCharArray(), 0, (toReverse.length()-1));
	}
	
	// Q4 work
	public static int factorial(int n) { //O(N)
		if(n == 1) {
			return 1;
		} else {
			return (n * factorial(n-1));
		}
	}
	
	// Q5 work
	private static String substringToIndex(String string, int i) {
		char[] output = new char[i];
		char[] temp = string.toCharArray();
		for(int j = 0; j < i; j++) {
			output[j] = temp[j];
		}
		return String.valueOf(output);
	}
	
	// Q6 work
	private static boolean isEven(Integer i) {
		// using bitwise solution
		if((i&1) != 1) {
			return true;
		}
		return false;
	}
	
	//Q8 work
	private static boolean isPalindrome(String i) {
		if(i.contentEquals(reversingString(i.toCharArray(), 1, (i.length()-2)))) {
			return true;
		}
		return false;
	}
	
	//Q10 work
	public static int ternaryOperatorsExample(int a, int b){
		return ((a < b) ? a : b);
	}
	
	//Q11
	public static float useOtherPackageClass(float a, float b){
		return a+b;
	}
	
	//Q13
	public static String print0Or1Toggle(String pattern, int aggro, boolean isLeft, boolean isOne){
		String[] addOns = {" 1","1 ","0 "," 0"};
		
		if(aggro <= 0 && pattern.contentEquals("")) {
			//System.out.print("A");
			return "0";
		} else if(aggro <= 0) {
			//System.out.print("B");
			return pattern;
		}
		if(aggro > 0 && pattern.contentEquals("")) {
			//System.out.print("C");
			pattern = "0";
		}
		if(isLeft == true && isOne == true) {
			//System.out.print("D");
			//System.out.println("print0Or1Toggle: Left 1");
			pattern = addOns[1] + pattern;
			//System.out.println(pattern);
			aggro -= 1;
			return print0Or1Toggle(pattern, aggro, false, true);
		}
		if(isLeft == true && isOne == false) {
			//System.out.print("E");
			//System.out.println("print0Or1Toggle: Left 0");
			pattern = addOns[2] + pattern;
			//System.out.println(pattern);
			aggro -= 1;
			return print0Or1Toggle(pattern, aggro, false, false);
		}
		if(isLeft == false && isOne == true) {
			//System.out.print("F");
			//System.out.println("print0Or1Toggle: Right 1");
			pattern = pattern.concat(addOns[0]);
			aggro -= 1;
			return print0Or1Toggle(pattern, aggro, true, false);
		}
		if(isLeft == false && isOne == false) {
			//System.out.print("G");
			//System.out.println("print0Or1Toggle: Right 0");
			pattern = pattern.concat(addOns[3]);
			aggro -= 1;
			return print0Or1Toggle(pattern, aggro, true, true);
		}
		//System.out.print("H");
		return pattern;	
	}
	
	//Q14
	private static String[] switchExample(int question14Index, double question14Num, String question14string) {
		if(question14Index < 1) {
			question14Index = 1;
		}
		if(question14Index > 3) {
			question14Index = 3;
		}
		String[] temp = {"",""};
		switch(question14Index){	
			case 1:
				// Case 1: Find the square root of a number using the Math class method.
				Math.sqrt(question14Num);
				System.out.println(question14Num);
				return temp;
			case 2:
				// Case 2: Display today’s date.
				System.out.println(java.time.LocalDate.now());
				return temp;
			case 3:
				// Case 3: Split the following string and store it in a string array.
				return question14string.split(" ", 5);
		}
		return temp;
	}
	
	public static void main(String[] args) {
		// Q1: Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
		System.out.println("Question 1: ");
		Integer question1array[] = {1,0,5,6,3,2,3,7,9,8,4};
		question1array = BubbleSort(question1array);
		for(Integer i : question1array) { System.out.print(i + " "); }
		System.out.println("");
		
		// Q2: Write a program to display the first 25 Fibonacci numbers beginning at 0. 
		System.out.println("Question 2: ");
		printFibo(25, 0, 1);
		
		// Q3: Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
		System.out.println("Question 3: ");
		System.out.println(reverseString("egroeG"));
		
		// Q4: Write a program to compute N factorial.
		System.out.println("Question 4: ");
		System.out.println(factorial(50));
		
		// Q5: Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
		System.out.println("Question 5: ");
		System.out.println(substringToIndex("SpiderFlierString", 11));
		
		// Q6: Write a program to determine if an integer is even without using the modulus operator (%)
		System.out.println("Question 6: ");
		if(isEven(2)) {
			System.out.println("Q6 correctly identified even");
		} else { 
			System.out.println("Q6 wrongly missed even");
		}
		if(isEven(3)) {
			System.out.println("Q6 wrongly missed odd");
		} else {
			System.out.println("Q6 correctly identified odd");
		}
		
		// Q7: Sort two employees based on their name, department, and age using the Comparator interface.
		System.out.println("Question 7: ");
		List<Employee> empList = new ArrayList<>();
		Employee q7e0 = new Employee("Bianca", "Pharmacy", 56);
		Employee q7e1 = new Employee("Andy", "Electronics", 26);
		Employee q7e2 = new Employee("Greg", "Pharmacy", 35);
		Employee q7e3 = new Employee("Andy", "Electronics", 25);
		Employee q7e4 = new Employee("Bianca", "Pharmacy", 54);
		Employee q7e5 = new Employee("Joe", "Electronics", 24);
		empList.add(q7e0);
		empList.add(q7e1);
		empList.add(q7e2);
		empList.add(q7e3);
		empList.add(q7e4);
		empList.add(q7e5);
		System.out.println("Before sorting: ");
		printListPretty(empList);
		System.out.println("");
		Collections.sort(empList, new Employee());
		System.out.println("After sorting: ");
		printListPretty(empList);
		System.out.println("");
		
		// Q8: Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
			// “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did” 
		System.out.println("Question 8: ");
		String[] question8Input = { "“karan”", "“madam”", "”tom”", "“civic”", "“radar”", "“sexes”", "“jimmy”", "“kayak”", "“john”",  "“refer”", "“billy”", "“did”"};
		ArrayList<String> masterList = new ArrayList<String>();
		ArrayList<String> tacoCatList = new ArrayList<String>();
		for(String i : question8Input)
			masterList.add(i);
		for(String i : masterList) {
			if(isPalindrome(i)) {
				tacoCatList.add(i);
			}
		}
		//
		System.out.println("Master List:");
		for(String i : masterList)
			System.out.print(" " + i);
		System.out.println("");
		System.out.println("Palindrome List:");
		for(String i : tacoCatList)
			System.out.print(" " + i);
		System.out.println("");
		
		// Q9: Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
		System.out.println("Question 9: ");
		ArrayList<Integer> question9int = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			question9int.add(i);
		}
		for(Integer i : question9int) {
			boolean isDivisorLess = true;
			if(i == 1) {
				isDivisorLess = false;
			} else {
				for(int j = 2; j <= i; j++) {
					if(j != i && i%j == 0) {
						isDivisorLess = false;
					}
				}
			}
			if(isDivisorLess == true) {
				System.out.print(" " + i);
			}
		}
		System.out.println("");
		
		
		// Q10: Find the minimum of two numbers using ternary operators.
		System.out.println("Question 10: ");
		System.out.println(ternaryOperatorsExample(4, 3));
		System.out.println(ternaryOperatorsExample(3, 4));
		
		// Q11: Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.
		System.out.println("Question 11: ");
		// Should return 16.0
		System.out.println(useOtherPackageClass(Question11Class.q11a, Question11Class.q11b));
		
		// Q12: Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
		System.out.println("Question 12: ");
		int[] question12array = new int[100];
		for(int i = 0; i < question12array.length; i++) {
			question12array[i] = i+1;
		}
		for(int i : question12array) {
			if(i%2 == 0)
				System.out.print(" "+i);
		}
		System.out.println("");
		
		// Q13: Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
			// 0
			// 1 0
			// 1 0 1
			// 0 1 0 1
		System.out.println("Question 13: ");
		// The pattern looks like 0's and 1's are being placed to surround the initial 0
		// For example, my prediction for a 5th line would be "0 1 0 1 0"
		int question13index = 0, question13range = 4, question13aggro = 0;
		String question13string = "";
		
		do {
			question13string = print0Or1Toggle("", question13aggro, true, true);
			System.out.println(question13string);
			question13index++;
			question13aggro = question13index;
		} while(question13index < question13range);
		System.out.println("");
		
		// Q14: Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
			// Case 1: Find the square root of a number using the Math class method. 
			// Case 2: Display today’s date.
			// Case 3: Split the following string and store it in a string array. 
				// “I am learning Core Java”
		System.out.println("Question 14: ");
		int question14Num = 25;
		String question14String = "I am learning Core Java";
		switchExample(1, question14Num, question14String);
		switchExample(2, question14Num, question14String);
		String[] question14StringArray = switchExample(3, question14Num, question14String);
		for(String i : question14StringArray) {
			System.out.println(" " + i);
		}
		System.out.println("");
		
		// Q15: Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  Create a class that implements this interface and provides appropriate functionality to carry out the required operations. Hard code two operands in a test class having a main method that calls the implementing class.
		System.out.println("Question 15: ");
		Question15Class question15Object = new Question15Class();
		int question15int = 0;
		question15int = question15Object.addition(25, 5);
		System.out.println("Question15Class addition: " + question15int);
		question15int = question15Object.subtraction(25, 5);
		System.out.println("Question15Class subtraction: " + question15int);
		question15int = question15Object.division(25, 5);
		System.out.println("Question15Class division: " + question15int);
		question15int = question15Object.multiplication(25, 5);
		System.out.println("Question15Class multiplication: " + question15int);
		
		// Q16: Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).
		System.out.println("Question 16: ");
		String temp = (String)args[0];
		// Used "Question16ArgumentString" as an argument for this program
		System.out.println(temp + " " + temp.length());
		
		// Q17: Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. Enter principal, rate and time through the console using the Scanner class.
			// Interest = Principal* Rate* Time
		System.out.println("Question 17: ");
		
		
		// Q18: Write a program having a concrete subclass that inherits three abstract methods from a
			// superclass.  Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: 
				// 1.	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
			 	// 2.	Convert all of the lower case characters to uppercase in the input string, and return the result. 
			 	// 3.	Convert the input string to integer and add 10, output the result to the console.
				// Create an appropriate class having a main method to test the above setup.
		System.out.println("Question 18: ");
		
		
		// Q19: Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
		System.out.println("Question 19: ");
		
		
		// Q20: Create a notepad file called Data.txt and enter the following: 
			// Mickey:Mouse:35:Arizona
			// Hulk:Hogan:50:Virginia
			// Roger:Rabbit:22:California
			// Wonder:Woman:18:Montana
		// Write a program that would read from the file and print it out to the screen in the following format
			// Name: Mickey Mouse
			// Age: 35 years
			// State: Arizona State
		System.out.println("Question 20: ");
		
	}
}
