package com.example.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListExamples {

	public static void main(String[] args) {
		
		/*
		 * ArrayList 
		 */
		
		List<Integer> arrList = new ArrayList<Integer>();
		ArrayList<Integer> aList = new ArrayList<>();
		
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
         * By using Iterator we can perform both reaad and remove operations
         */
		
        
        ArrayList<String> tony = new ArrayList<>();
        tony.add("fall");
        tony.add("spring");
        tony.add("summer");
        tony.add("winter");
        
        //ListIterator to traverse the list
        ListIterator<String> iterator = tony.listIterator();
        
        //Traversing the list in forward direction
        System.out.println("Displaying list in forward direction");
        while (iterator.hasNext()) {
        	
            System.out.println(iterator.next() + " ");

        }
        
        //traversing the list in backward direction
        System.out.println("Displaying list in backward direction");
        while(iterator.hasPrevious()) {
        	
            System.out.println(iterator.previous() + " ");

        }

		
	}
}
