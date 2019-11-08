package com.example.inheritance;

public class MainDrive {

	public static void main(String[] args) {

		SuperHero superH = new SuperVillain(); //implicitly casting to child on the right
		System.out.println(superH.getAlias()); //will print out villain's alias
		System.out.println(superH.alias); //will print out SuperHero alias
		System.out.println(((SuperHero)superH).getAlias()); //still be accessing the get of supervillain 
		System.out.println(((SuperVillain)superH).alias); //downcasting
		/*
		 * casting: taking an object on one particular type
		 * and turning it into another object type
		 * 
		 * upcadting: casting a subtype(child) to a super(parent)
		 * to write a general code that deals only with the supertype
		 * 
		 * downcasting: casting a subtype(child) from a supertype (parent)
		 * to access specific behavior of a subtype
		 */
		System.out.println(superH.alterWeakness()); //banannaas since SuperVillain had overriden method
		System.out.println(superH.weakness); //will print out banans since called alterWeakness so weakness was overid to bananas
		
		
	}

}
