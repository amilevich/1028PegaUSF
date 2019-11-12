package cafe;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
import cafe.Customer;
import cafe.Food;
import cafe.Drink;
import cafe.Order;

public class Cafe {

	
		
	int order = 0, f, d, auxint;
	Scanner sc = new Scanner(System.in); 
	String name;
	Queue<Order> queue = new LinkedList<>();
	
	String[] food = {"Big Mac", "Sausage Burrito", "Chicken McNuggets"};
	float[] pricefood = {5, 7, 8};
	String[] drink = {"Coca Cola", "Sprite", "Dr Pepper"};
	float[] pricedrink = {1, 1, 1};	
		
     synchronized void ordercompleted() {
		 
		 while(queue.isEmpty())
			 try {
				 notify();
				 wait();
			 } 
		     catch(InterruptedException e) {
		    	 System.out.println("InterruptedException caught");
			 }
		 
		 for(int i = 0; i < 40000; i++);
		 System.out.println("---------------------------------------");
		 System.out.println("\n \nOrder completed");
		 System.out.println(queue.remove());
		 
		 
	 }	
	 
	 synchronized void neworder() {
		 
		 while(queue.size() == 3)
			 try {
				 wait();
			 } 
		     catch(InterruptedException e) {
		    	 System.out.println("InterruptedException caught");
			 }
		 System.out.println("---------------------------------------");
		 System.out.println("Welcome, please what is your name: ");
		 name = sc.nextLine();
		 
		 f = menu(true);
		 d = menu(false);
		 	 
		 queue.add(new Order(++order, new Customer(name), new Food(food[f-1], pricefood[f-1]), new Drink(drink[d-1], pricedrink[d-1])));
	
		 
		 if (queue.size() == 1) {
			 notify();
		 }
		  
	}
	 
	private int menu(boolean opt) {
		
		String aux = (opt)?"eat":"drink";
 		System.out.println("What do you want to " + aux + "\n");
 		String op;
 		
		if (opt) {
			
			System.out.println("1: " + food[0]+ " ------------------- " + pricefood[0]);
			System.out.println("2: " + food[1]+ " ----------- " + pricefood[1]);
			System.out.println("3: " + food[2]+ " --------- " + pricefood[2]);
			
		}
		else {
			
			System.out.println("1: " + drink[0]+ " ----------- " + pricedrink[0]);
			System.out.println("2: " + drink[1]+ " -------------- " + pricedrink[1]);
			System.out.println("3: " + drink[2] + " ----------- " + pricedrink[2]);
		}
		
		do {
		     op = sc.nextLine();
		     auxint = Integer.parseInt(op, 10);
		     
		     if (auxint >= 4 || 0 >= auxint) {
		      
		    	 System.out.println("Please choose a valid option: ");  
		    	 
		     }
		}
		while (auxint >= 4 || 0 >= auxint);		
		
	 return auxint;	
		
	} 
		
		
}
