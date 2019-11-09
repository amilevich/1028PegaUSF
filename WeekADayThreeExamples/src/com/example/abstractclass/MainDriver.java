package com.example.abstractclass;

public class MainDriver {
	
	public static void main(String[] apples) {
		
		SuperHero sh = new SuperHero();
		sh.fly();// comes from the super hero class
		sh.eat();// comes from person Abstract Class but is overriden in super hero
		sh.sleep();// comes from the person abstract class
		
		Person p = new SuperHero();
	}

}
