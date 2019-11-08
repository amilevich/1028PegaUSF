package com.example.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Listexample {
	/*
	 * 
	 * */
	
	public static void main (String[] args) {
		
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
		 * a universal iterator that we can apply to any collection object.
		 * B using Iterator, we can perform both read and remove operations
		 * */
		
		ArrayList<String> tony = new ArrayList<String>();
		tony.add("Fall");
		tony.add("Spring");
		tony.add("Summer");
		tony.add("Winter");
		
		//listIterator to traverse the list
		ListIterator<String> iterator = tony.listIterator();
		
		//traversing the list in forward direction
		System.out.println("Displaying list in forward direction");
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		//traversing the list in backward direction
		System.out.println("\n" + "Displaying list in backward direction");
		while(iterator.hasPrevious()) {
			System.out.print(iterator.previous() + " ");
		}
		
	}
}
