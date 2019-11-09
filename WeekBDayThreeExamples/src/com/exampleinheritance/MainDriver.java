package com.exampleinheritance;

public class MainDriver {

	public static void main(String[] args) {

		SuperHero superH = new SuperVillan();
		System.out.println(superH.getAlias());
		System.out.println(((SuperVillan)superH).alias);
		
		/*
		 * casting is the process of taking an object of one particular type
		 * and turning it into another object type
		 * Upcasting - casting a subtype(child) to a supertype(parent)
		 * to write general code that deals only  with the supertype
		 * 
		 * Downcasting - casting to a subtype(child) from supertype
		 * to access specific behavior of a subtype
		 */
		
		String s = superH.alterWeakness();
		System.out.println(s);
	}

}
