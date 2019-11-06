package com.example.stack;

import java.util.Stack;

public class MyClass {
	/*
	 * Stack - data structure that follows the LIFO(FILO) principle and is part of the collection API.
	 * Stack extends from Vector, so stack also inherits from List
	 * 
	 * Stack is class. You can create and object of type stack and have all the properties of type stack.
	 */

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stackPeek(stack);
		stackPush(stack);
		stackSearch(stack,2);
		stackSearch(stack,10);
		stackSearch(stack,20);

		
	}
	
	//displaying elements on the top of the stack
	static void stackPeek(Stack<Integer> stack) {
		Integer element = stack.peek();
		System.out.println("Element on the top of the stack: " + element);
	}


	//putting elements on top of the stack
	static void stackPush(Stack<Integer> stack) {
		for(int i=0; i<5; i++) {
			stack.push(i);
			System.out.println(stack);
		}
	}
	
	//searching for element in the stack
	static void stackSearch(Stack<Integer> stack, int element) {
		Integer i = stack.search(stack);
		if(i == -1) {
			System.out.println("Element not found");
		}else {
			System.out.println("Element is found at position: " + i);
		}
	}
}

