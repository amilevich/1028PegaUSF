package com.example.stack;

import java.util.Stack;

public class MyClass {
	/*
	 * Stack is a data structure that follow the LIFO(FILO) principals
	 * and is part of the Collection API
	 * Stack extends from Vector, so stack also inherits from List
	 * 
	 * Stack is a class.
	 */

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stackPush(stack);
//		//stackPeek(stack);
//		stackSearch(stack,2);
//		stackSearch(stack,3);
//		stackSearch(stack,1);
		System.out.println(stack);
	}

	
	//display element on the top of the stack
	static void stackPeek(Stack<Integer> stack) {
		Integer element = stack.peek();
		System.out.println("Element on the top of the stack: " + element);
	}
	// putting elements on top of the stack
	static void stackPush(Stack<Integer> stack) {
		for(int i = 0; i < 5; i++) {
			stack.push(i);
		}
	}
	
	//searching for element in the stack
	static void stackSearch(Stack<Integer> stack, int element) {
		Integer i = stack.search(element);
		
		if(i == -1) {
			System.out.println("Element not found");
			
		}else {
			System.out.println("Element is found at position: " + i);
		}
	}
}
