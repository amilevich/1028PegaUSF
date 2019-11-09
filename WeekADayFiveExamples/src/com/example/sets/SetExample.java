package com.example.sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	/*
	 * Sets
	 * Data structure inside the collection API
	 * that do not allow duplicates, do not guarantee insertion order
	 * 
	 * Any data structure inside the collection API and maps
	 * do not use primitive data types
	 * 
	 * To actually utilize primitive data types in these structures, we use wrapper classes.
	 * Wrapper classes are pre-made classes that allow you to convert a primitive data type into an object
	 * 
	 * int -> Integer
	 * boolean -> Boolean
	 * byte -> Byte
	 * 
	 * The process of converting a primitive data type into its Wrapper class is called boxing(autoboxing).
	 * From Wrapper class to primitive is called unboxing
	 */

	public static void main(String[] args) {
		
		Set<Integer> s = new HashSet<>();
		s.add(7);
		s.add(13);
		s.add(20);
		s.add(9);
		s.add(35);
		s.add(7);
		s.add(35);
		s.add(9);
		System.out.println(s);
		
		
		Set<Integer> tSet = new TreeSet<>();
		tSet.addAll(s);
		System.out.println(tSet);
		
		
		
	}
}
