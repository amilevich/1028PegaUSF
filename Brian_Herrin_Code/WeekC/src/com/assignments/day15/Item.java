package com.assignments.day15;

public class Item {
	private String name;
	private Float price = 0.0f;
	private Integer timeUnitsToProduce = 0;
	private Float cost = 0.0f;
	// private SpecialRequest specialRequests;
	
	public Item(String newName, float newPrice) {
		this.name = newName;
		this.setPrice(newPrice);
		this.cost = newPrice*0.75f;
		this.timeUnitsToProduce = (int) (cost*(60/7.25));
	}
	public Item(String newName, float newPrice, int newTimeUnits) {
		this.name = newName;
		this.setPrice(newPrice);
		this.timeUnitsToProduce = newTimeUnits;
		this.cost = ((timeUnitsToProduce/60)*7.25f);
	}
	public Item(String newName, float newPrice, int newTimeUnits, float newCost) {
		this.name = newName;
		this.setPrice(newPrice);
		this.timeUnitsToProduce = newTimeUnits;
		this.cost = newCost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String toString() {
		return name + ": $" + price;
	}
}
