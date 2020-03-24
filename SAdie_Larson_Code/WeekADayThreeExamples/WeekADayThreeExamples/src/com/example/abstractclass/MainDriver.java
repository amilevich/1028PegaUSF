package com.example.abstractclass;

public class MainDriver {

	// super class is person --> subclass is SuperHero
	public static void main(String[] args) {
		SuperHero sm = new SuperHero();
		sm.eat(); // comes from person AC but is over ride in SuperHero
		sm.fly(); // comes from SuperHero Class
		sm.sleep(); // comes from Person abstract class

		Person me = new SuperHero(); //will load parent first (Person) then child SuperHero();
		me.sleep();
		me.eat();
		// me.fly() ; // cannot do because this is in the reference class of SuperhHero

	}
}
