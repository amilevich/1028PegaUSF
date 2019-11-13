package com.example.chaining;

public class Color {
	int saturation;
	boolean isBright;
	String baseColor;
	boolean IsRainbow;
	
	Color(){
		this(7, "Red");
		System.out.println("inside no arg constructor");
		
	}

	public Color(int saturation, String baseColor) {
		this(5, true, "Blue", true);
		System.out.println("inside the constructor with 2 arguements");
	}

	public Color(int saturation, boolean isBright, String baseColor, boolean isRainbow) {
		super();// 1st line of any constructor is super even if you dont explicitly state it. Calls constructors
		/* of parent class to make sure the parent is fully formed before the subclass is constructed
		 * 
		 */
		this.saturation = saturation;
		this.isBright = isBright;
		this.baseColor = baseColor;
		IsRainbow = isRainbow;
		System.out.println("inside parameteried constructor with 4 arguments");
	}
	
	public static void main(String[] args) {
		Color blue = new Color(6, "White");
	}
	/*
	 *  constructor chaining
	 *  can invoke another constructor of the same class by using keyword "this"
	 */
	
}
