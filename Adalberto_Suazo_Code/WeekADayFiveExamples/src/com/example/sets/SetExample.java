package com.example.sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	/*
	 * sets
	 * are data structures inside the collection API
	 * that do not allow duplicates, do not guarantee
	 * insertion order.
	 * 
	 * any data structure inside the collection API and MAPS do not use primitive data types.
	 * 
	 * To actually utilize primitive data types in these structures we use Wrapper Classs
	 * Wrapper classes are premade classes that allow you to convert a primitive data type into an
	 * objject
	 * 
	 * int -> Integer
	 * boolean -> Boolean
	 * byte -> Byte
	 * 
	 * 
	 * The process of converting a primitive data type into its wrapper class
	 * this is called boxing or autoboxing.
	 * if you go from wrapper class to primitive it is called unboxing
	 * */
	
	public static void main(String[] args) {
		
		Set<Integer> s = new HashSet<Integer>();
		s.add(7);
		s.add(13);
		s.add(20);
		s.add(9);
		s.add(35);
		s.add(7);
		s.add(35);
	//	s.add(null);
		System.out.println(s);
		
		Set<Integer> tSet = new TreeSet<Integer>();
		tSet.addAll(s);
		System.out.println(tSet);
	}
}
