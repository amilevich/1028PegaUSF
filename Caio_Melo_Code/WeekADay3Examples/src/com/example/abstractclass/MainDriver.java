package com.example.abstractclass;

public class MainDriver {

	public static void main(String[] args) {
		
		SuperHero sh = new SuperHero();
		sh.fly();
		sh.eat();
		sh.sleep();	//comes from Person abstract class
		
		
		Person p = new SuperHero();
		//how to instantiate an abstract class
		//does not have access to fly method 
		//This will call BOTH constructors.
		
		
	
	}
	
}
