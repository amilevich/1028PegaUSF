package com.example.sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	
	/*
	 * Sets
	 * Data structure inside the Collection API
	 * that do not allow duplicates, do not guarantee
	 * insertion order.
	 * 
	 * Any data structure inside the Collection API and Maps
	 * do not use primitive data types.
	 * 
	 * To actually utilize primitive data types in these
	 * structures, we use Wrapper Classes
	 * Wrapper Classes are premade classes that allow you
	 * to convert a primitive data type into an object
	 * 
	 * int -> Integer
	 * boolean -> Boolean
	 * byte -> Byte
	 * 
	 * The process of converting a primitive data types
	 * into its Wrapper class is called boxing(autoboxing).
	 * From Wrapper Class to primitive -> unboxing
	 * 
	 */
	
	public static void main(String[] args) {
		
		Set<Integer> s = new HashSet<Integer>();
		s.add(7);
		s.add(13);
		s.add(20);
		s.add(9);
		s.add(35);
		s.add(7);
		s.add(35);
		s.add(null);
		System.out.println(s);
		
		Set<Integer> tSet = new TreeSet<>();
		tSet.addAll(s);
		System.out.println(tSet);
		
		
	}

}
