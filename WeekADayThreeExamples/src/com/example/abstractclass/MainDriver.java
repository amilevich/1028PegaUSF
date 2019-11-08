package com.example.abstractclass;

public class MainDriver {
	
	public static void main(String[] apples) {
		
//		SuperHero sh = new SuperHero();
//		sh.fly();
//		sh.eat();
//		sh.sleep(); //sleep comes from person
		
		Person p = new SuperHero();
		p.eat();
		p.sleep();
		//p.fly(); 
		
		//Person pq = new Person();
		
	}
}
