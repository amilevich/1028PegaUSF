package com.example.lists;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public class ListExample {

	public static void main(String[] args) {
		
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
		 * A universal iterator that we can apply to any Collection object.
		 * By using Iterator, we can perform both read
		 * and remove operations
		 */
		
		ArrayList<String> tony = new ArrayList<String>();
		tony.add("fall");
		tony.add("spring");
		tony.add("summer");
		tony.add("winter");
		
		//ListIterator to traverse the list
		ListIterator<String> iterator = tony.listIterator();
		
		//Traversing the list in forward direction
		System.out.println("Displaying lsit in forward direction");
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + ", ");
		}
		System.out.println();
		
		//Traversing the list in backward direction
				System.out.println("Displaying lsit in backward direction");
				while(iterator.hasPrevious()) {
					System.out.print(iterator.previous() + ", ");
				}
		
	}
}
