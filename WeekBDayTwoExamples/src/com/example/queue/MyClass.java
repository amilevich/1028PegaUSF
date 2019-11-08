package com.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyClass {
	
	/*
	 * Queue - data structure that follows the FIFO principle and is part of the collection API
	 * Queue is an interface and it requires a concrete class to actually to create an object of the type queue
	 * 
	 * the most common classes Deque, priorityQueue and LinkedList
	 * 
	 * if we compare a queue and a list, essentially they are same thing as ling as items are added or removed from opposite sides.
	 * */
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 100; i<120; i++) {
			q.add(i);
		}
		System.out.println(q);
		
		//
		int x = q.remove();
		System.out.println("removed element is: "+ x);
		System.out.println("------------------------------------- ");
		System.out.println("now the Linkedlist is: " + q);
		
		int head = q.peek();
		System.out.println("head of queue is " + head);
		
		int size = q.size();
		System.out.println("size of queue is " + size);
	}

}
