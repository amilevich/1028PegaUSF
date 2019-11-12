package com.assignment.cafe;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class DrinksOrder extends FoodChoiceOrder {
	
	public static String drinkname;
	private double price = 0;

	
	
	
	
	public DrinksOrder() {
		super();
		
		
	}
	
	
	public DrinksOrder(String drinkname, double price) {
		
	
		
	}
	
	//Selction fot the drinks
	public String drinksSelect() {
		
	 String drinkType[] = new String[8];
		
	System.out.print("**********DRINKS MENU*********");

	 drinkType[0] = "Sprite";
	 drinkType[1] = "Pepsi";
	 drinkType[2] = "Coca-Cola";
	 drinkType[3] = "Orange Fanta";
	 drinkType[4] = "Diet-Coke";
	 drinkType[5] = "HIC Fruit Punch";
	 drinkType[6] = "Tea";
	 drinkType[7] = "Coffee";
	 
	
	 

	 
	 System.out.println("Please Select the choice of drinks below or Select 9 to exit menu: ");
	 
	
      // Loop to read the array for the menu
	 for(int i = 0; i < drinkType.length; i++) {
		 int value = i + 1;
		// validChoice = value;
		
		System.out.println("Choice " + value + ": " + drinkType[i]);
		
		drinkname = drinkType[i]; 
		
		
	 	}
	
	
	 
	 
	 
	 int temp = scan.nextInt();
	System.out.println("Your drink choice is " + drinkType[temp -1]  + " at ");
	 findingValue(temp);
	
	
	
	 return drinkType[temp-1];
	}
    // Getters ans setters for the price
	public double getPrice() { 
		
		return price;
	}


	public void setPrice(double value) {
	
		this.price = price + value;
	}
	//Method to set the price and read it back out into the program
	public double findingValue(int option) {
	
		double fPrice;
		
		switch(option) {
		case 1: 
			setPrice(4.25);
			System.out.println(" $" + getPrice());
			
			return getPrice();
		case 2: 
			setPrice(4.25);
			System.out.println(" $" + getPrice());
			
			return getPrice();
		case 3: 
			setPrice(4.25);
			System.out.println(" $" + getPrice());
			return getPrice();
		case 4: 
			setPrice(4.25);
			System.out.println(" $" + getPrice());
			return getPrice();
		case 5: 
			setPrice(5.50);
			System.out.println(" $" + getPrice());
			return getPrice();
		case 6: 
			setPrice(6.35);
			System.out.println(" $" + getPrice());
			return getPrice();
		case 7: 
			setPrice(4.75);
			System.out.println(" $" + getPrice());
		
			return getPrice();
		case 8: 
			setPrice(5.02);
			System.out.println(" $" + getPrice());
			
			return getPrice();
			
		default:
			 System.out.println("Invalid choice");
			 return getPrice();

		
		}
	  
	}
	
	// Selection to Add another drink, Program is not finish, so method has is not being called in program just a yet.
	public void addingAnother() {
		String c;
		
		
		
		System.out.println("Would you like to add another drink: ");
		c = scan.next();
		
		
		if(c.equals("Y") || c.equals("y")) {
			
			drinksSelect();
			
			
		}
		else if(c.equals("N") || c.equals("n")) {
			System.out.print("You choose not to add no more drinks\n\n");
			MenuOrder ref = new DrinksOrder();
		     ref.intro();
		}
		
		else{
			System.out.println("Invalid Choice!!");
			
		}
	}


}
