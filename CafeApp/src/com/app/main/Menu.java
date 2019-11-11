package com.app.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


public class Menu{
	
	static boolean isOrdering;
	static ArrayList<String> ord = new ArrayList<>();
	static ArrayList<String> customer = new ArrayList<>();
	
	public static void main(String[] args) {

	}
	
	public static Map<String, Float> myMenu() {
		
		Map<String, Float> items = new HashMap<>();
		
		items.put("Burger", new Float (7.00));
		items.put("Fries", new Float(3.50));
		items.put("Pizza", new Float(6.00));
		items.put("Coke", new Float(3.00));
		items.put("Water", new Float(1.00));
		items.put("Lemonade", new Float(3.00));
		
		return items;
	}
	
	public static void takeOrders() {
		Queue<ArrayList<String>> q = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Chili's here's our menu" + '\n'+ Menu.myMenu());
		
		do {
			
			String order = sc.nextLine();
			
			switch(order) {
			case "Burger" :
				ord.add(order);
				break;
			case "Fries" :
				ord.add(order);
				break;
			case "Pizza" :
				ord.add(order);
				break;
			case "Coke" :
				ord.add(order);
				break;
			case "Water" :
				ord.add(order);
				break;
			case "Lemonade" :
				ord.add(order);
				break;
			}
			
			if(order.contains("No")) {
				isOrdering = false;
				break;
			}else if(ord.size() > 4) {
				System.out.println("Sorry, we have to make sure there's enough to go around.");
				isOrdering = false;
				break;
			}
			System.out.println("Ok so a " + order + " anything else?");
		}
		while(isOrdering = true);
		customer.addAll(ord);
		q.add(customer);
		//add customer to queue
		System.out.println("So you want " + ord + " Customer " + customer.size() + " just ordered.");
		
		for (ArrayList<String> i:q) {
			for(String j:i) {
				System.out.print("Now serving: "+ j + " ");// print queue
				//q.remove();
			}
			System.out.println("\n");
		}
		
		isOrdering = false;
		if(customer.size() <= 2) {
			for (ArrayList<String> i:q) {
				for(String j:i) {
					System.out.print("Now serving: "+ j + " ");// print queue
					//q.remove();
				}
			}
			isOrdering = false;
		}else {
			
			for (ArrayList<String> i:q) {
				for(String j:i) {
					System.out.print(j + " ");// print queue
				}
			}
			ord.clear();
			takeOrders();
		}
		
	}
}
