package com.cafe_app;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainService {

	static boolean a = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// drink object as a linkedlist with type QUEUE
		    Queue<DrinkOrder> drink = new LinkedList<DrinkOrder>();
		   // LinkedList<FoodOrder> food = new LinkedList<FoodOrder>(); Alternative approach if I want to use FoodOrder Class
			Scanner myObj = new Scanner(System.in);
			// program logic
			while(a == true) {
				System.out.println("Enter your name, drink and food. ");
				DrinkOrder temp = new DrinkOrder(myObj.next(), myObj.next(), myObj.next());
				//FoodOrder temp2 = new FoodOrder(myObj.next()); alternative way of using linkedlist by calling FoodOrder class but I preferred to use this way
				//Constructor display
				System.out.println("Customer: " + temp.getCustomer()+" drink: "+ temp.getDrinkName() + " food: " + temp.getFoodOrder());
				//added into arraylist, rest is just displaying the arraylist and user input
				drink.add(temp);
				System.out.println("The order list is as follows: " + drink);
				System.out.println("Are there any other customer ? Select, 1 to continue adding new requests, select 2 to delete last request, select 3 to delete all requests, select 4 to exit the system.");
				int newInput = myObj.nextInt();
				if(newInput==1)
					a=true;
				else if(newInput==2) {
					drink.remove();
					a=true;
					System.out.println("The order list is as follows: " + drink);
				}
				else if(newInput==3) {
					drink.clear();
					a=true;
					System.out.println("The order list is as follows: " + drink);
				}
				else
					break;		
			}
	}
}
