package com.assignment.cafe;

public class FoodChoiceOrder extends MenuOrder {

	
	public String foodType[] = new String[6];
	private int foodprice;
	
	public  String foodSelect() {
	// Prints menu for food selection
	System.out.print("**********Food MENU*********");

	 foodType[0] = "Hamburger";
	 foodType[1] = "Cheeseburger";
	 foodType[2] = "Chicken Tenders";
	 foodType[3] = "Chicken Wings";
	 foodType[4] = "Lo mein";
	 foodType[5] = "Impossible Burger";
	 
	 
	 System.out.println("Please Select the choice of drinks below or Select 9 to exit menu: ");
	 
	 for(int i = 0; i < foodType.length; i++) {
		 int value = i + 1;
		// validChoice = value;
		
		System.out.println("Choice " + value + ": " + foodType[i]);
		
	 }
	 
	 int temp = scan.nextInt();
	 System.out.println("Your Food choice is " + foodType[temp - 1]  + " with fries");
	
	 
	 return foodType[temp - 1];
	 
	}	
	 
}
