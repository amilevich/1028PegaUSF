package com.homework.cafe;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MainDriver {
	
	static int i = 1;
	public static void main(String[] args) {
	
		
		int randomNum = ThreadLocalRandom.current().nextInt(30000, 40000 + 1);
		
		CustQueue newQueue = new CustQueue();
		Timer t = new Timer(); //Timer to display order that is ready at random intervals.
		do {
			newQueue = firstPrompt(newQueue);
			Order orderUp = newQueue.customerQueue.peek();
			newQueue.customerQueue.remove();
	
			t.schedule(new TimerTask() {
			   
				@Override
			    public void run() {
					CustQueue tempQueue = new CustQueue();
			       System.err.println("Order Up!! For "+ orderUp.getName()+"!");
			       t.cancel();
			    }
			}, 20000, randomNum);
			
			
			
		} while (i!=0); 

		System.out.println("Program Ended");

	}

	public static void prompt(Order x) { //Main Menu before placing placing order.
		Scanner scan = new Scanner(System.in);
		System.out.println("What would you like to order?");

	if(x.drinks.drinksList.isEmpty() && x.foods.foodList.isEmpty()) {
		System.out.println("[1] Order Food");
		System.out.println("[2] Order Drink");
	}
	else {
		System.out.println("[1] Order Food");
		System.out.println("[2] Order Drink");
		System.out.println("[3] Finish Order");
		}
		int input = scan.nextInt();

		switch (input) {
		case 1:
			x.orderFood(); //Display Food/Drink Order Menu accordingly, both defined in Order Class.
			break;
		case 2:
			x.orderDrink(); 
			break;
		case 3:
			System.out.println(x.toString());
			System.out.println("Thank you for eating with us!");
			break;
		}

	}

	public static CustQueue firstPrompt(CustQueue x) { //First entry point into the program, which also calls for prompt() after giving a name;
		Order newOrder = new Order();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to the Cafe!");
		System.out.println("[1]Place New Order.");
		System.out.println("[2]View Order Queue.");
		System.out.println("[3]Exit");

		int input = sc.nextInt();

		switch (input) {
		case 1:
			System.out.println("Welcome, what is your name?");
			String tempName = sc.next();

			newOrder.setName(tempName); 
			prompt(newOrder);
			x.customerQueue.add(newOrder); //After prompt ends, the order will be full 
			System.out.println("Order submitted! Please listen out for your name.");
			break;
		case 2:
			if(x.customerQueue.isEmpty()) { //If queue is empty return none, else return tne Queue toString()
				System.out.println("No Current Queue");
				firstPrompt(x);
			}
			else {
			System.out.println("Current Queue"+ x.toString());
			System.out.println();
			firstPrompt(x);
			}
		case 3:
			System.exit(0);
		}
		return x;

	}

	

}
