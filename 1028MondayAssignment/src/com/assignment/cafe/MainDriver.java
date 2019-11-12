package com.assignment.cafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MainDriver {
	public static void showMenus(List<MenuItem> menuList) {
		for(MenuItem i:menuList) {
//			System.out.print(i.itemType + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Menu menu = new Menu();
//		menu.viewMenu();
//		showMenu();
		

		Queue<List<MenuItem>> foodQ = new LinkedList<>();

		List<MenuItem> menuList = new LinkedList<MenuItem>();

		MenuItem pastry = new Food("pastry", 2);
		MenuItem sandwich = new Food("sandwich", 4);
		MenuItem coffee = new Drink("coffee", 2);
		MenuItem tea = new Drink("tea", 2);

		menuList.add(pastry);
		menuList.add(sandwich);
		menuList.add(coffee);
		menuList.add(tea);

//		for (MenuItem i : menuList) {
//			System.out.println(i.itemType + ".......$" + i.price);
//		}
		
		showMenu(menuList);
		
//		promptCustomer(menuList);

		showMenus(menuList);
//		System.out.println(menuList);

		foodQ.add(menuList);
//		System.out.println(foodQ);

//		Iterator it = menuItems.iterator();
//		System.out.println(menuItems);

//		Iterator it2 = drinkList.iterator();
//		while (it2.hasNext()) {
////			System.out.println(it2.next());
//		}
	}

	public static void promptCustomer(List<MenuItem> menuList) {
		// TODO Auto-generated method stub
		 System.out.println("Welcome to Cafe CZR!");
		 
		//		 showMenus(null);
		 showMenus(menuList);
		 System.out.println("select an item");
		 Scanner scan = new Scanner(System.in);
		 int itemChoice = scan.nextInt();
		 
		
	}

	// display UI welcoming customer to restaurant
	// ask customer what they want

	static void showMenu(List<MenuItem> menuList) {
//		System.out.println("Welcome to CZR Cafe!");
//		System.out.println("May we take your order?");
//
//		System.out.println();
//
//		System.out.println("        ~ Menu ~  ");
//		System.out.println(" 1. Coffee.........$2 ");
//		System.out.println(" 2. Tea............$2 ");
//		System.out.println(" 3. Pastry.........$2 ");
//		System.out.println(" 4. Sandwich.......$4 ");
//		System.out.println();
		
		System.out.println("Welcome to Cafe CZR");
		System.out.println();
		for(MenuItem i:menuList) {
			System.out.println(i.itemType + ".............$" + i.price);
//			System.out.println();
		}
		System.out.println();
		System.out.println("What would you like to order? Select 1, 2, 3, or 4");
		Scanner sc = new Scanner(System.in);
		int orderChoice = sc.nextInt();

//			System.out.println("May I take your order?");

			System.out.println();

			switch (orderChoice) {
			case 1:
				System.out.println("You ordered pastry");
				break;
			case 2:
				System.out.println("You ordered sandwich");
				break;
			case 3:
				System.out.println("You ordered a coffee");
				break;
			case 4:
				System.out.println("You ordered a tea");
				break;
			
			}
			System.out.println();
			System.out.println("Thank you for your order");


	}

	// create customer class that receives

}
