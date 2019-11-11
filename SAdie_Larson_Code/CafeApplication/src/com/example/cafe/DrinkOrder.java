package com.example.cafe;

public class DrinkOrder {
	// *************Private variables************//
	private String drink;
	private int quantity;
	private static final String[] drinkChoices = { "1: Water(s)", "2: Coffee(s)" };

	// *************Getters and Setters************//
	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public DrinkOrder() {
		super();
		System.out.println("Drink options: ");

		for (int i = 0; i < drinkChoices.length - 1; i++) {
			System.out.print(drinkChoices[i] + ", ");
		}
		System.out.println(drinkChoices[drinkChoices.length - 1]);

	}

	// *************To String************//
	@Override
	public String toString() {
		return "[" + quantity + " " + drink + "]";
	}
}
