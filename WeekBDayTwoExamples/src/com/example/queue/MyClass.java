package com.example.queue;
/*
 * Queue- Data structure that follows the FIFO principals and is part
 * of the collection API
 * 
 * Queue is an interface
 * 
 * Queue being an interface requires a concrete class to actually
 * create an object of type Queue.
 * 
 * The most common classes Deque, proorityQueue and LinkedList
 * 
 * Essentially, they can be the same thing as long as items are added or
 * removed from opposite sides.
 */

import java.util.LinkedList;
import java.util.Queue;

public class MyClass {
	
	public static void main(String[]args) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 100; i < 120; i++) {
			q.add(i);
		
		}
		
		System.out.println(q);
		
		//remove the head of the queue
		
//	int x = q.remove();
//	System.out.println("\n");
//	System.out.println("removed element is: " + x);
	
	//peek method
	int head = q.peek();
	System.out.println("head of queue is: " + head);
	
	int size = q.size();
	System.out.println("size of queue is: " + size);
	
	
	}
	
	
	

}
