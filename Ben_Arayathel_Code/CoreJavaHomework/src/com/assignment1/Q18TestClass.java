package com.assignment1;

public class Q18TestClass {
	
	public static void main(String[] args) {
		
		Q18 tested = new Q18();
		
		System.out.println(tested.checkCaps("Hello"));
		System.out.println(tested.checkCaps("hello"));
		
		System.out.println(tested.convertUpperCase("lowercaps"));
		
		System.out.println(tested.convertUpperCase("10"));
		
	}

}
