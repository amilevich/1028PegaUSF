package com.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyClass {

	/*
	 * Queue - data structure that follows the FIFO principle and is part of the Collection API
	 * 
	 * Queue - is an interface
	 * 
	 * Queue being an interface requires a concrete class to actually create an object of type queue
	 * the most common classes Deque, Priority queue, and Linked Lists
	 * 
	 * Essentially, they can be the same thing as long as items are added or removed from opposite sides 
	 */
	
	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 100; i < 120; i++) {
			q.add(i);
		}
		System.out.println(q);
		
		//remove the head of queue 
		int x = q.remove();
		System.out.println("removed element is: " + x);
		
		System.out.println(q);
		
		int head = q.peek();
		System.out.println("the head is " + head);
		
		int size = q.size();
		System.out.println("Size of a quuee is " + size);
	}

}



