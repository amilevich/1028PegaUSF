package com.algo.hw;

public class MyClass {

	public static void main(String[] args) {
		
		final int[] arr = new int [] {1,0,5,6,3,2,3,7,9,8,4};
		String input = "This is an amazing life";
		int fact = 4;
		String [] pal = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		Algorithms obj = new Algorithms();
		obj.bubbleSort(arr);
		obj.fibonacci(15);
		System.out.println("Reverse String: "+ obj.reverseString(input)); 
		System.out.println("'4' factorial: " + obj.factorial(fact));
		obj.substring(input, 4);
		obj.isEven(fact);
		System.out.println(obj.palindrome(pal));
		//obj.CheckPrime();
		obj.ternary(5, 8);
		obj.floatVarMethod(6.7f,5);
		System.out.println("Even Numbers list " + obj.checkEven());
		obj.printTriangle(4);
		obj.switchExample(1,1024);
		obj.switchExample(2,1024);
		obj.switchExample(3,1024);
		
	}	
}
