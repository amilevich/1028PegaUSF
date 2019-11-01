package com.example.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListExample {

	
	public static void main (String[] args) {
		
		
		//ArrayList
		List<Integer> arrList = new ArrayList<Integer>();
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(7);
		aList.add(8);
		aList.add(21);
		aList.add(7);
		aList.add(16);
		System.out.println(aList);
		System.out.println(aList.get(2));

		
		/*
		 * Iterators
		 * 
		 * A universal iterator that we can apply to my Collection object.
		 * By using iterator, we can perform both read and remove operations
		 * 
		 */
		
		ArrayList<String> tony = new ArrayList<String>();
		tony.add("Fall");
		tony.add("Spring");
		tony.add("Winter");
		tony.add("Summer");
		
//		.aList.ListIterator to traverse the list
		ListIterator<String> iterator = tony.listIterator();
		
//		Traversing the list in forward direction
		System.out.println("Displaying list in forward direction");
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}
		
//		Traversing the list in backward direction
		System.out.println("\n" +"Displaying list in backward direction");
		while(iterator.hasPrevious()) {
			System.out.println(iterator.previous() + " ");
		}
	}
	
}
