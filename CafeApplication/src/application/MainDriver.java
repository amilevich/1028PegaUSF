package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainDriver {
	
	static Queue<Customer> que_cust = new LinkedList<>();
	static int orderNum = 1;
	public static void main(String[] args) {
		Queue<Customer> que_cust = new LinkedList<>();
		boolean open = true; 
		Scanner sc = new Scanner(System.in);
		String y;
		int orderNum = 1;
		ArrayList<String> ar_orders;
		Customer customer; 
		
		while (open == true) {
			System.out.println("Is the cafe open? (Y/N)");
			y = sc.nextLine();
			if (y.equals("N")==true){
				open = false; 
				break;
			}
			System.out.println("Would you like to order food? (Y/N)");
			y = sc.nextLine();
			if (y.equals("N")==true) {
				ar_orders = orderDrink(); 
				Drinks drinks = new Drinks(ar_orders);
				customer = new Customer(orderNum, drinks);
				orderNum += 1;
				que_cust.add(customer);
			} else {
				ar_orders = orderFood(); 
				Food food = new Food(ar_orders); 
				System.out.println("Would you like to order drinks? (Y/N)");
				y = sc.nextLine();
				if (y.equals("Y")==true) {
					ar_orders = orderDrink(); 
					Drinks drinks = new Drinks(ar_orders);
					customer = new Customer(orderNum, food, drinks);
					orderNum += 1;
					que_cust.add(customer);
				} else {
					customer = new Customer(orderNum, food);
					orderNum += 1;
					que_cust.add(customer);
				}
			}
			System.out.println("\n------------Receipt----------------\n");
			System.out.println("Order complete. Your order number is: " + customer.order_num );
			System.out.println("Your food order: " + customer.food);
			System.out.println("Your drink order: " + customer.drinks);
			System.out.println("\n------------Receipt----------------\n");
		}
		System.out.println("\n------------Closing----------------\n");
		System.out.println("Today's orders: " + que_cust);
		System.out.println("Closing. Bye");
		System.out.println("\n------------Closing----------------\n");
	}
	
	static ArrayList<String> orderDrink() {
		Scanner sc = new Scanner(System.in);
		String drinkOrder; 
		boolean finished = false; 
		int amount;
		ArrayList <String> orders = new ArrayList<>();
		
		while (finished == false) {
			System.out.println("Type coke, coffee, or finished:");
			drinkOrder = sc.nextLine(); 
			switch(drinkOrder) {
			case "coke":
				System.out.println("How many?");
				amount = sc.nextInt();
				orders = addOrders(orders, "coke", amount);
				sc.nextLine();
				break;
			case "coffee":
				System.out.println("How many?");
				amount = sc.nextInt();
				orders = addOrders(orders, "coffee", amount);
				sc.nextLine();
				break;
			case "finished":
				finished = true;
				break;
			}
		}
		return orders; 
	}
	
	static ArrayList<String> orderFood() {
		Scanner sc = new Scanner(System.in);
		String foodOrder; 
		boolean finished = false; 
		int amount;
		ArrayList <String> orders = new ArrayList<>();
		
		while (finished == false) {
			System.out.println("Type cake, toast, or finished:");
			foodOrder = sc.nextLine(); 
			switch(foodOrder) {
			case "cake":
				System.out.println("How many?");
				amount = sc.nextInt();
				orders = addOrders(orders, "cake", amount);
				sc.nextLine();
				break;
			case "toast":
				System.out.println("How many?");
				amount = sc.nextInt();
				orders = addOrders(orders, "toast", amount);
				sc.nextLine();
				break;
			case "finished":
				finished = true;
				break;
			}
		}
		return orders; 
	}
		
	static ArrayList<String> addOrders(ArrayList<String>orders, String name, int amount){
		amount -= 1;  
		for (int i=amount; i>=0; i--) {
			orders.add(name);
		}
		return orders;
	}

}
