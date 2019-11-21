package com.example.model;

public class IceCream {

	private String flavor;
	private int sprinkles;
	
	public IceCream() {
	
	}

	public IceCream(String flavor, int sprinkles) {
		super();
		this.flavor = flavor;
		this.sprinkles = sprinkles;
	}
	
	public String getFlavor() {
		return flavor;
	}
	
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	
	public int getSprinkles() {
		return sprinkles;
	}
	
	public void setSprinkles(int sprinkles) {
		this.sprinkles = sprinkles;
	}
	
	@Override
	public String toString() {
		return "IceCream [flavor=" + flavor + ", sprinkles=" + sprinkles + "]";
	}
}
