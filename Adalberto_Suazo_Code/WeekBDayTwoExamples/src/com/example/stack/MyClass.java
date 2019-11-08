package com.example.stack;

import java.util.Stack;

public class MyClass {

	/*
	 * stack - data structure follows the LIFO principle
	 * and is part of the collection API
	 * Stack extends from Vector, so also inherits from list
	 * 
	 * stack is a class. 
	 * */
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stackPush(stack);
//		stackPeek(stack);
		stackSearch(stack, 2);
		stackSearch(stack, 10);
		stackSearch(stack, 52);
		System.out.println(stack);
	}
	//display the element that is on the top of the stack
	static void stackPeek(Stack<Integer> stack) {
		Integer element = stack.peek();
		System.out.println("On the top of the stack: " + element);
	}
	//method to put elements on the top of the stack
	static void stackPush(Stack<Integer> stack) {
		for(int i =0; i<5; i++) {
			stack.push(i);
		}
	}
	//search for element in the stack
	static void stackSearch(Stack<Integer> stack, int element) {
		Integer i = stack.search(element);
		if(i == -1) {
			System.out.println("Element not found");
		}else {
			System.out.println("Element is found at position: " + i);
		}
	}
}
