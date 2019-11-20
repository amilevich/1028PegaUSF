package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import com.customer.Customer;
import com.menu.DrinksMenu;
import com.menu.FoodMenu;

public class Methods {

	public static HashMap<String, FoodMenu> createFoodMenu() {
		FoodMenu dumplings = new FoodMenu("Dumplings", 10, 100);
		FoodMenu kebab = new FoodMenu("Kebab", 11, 100);
		FoodMenu chowemin = new FoodMenu("Chowemin", 8, 100);
		FoodMenu chickenCurry = new FoodMenu("Chicken Curry", 13, 100);
		FoodMenu chickenRoast = new FoodMenu("Chicken Roast", 14, 100);
		FoodMenu goatCurry = new FoodMenu("Goat Curry", 17, 100);
		FoodMenu chickenTikka = new FoodMenu("Chicken Tikka", 13, 100);
		FoodMenu sandwich = new FoodMenu("Sandwich", 7, 100);
		FoodMenu burger = new FoodMenu("Burger", 5, 100);

		HashMap<String, FoodMenu> foodMenu = new HashMap<>();
		foodMenu.put("dumplings", dumplings);
		foodMenu.put("kebab", kebab);
		foodMenu.put("Chowemin", chowemin);
		foodMenu.put("chicken curry", chickenCurry);
		foodMenu.put("goat curry", goatCurry);
		foodMenu.put("chicken tikka", chickenTikka);
		foodMenu.put("sandwich", sandwich);
		foodMenu.put("chicken Roast", chickenRoast);
		foodMenu.put("burger", burger);

		return foodMenu;
	}

	public static HashMap<String, DrinksMenu> createDrinksMenu() {
		DrinksMenu soda = new DrinksMenu("Soda", 1, 10);
		DrinksMenu tea = new DrinksMenu("Tea", 2, 10);
		DrinksMenu coffee = new DrinksMenu("Coffee", 4, 10);
		DrinksMenu beer = new DrinksMenu("Beer", 5, 10);

		HashMap<String, DrinksMenu> drinkMenu = new HashMap<>();

		drinkMenu.put("soda", soda);
		drinkMenu.put("tea", tea);
		drinkMenu.put("coffee", coffee);
		drinkMenu.put("beer", beer);

		return drinkMenu;
	}

	public static void printFoodMenu() {
		HashMap<String, DrinksMenu> drinkMenu = Methods.createDrinksMenu();
		HashMap<String, FoodMenu> foodMenu = Methods.createFoodMenu();

		foodMenu.forEach((key, value) -> System.out.println(key.toUpperCase() + "-" + "$" + value.getPrice() + " "));

	}

	public static void printDrinkMenu() {
		HashMap<String, DrinksMenu> drinkMenu = Methods.createDrinksMenu();
		HashMap<String, FoodMenu> foodMenu = Methods.createFoodMenu();

		drinkMenu.forEach(
				(key, value) -> System.out.println(key.toUpperCase() + "-" + "$" + value.getDrinkPrice() + ' '));
	}

	
	static Queue<Customer> customerQueue = new LinkedList<>();

	public static void getOrder() {
		Scanner scanner = new Scanner(System.in);

		ArrayList<FoodMenu> foodList = new ArrayList<>();
		ArrayList<DrinksMenu> drinkList = new ArrayList<>();
		boolean customerFoodOrderEnded = false;
		boolean customerDrinksOrderEnded = false;

		if (customerQueue.size() < 3) {
			System.out.println("Hi, Can i get your name");
			String name = scanner.nextLine();
			System.out.println();
			System.out.println(">>>>>>>>>>>>>>>>>FOOD MENU<<<<<<<<<<<<<<<<<<");
			Methods.printFoodMenu();

			while (!customerFoodOrderEnded) {
				System.out.println("Type what you want");
				String food = scanner.nextLine().trim().toLowerCase();

				HashMap<String, FoodMenu> foodMenu = Methods.createFoodMenu();
				Set<String> foodItemArray = foodMenu.keySet();

				if (foodItemArray.contains(food)) {
					int price = foodMenu.get(food).getPrice();
					System.out.println("Specify quantity?");
					int qty = scanner.nextInt();
					scanner.nextLine();

					FoodMenu foodAdded = new FoodMenu(food, price, qty);
					foodList.add(foodAdded);
				} else {
					System.out.println("Item not found");
				}

				System.out.println("Do you want to add another item?");
				String more = scanner.nextLine().trim();
				if (more.toLowerCase().equals("no")) {
					customerFoodOrderEnded = true;
				}

			}
			System.out.println(">>>>>>>>>>>>>>>>>DRINK MENU<<<<<<<<<<<<<<<<<<");
			Methods.printDrinkMenu();
			

			while (!customerDrinksOrderEnded) {
				HashMap<String, DrinksMenu> drinkMenu = Methods.createDrinksMenu();
				Set<String> drinksItemArray = drinkMenu.keySet();
				System.out.println("Type what you want");
				String drink = scanner.nextLine().trim().toLowerCase();

				if (drinksItemArray.contains(drink)) {
					int price = drinkMenu.get(drink).getDrinkPrice();
					System.out.println("Specify quantity?");
					int qty = scanner.nextInt();
					scanner.nextLine();
					DrinksMenu drinkAdded = new DrinksMenu(drink, price, qty);
					drinkList.add(drinkAdded);
				} else {
					System.out.println("Item not found");

				}

				System.out.println("Do you want another item?");
				String more = scanner.nextLine().trim();
				if (more.toLowerCase().equals("no")) {
					customerDrinksOrderEnded = true;
				}

			}

			Customer customer = new Customer(name, foodList, drinkList);
			customerQueue.add(customer);
			System.out.println("Customer Added");

		}

		else {
			
			System.out.println(">>>>>>>Please allow me a moment<<<<<<<");
			System.out.println(">>>>>>We are running out of staff<<<<<<<<");
			System.out.println(">>>>>>>I will be back with you<<<<<<<<<<<");

			for (int i = 0; i <= 2; i++) {

				System.out.println("I got order for "+ customerQueue.peek().getName().toUpperCase());
				System.out.println(customerQueue.peek().toString());
				System.out.println(customerQueue.peek().getName().toUpperCase()+ ", your total cost is" + customerQueue.peek().getAllCost());
				customerQueue.remove();
			}

		}

	}

}
