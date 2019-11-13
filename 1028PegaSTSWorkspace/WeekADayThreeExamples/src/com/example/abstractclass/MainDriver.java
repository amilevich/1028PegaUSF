package com.example.abstractclass;

public class MainDriver {
	
	public static void main(String[] apples) {
		
		SuperHero sh = new SuperHero();
		sh.fly(); // from superhero class
		sh.eat(); //from person AC but is overridden in superhero
		sh.sleep(); //from person AC
		
		Person p = new SuperHero();
		p.eat();
		p.sleep();
		//p.fly(); cannot be called
		
		
	}
}
