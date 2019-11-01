package com.example.abstractclass;

public class MainDriver {

	
	public static void main(String[] args) {
		
		SuperHero sh = new SuperHero();
		
//		sh.fly(); // comes from SuperHero class
//		sh.eat(); // comes from Person AC but is overridden in SuperHero
//		sh.sleep(); // comes from the Person AC.
		sh.name(2,9);
		
//		Person p = new SuperHero();
//		p.eat();
//		p.sleep();
////		p.fly(); cannot be called
//		
		
		
		
	}
}
