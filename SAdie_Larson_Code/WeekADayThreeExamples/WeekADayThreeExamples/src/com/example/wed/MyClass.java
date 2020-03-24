package com.example.wed;

public class MyClass {

	public static void main(String[] args) {
		Dog.bark("Bark", "Bark", "Bark", "Bark");
		
		Dog benji = new Dog();
		Dog fifi = new Dog("Fifi", 16, true);
		
		benji.setName("Benji");
		benji.setAge(3);
		benji.setDeceased(false);
		
		benji.details();
		fifi.details();
	}
}
