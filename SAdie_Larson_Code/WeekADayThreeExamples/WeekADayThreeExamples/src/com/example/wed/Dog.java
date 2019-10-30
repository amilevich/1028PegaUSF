package com.example.wed;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Dog {

	private String name;
	private int age;
	private boolean deceased;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isDeceased() {
		return deceased;
	}

	public void setDeceased(boolean deceased) {
		this.deceased = deceased;
	}

	public Dog() {
		System.out.println("This is a no-arg constructor. No dog details.");
	}

	public Dog(String name, int age, boolean deceased) {
		super();
		this.name = name;
		this.age = age;
		this.deceased = deceased;
	}

	public static void bark(String... sound) {
		for (int i = 0; i < sound.length - 1; i++) {
			System.out.print(sound[i] + ", ");
		}
		if (sound.length > 0) {
			System.out.println(sound[sound.length - 1] + ".");
		}
	}

	public void details() {
		String info;
		if (deceased == true) {
			info = "The dog, " + name + ", passed away at " + age + " years old.";
		} else {
			info = "The dog, " + name + ", is " + age + " years old!";
		}
		System.out.println(info);
	}

}
