package com.homework.cafe;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MainDriver {
	public static void main(String[] args) {
	
		
		int randomNum = ThreadLocalRandom.current().nextInt(30000, 50000 + 1);
		int i = 1;
		CustQueue newQueue = new CustQueue();
		Timer t = new Timer(); //Timer to display order that is ready at random intervals.
		do {
			newQueue = firstPrompt(newQueue);
			Order orderUp = newQueue.customerQueue.getFirst();	
	
			t.schedule(new TimerTask() {
				@Override    
			    public void run() {
			       System.err.println("Order Up!! For "+ orderUp.getName()+"!");
			       t.cancel();
			    }
			}, 20000, randomNum);
			
			
			
		} while (i!=0);

		System.out.println("Program Ended");

	}

	public static void prompt(Order x) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What would you like to order?");

		System.out.println("[1] Order Food");
		System.out.println("[2] Order Drink");
		System.out.println("[3] Finish Order");

		int input = scan.nextInt();

		switch (input) {
		case 1:
			x.orderFood();
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

	public static CustQueue firstPrompt(CustQueue x) {
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
			x.customerQueue.add(newOrder);
			System.out.println("Order submitted! Please listen out for your name.");
			break;
		case 2:
			if(x.customerQueue.isEmpty()) {
				System.out.println("No Current Queue");
				firstPrompt(x);
			}
			else {
			System.out.println(x.toString());
			firstPrompt(x);
			}
		case 3:
			System.exit(0);
		}
		return x;

	}

	

}
