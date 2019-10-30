package com.assignments.day3;

public class Dog {
	public Dog() {

	}

	public static Dog makeDog() {
		Dog dog = new Dog();
		return dog;
	}

	public void barkString() {
		System.out.print("Bark! ");
	}

	public int barkXTimes(int... input) {
		int output = 0;
		for (int i = 0; i < input.length; i++) {
			output += input[i];
		}

		return output;
	}
}
