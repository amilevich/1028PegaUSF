package com.example.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
/*
 * Sets
 * Data Structure inside the Collection API
 * that do not allow duplicates, do not guarantee 
 * insertion order
 * 
 * And data structure inside the Collection API and Maps do 
 * not use primitive data types.
 * 
 * To actually utilize primitive data types in these
 * structures, we use wrapper classes
 * Wrapper Classes are premade classes that allow you to convert 
 * a primitive data type into an object
 * 
 * int -> Integer
 * boolean -> Boolean
 * byte -> Byte
 * 
 * 
 * The process of converting a primitive data types
 * into its Wrapper Class is called boxing(autoboxing)
 * From Wrapper Class to primitive -> unboxing
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
		//s.add(null); // can be added for a set but when applied to treeSet cannot sort
		System.out.println(s);
		
		Set<Integer> tSet = new TreeSet<Integer>(); //will order form least to greatest
		tSet.addAll(s);
		System.out.println(tSet); 
		
		Set<String> seasons = new TreeSet<String>();
		seasons.add("Winter");
		seasons.add("Summer");
		seasons.add("Fall");
		seasons.add("Spring");
		seasons.add("Winter");
		seasons.add("Winter");
		System.out.println(seasons);
		Set<String> seas = new HashSet<String>();
		seas.addAll(seasons);
		System.out.println(seas);
		
		//Notice how when adding a set to a list that the duplicates are not sent over to list
		List<String> seasonsO = new ArrayList<String>();
		seasonsO.addAll(seasons);
		System.out.println(seasonsO);
		
	}
}
