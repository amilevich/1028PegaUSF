package com.example.chaining;

public class Color {

	int saturation;
	boolean isBright;
	String baseColor;
	boolean isRainbow;
	
	Color(){
		this(7, "Red");
		System.out.println("inside no arg constructor");
	}

	public Color(int saturation, String baseColor) {
		this(5, true, "Blue", true);
		System.out.println("inside the constructor with 2 arguments");
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
	 * constructor chaining
	 * a constructor can invoke another constructor of the same class
	 * by using keyword "this"
	 */
	
	public static void main(String[] args) {
		Color blue = new Color(6, "White");
	}
	
}
