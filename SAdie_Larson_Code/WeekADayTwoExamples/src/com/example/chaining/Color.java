package com.example.chaining;

public class Color {

	int saturation;
	boolean isBright;
	String baseColor;
	boolean isRainbow;

	Color() {
		this(7, "Red");
		System.out.println("inside no arg constructor");
	}

	public Color(int saturation, String baseColor) {
		this(5, true, "blue", true); // constructor chaining - calling a constructor from another constructor
		System.out.println("inside constructor with two arguments");
	}

	public Color(int saturation, boolean isBright, String baseColor, boolean isRainbow) {
		super();
		
		/*
		 * the first line of any constructor is super();
		 * even if you don't explicitly state it
		 * it calls the constructors of the parent class to make
		 * sure that the parent is fully formed before the subclass
		 * is constructed
		 */
		this.saturation = saturation;
		this.isBright = isBright;
		this.baseColor = baseColor;
		this.isRainbow = isRainbow;
		System.out.println("inside parameterized constructor with 4 arguments");
	}

	/*
	 * A constructor can invoke another constructor of the same class 
	 * by using "this"
	 */
	
	public static void main(String[] args) {
		
		Color blue = new Color(); // will go to this of the two parameters which goes to the four paremeters --> then follows back
		
		
		
	}
}
