package com.assignment.cafe;

import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;

public  class MenuOrder {
	
	Scanner scan = new Scanner(System.in);
	
	static Queue<String> order = new LinkedList<String>();
	
	Object[] orders2 = {order};
	
	public static String name;
	public static String sName;
	public static String tPrice;
		
	//public abstract String foodSelect();
	
	//MenuOrder orderId = new DrinksOrder();
	
		public static void main(String[] args) {
		
	
			
		
			
			MenuOrder orderId = new MenuOrder();
			
			orderId.intro();
		
			
		}
		@Override
		public String toString() {
			
			return String.format("Your Food choice is " + name  + " with fries" + " with a " + sName + " drink " +" for $" + tPrice) ;
		}
		//Initial menu with  Introduction
		public void intro() {
			int menuOrder = 0;
			int choice;
			menuOrder++; // Order Counter
			  
			System.out.println("********Hello, Weclome to the Haitian Cafe*********");
			System.out.println("Would you like to order a Meal(Food and Drink) or just a Drink");
			System.out.println("For menu order #" + menuOrder);
			System.out.println("Please select an option(1,2, 3) below");
			System.out.println("1)Meal: ");
			System.out.println("2)Drink Only: ");
			System.out.println("3)Exit: ");
			choice = scan.nextInt();
			
			//User has the option of choosing a drink aft they select meal
			if(choice == 1) {// Selection of meal which calls methods from the drink class
				System.out.println("You select the meal menu");
				DrinksOrder id = new DrinksOrder();
				
				String name = id.foodSelect();
				String sName = id.drinksSelect();
				double tPrice = id.getPrice();
				String sPrice = Double.toString(tPrice);
				
				//Stores the choice's of food/drink and price a queue
				order.add(name);
				order.add(sName);
				order.add(sPrice);
				
				//Prints out the queue the meal
				for(int i=0; i < orders2.length ; i++) {
					   
					   System.out.print(orders2[i].toString());
				   }
				    
			}
			//selects just the drink portion 
			else if(choice == 2) {
				System.out.println("You selected the Drink Menu!!");
			  DrinksOrder id = new DrinksOrder();
			    
			  	//Variables stored from different methods in drinkOrder class
			   String name = id.drinksSelect();
			   double tempPrice = id.getPrice();
			   String totalPrice = Double.toString(tempPrice);
			  
			   //Places choices in the Queue
			  order.add(name);
			  order.add(totalPrice);
			  
			  	
			   for(int i=0; i < orders2.length ; i++) {
				   
				   System.out.print(orders2[i].toString());
			   }
			    
			 
			  
			    
			}
			    
			    else if (choice == 3) {
			    	
			    	 for(int i=0; i < orders2.length ; i++) {
						   
						   System.out.print(orders2[i].toString());
					   }
			    	
			    	System.exit(0);
			    }
			
			    else {
			    	System.out.println("Invalid choice. Please try again");
			    
			 
			    }
			    
			  
			   
			}
		}


