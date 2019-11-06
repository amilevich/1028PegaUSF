package com.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyClass {
	
	/*
	 * Queue - data structure that follows the FIFO principle and is part of the Collection API.
	 * Queue is an interface. 
	 * 
	 * Queue being an interface requires a concrete class to actually create an object of type Queue. 
	 * The most common class Deque, PriorityQueue and LinkedList inherits that.
	 * we need to implement a class that utilize Queue to instantiate Queue object.
	 * 
	 * Essentially, they are the same thing as long as items are added or removed from opposite sides. 
	 * You can remove and add elements to only the HEAD 
	 * 
	 * 
	 * Linked list - data structure that is a sequence of nodes. Linked list must start with the head and search for what you are looking for. 
	 * Single Linked list  - Data can only go one way
	 * Doubly Linked list - Data knows about the nodes in front and behind
	 * Circular singly & doubly linked list - the head knows where the tail is and the tail knows where the head is 
	 * 
	 * queue stacks and linked list - you are forcing your user to use the data in a certain way. You are applying rules for each list. 
	 * 
	 * 
	 */

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 100; i <120; i++) {
			q.add(i);
		}
		System.out.println(q);
		
		//remove the head of the queue\
		int x = q.remove();
		System.out.println("removed element is: " + x);
		
		int head = q.peek();
		System.out.println("head of queue is " + head);
		
		int size = q.size();
		System.out.println("size of queue is " + size);
		
	}

}
