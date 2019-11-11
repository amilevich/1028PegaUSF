package com.example.cafe;

import java.util.Stack;

public class Customer {

	// *************Public Stack of Order************//
	Stack<FoodOrder> foods = new Stack<FoodOrder>();
	Stack<DrinkOrder> drinks = new Stack<DrinkOrder>();

	// *************Private variables************//
	private String name;
	private int num;

	// *************Getters and Setters************//
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// *************Constructor************//

	public Customer() {
		super();
		System.out.println("Would you like to order 1: Food or 2: Drinks 3: Nothing");
		MainDriver.yn = MainDriver.sc.nextLine();
		while (!MainDriver.yn.equals("3")) { // while you still want to order
			if ((MainDriver.yn).equals("1")) { // get food order
				food();
			} else if ((MainDriver.yn).equals("2")) {// get drink order
				drink();
			} else { // user typed in something other than 1, 2, or 3
				System.out.println("Invalid. Please enter either 1, 2, or 3");
			}
			System.out.println("Would you still like to order 1: Food or 2: Drinks 3: Nothing");
			MainDriver.yn = MainDriver.sc.nextLine();
		}
	}

	// *************Food and Drink Creation************//
	private void food() {
		String temp;
		String choice = "";
		FoodOrder f = new FoodOrder();
		System.out.println("Please enter the number of the food item you want");
		while (!MainDriver.validInput) {
			temp = MainDriver.sc.nextLine();
			if (temp.equals("1") || temp.equals("2")) {
				break;
			} else {
				System.out.println("Invalid. Please enter 1 or 2");
			}
		}
		switch (temp) {
		case "1":
			choice = "Chocolate Chip Muffin(s)";
			break;
		case "2":
			choice = "Oatmeal";
			break;
		default:
			choice = "Error in switch for food";
		}

		int tempNum = 0;
		while (!MainDriver.validInput) {
			System.out.println("Please enter the quantity of the food item you want. Limit 5 of each item");
			temp = MainDriver.sc.nextLine();
			int tempAlready = 0;
			tempNum = 0;
			if (temp.equals("0")) {
				break;
			}
			try {
				tempNum = Integer.valueOf(temp);
			} catch (Exception e) {
				System.out.println("Entered value must be an integer");
				continue;
			}
			if (!foods.empty()) { // if you have ordered food check that amount of food type isnt exceeded
				for (int i = 0; i < foods.size(); i++) {
					if (tempAlready == 0) { // accounting for first time you ordered the same food
						if (foods.elementAt(i).getFood() == choice) { // meaning it is in the stack
							System.out.println("debugging 1: " + foods.elementAt(i).getQuantity());
							tempNum = Integer.valueOf(temp) + (foods.elementAt(i).getQuantity());
							tempAlready = foods.elementAt(i).getQuantity();
						}
					} else { // accounting for other times you ordered the food
						if (foods.elementAt(i).getFood() == choice) { // meaning it is in the stack
							tempNum = tempNum + (foods.elementAt(i).getQuantity());
							System.out.println(tempNum);
							System.out.println("debugging 2: " + (foods.elementAt(i).getQuantity()));
							tempAlready = tempAlready + foods.elementAt(i).getQuantity();
						}
					}
				}
			}
			if (tempNum > 5) {
				System.out.println("Invalid. You can only order up to 5 of an item.");
				System.out.println("You have already ordered " + tempAlready);
			} else {
				break;
			}
		}
		if(tempNum > 0) { //only if something was actually ordered with a quantity. greater than 0
		f.setFood(choice); // placer values
		f.setQuantity(Integer.valueOf(temp)); // placer values
		foods.push(f);
		}
	}

	// Implement same thing as food for drinks
	private void drink() {
		String temp;
		String choice = "";
		DrinkOrder d = new DrinkOrder();
		System.out.println("Please enter the number of the drink item you want");
		while (!MainDriver.validInput) {
			temp = MainDriver.sc.nextLine();
			if (temp.equals("1") || temp.equals("2")) {
				break;
			} else {
				System.out.println("Invalid. Please enter 1 or 2");
			}
		}
		switch (temp) {
		case "1":
			choice = "Water(s)";
			break;
		case "2":
			choice = "Coffee(s)";
			break;
		default:
			choice = "Error in switch for food";
		}

		int tempNum = 0;
		while (!MainDriver.validInput) {
			System.out.println("Please enter the quantity of the drink item you want. Limit 5 of each item");
			temp = MainDriver.sc.nextLine();
			int tempAlready = 0;
			tempNum = 0;
			if (temp.equals("0")) {
				break;
			}
			try {
				tempNum = Integer.valueOf(temp);
			} catch (Exception e) {
				System.out.println("Entered value must be an integer");
				continue;
			}
			if (!drinks.empty()) { // if you have ordered food check that amount of food type isnt exceeded
				for (int i = 0; i < drinks.size(); i++) {
					if (tempAlready == 0) { // accounting for first time you ordered the same food
						if (drinks.elementAt(i).getDrink() == choice) { // meaning it is in the stack
							System.out.println("debugging 1: " + drinks.elementAt(i).getQuantity());
							tempNum = Integer.valueOf(temp) + (drinks.elementAt(i).getQuantity());
							tempAlready = drinks.elementAt(i).getQuantity();
						}
					} else { // accounting for other times you ordered the food
						if (drinks.elementAt(i).getDrink() == choice) { // meaning it is in the stack
							tempNum = tempNum + (drinks.elementAt(i).getQuantity());
							System.out.println(tempNum);
							System.out.println("debugging 2: " + (drinks.elementAt(i).getQuantity()));
							tempAlready = tempAlready + drinks.elementAt(i).getQuantity();
						}
					}
				}
			}
			if (tempNum > 5) {
				System.out.println("Invalid. You can only order up to 5 of an item.");
				System.out.println("You have already ordered " + tempAlready);
			} else {
				break;
			}
		}
		if(tempNum > 0) { //only if something was actually ordered with a qty. greater than 0
		d.setDrink(choice); // placer values
		d.setQuantity(Integer.valueOf(temp)); // placer values
		drinks.push(d);
		}

	}

}
