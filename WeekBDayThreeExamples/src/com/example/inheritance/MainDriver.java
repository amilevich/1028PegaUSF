package com.example.inheritance;

public class MainDriver {

	public static void main(String[] args) {
		SuperHero superH = new SuperVillain();
		System.out.println(superH.getAlias());
		
		System.out.println(((SuperVillain)superH).alias);
		/*
		 * Casting - taking an object on one particular type and turning it into another object type
		 * 
		 * Upcasting - casting a subtype(child) to a supertype(parent)
		 * to write a general code that deals only with the supertype
		 * 
		 * Downcasting - casting to a subtype(child) from a supertype(parent)
		 * */
		
		String s = superH.alterWeakness();
		System.out.println(s);
	}

}
