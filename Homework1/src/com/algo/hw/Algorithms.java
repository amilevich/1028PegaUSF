package com.algo.hw;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import com.Q11.TwoFloat;

//int randomInteger = (int) (10.0 * Math.random());
public class Algorithms {

	//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
    
	
    void printArray(int arr[]) {
		for(int i : arr) {
			System.out.print(i + " "); 
		}
		System.out.println();
	}
		
    void bubbleSort(int arr[]) {	
		System.out.print("Bubble Sorted Array: ");
		int n = arr.length;
		for(int i = 0; i<n-1; i++)
			for(int j = i+1; j<n; j++)
				if(arr[i]>arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
		printArray(arr);
	}
	//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
	
	 void fibonacci(int n){
		 System.out.print("25 Fibonacci numbers: ");
		 int n1=0;
		 int n2=1;
		 int count = 1;
		 while(count <=n) { 
			System.out.print(n1 + " ");
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3; 
			count++;
		}
		System.out.println();
	}
	//Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

	 String reverseString(String input) {
		 char[] try1 = input.toCharArray(); 
		 String reverse = "";
	        for (int i = try1.length-1; i>=0; i--) 
	            reverse = reverse + try1[i]; 
	     return reverse;   
	    
	    } 
	 
	// Q4. Write a program to compute N factorial.
	 
	 int factorial (int n) {
		 if(n==1) {
			 return 1;
		 } else { 
			 return(n*factorial(n-1));
		 }	  
	 }
	// Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.

	 void substring (String str , int idx) {
		 char[] stringToCharArray = str.toCharArray();
		 System.out.print("Substring Method: ");
	     for (int i=0; i<idx-1; i++) { 
				System.out.print(stringToCharArray[i]);
		 }
	     System.out.println();
	 }
	 //Q6. Write a program to determine if an integer is even without using the modulus operator (%)
	 
	 void isEven(int num) {
		 int rem = num/2;
		 System.out.print("Is Even Method: ");
		 if(rem*2==num)
			 System.out.println("Even Number");
		 else
			 System.out.println("Odd Number");
	 }
	 //Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	 
	 ArrayList<String> palindrome(String [] pal) {
		 ArrayList<String> names = new ArrayList<String>(Arrays.asList(pal));
		 ArrayList<String> reversedArrayList = new ArrayList<String>();
		 System.out.println("Original List: "+ names);
		 //System.out.print(names.get(3));
		 int i = 0;
		 // inputs each element in the initial array list  
		 // into reverseString Method, returns a string reversed 
		 System.out.print("Reversed Array List: ");
		 while(i < names.size()) {
			 String reverse = reverseString(names.get(i));
			 if(reverse.equals(names.get(i))) {
				 //reverse = reverseString(names.get(i)); 
				 reversedArrayList.add(names.get(i));
			 }
			 i++;	
		 }
		 return reversedArrayList;
		 
	 }
	 
	 //Q10. Find the minimum of two numbers using ternary operators.
	 
	 void ternary(int a, int b) {
		int minValue = a<b ? a:b;
		System.out.println(minValue);
	 }
	 
	 //Q11. Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.

	 void floatVarMethod(float var1,float var2) {
		 TwoFloat obj = new TwoFloat(var1,var2);
		 System.out.println("First Float Variable: " + obj.getA() + " Second Float Variable: " + obj.getB());
	 }
	 //Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
	 ArrayList<Integer> checkEven() {
		 int i = 0;
		 ArrayList<Integer> arraylist = new ArrayList<Integer>();
		 ArrayList<Integer> arraylisteven = new ArrayList<Integer>();
		 while (arraylist.size() < 100) {
			 arraylist.add(i);
			 i++;
		 }
		 for(Integer y: arraylist) {
			 if(y%2==0) 
		        	arraylisteven.add(y);
		 }
		 return arraylisteven;
	 }
	 
	 //Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
		
	  void printTriangle(int count)
	 {    
	     if (count == 0) return;
	     printTriangle(count - 1);
	     for (int x = 0; x <= count-1; x++) { 
	    	 if(x%2==0)
	    		 System.out.print("0"); 
	    	 else
	    		 System.out.print("1");
	     }
	     System.out.print("\n"); 
	 }
	  
	 // Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
	 
	 
	 static void switchExample(int choice, int number) {
		 switch (choice) { 
	        case 1: 
	            choice = 1; 
	            System.out.println(Math.sqrt(number));
	            break; 
	        case 2: 
	        	choice = 2; 
	        	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        	Date date = new Date();
	        	System.out.println(dateFormat.format(date));
	            break; 
	        case 3: 
	        	choice = 3; 
	        	String myString = "I am learning Core Java";
	        	String[] items = myString.split(" ");
	        	for(String i:items) {
	        		System.out.print("'" + i + "' ");
	        	}
	            break; 
	       
	        } 
	 }
	 
	 
	 



	 
}
	

