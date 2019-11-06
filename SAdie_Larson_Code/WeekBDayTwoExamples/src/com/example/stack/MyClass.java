package com.example.stack;

import java.util.Stack;

public class MyClass {

	/*
	 * Stack - data structure that follows the LIFO principle and is part of the
	 * Collection API
	 * 
	 * stack extends from vector, so stack also inherits from LIsts
	 */

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		//stackPeek(stack);
		stackPush(stack);
		stackPeek(stack);
		stackSearch(stack, 2);
		stackSearch(stack, 10);
		System.out.println(stack);
		

	}

	// displaying element on the top of the stack
	static void stackPeek(Stack<Integer> stack) {
		Integer element = stack.peek();
		System.out.println("Element on the top of the stack: " + element);
	}

	// putting element on top of the stack

	static void stackPush(Stack<Integer> stack) {
		for (int i = 0; i < 5; i++) {
			stack.push(i); // pushing 0-4
			// the same as .add which is not specific t stack but for everything in
			// collection API
		}
	}

	// searching for element in the stack
	static void stackSearch(Stack<Integer> stack, int element) {
		Integer i = stack.search(element);
		if (i == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element is found at position: " + i);
		}
	}
}
