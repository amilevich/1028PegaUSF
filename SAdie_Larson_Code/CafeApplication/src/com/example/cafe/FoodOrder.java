package com.example.cafe;

public class FoodOrder {
	// *************Private variables************//
	private String food;
	private int quantity;
	private static final String[] foodChoices = { "1: Chocolate Chip Muffin(s)", "2: Oatmeal" };

	// *************Getters and Setters************//
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public FoodOrder() {
		super();
		System.out.println("Food options: ");

		for (int i = 0; i < foodChoices.length - 1; i++) {
			System.out.print(foodChoices[i] + ", ");
		}
		System.out.println(foodChoices[foodChoices.length - 1]);

	}

	// *************To String************//
	@Override
	public String toString() {
		return "[" + quantity + " " + food + "]";
	}


}
