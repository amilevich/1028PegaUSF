package com.assignment.cafe;

import java.util.ArrayList;
import java.util.Scanner;


public class MenuOrder {
	
	
	//ArrayList to store food data

	static Scanner input = new Scanner(System.in);
	static ArrayList<String> orderList = new ArrayList<String>();
	static Food food = new Food();
	static Drink drink = new Drink();


	
//	public static void getAll() {
//		for ( int i = 0; i< orderList.size(); i++) {
//			System.out.println(orderList.get(i));
//		}
//		
//	}
	
	


	public static void menu() {
		System.out.println("***********************************************************************************************");
		System.out.println("|                                                                                             |");
		System.out.println("|                                                                                             |");
		System.out.println("|                             	      Cafe Victory                                            |");
		System.out.println("|                                                                                             |");
		System.out.println("|*********************************************************************************************|");
		System.out.println("|                                                                                             |");
		System.out.println("|                                                                                             |");
		System.out.println("|                                                                                             |");
		System.out.println("|                                Choose from our option:                                      |");
		System.out.println("|                                                                                             |");
		System.out.println("|                                      1. Food                                                |");
		System.out.println("|                                                                                             |");
		System.out.println("|                                      2. Drink                                               |");
		System.out.println("|                                                                                             |");
		System.out.println("|                                      3. Checkout                                            |");
		System.out.println("|                                                                                             |");
		System.out.println("|                                                                                             |");
		System.out.println("|                                                                                             |");
		System.out.println("|                                                                                             |");
		System.out.println("***********************************************************************************************");
		
		// Switch cases for menu option
		int option = input.nextInt();
		

		
		switch(option) {
		case 1 : 
			System.out.println("***********************************************************************************************");
			System.out.println("|                                                                                             |");
			System.out.println("| 				Food Options				|"); 
			System.out.println("|                                                                                             |");
			System.out.println("***********************************************************************************************");
			System.out.println("|                                                                                             |");
			System.out.println("| 1. " + food.bagel + "......................" + food.bagelPrice + "                                                     |");
			System.out.println("| 2. " + food.creamCheese + "......................" + food.creamCheesePrice + "                                                    |");
			System.out.println("| 3. " + food.icedLemonLoafCake + "......................" + food.cakePrice + "                                           |");
			System.out.println("|                                                                                             |");
			System.out.println("|     Total balance: " + (food.getTotalPrice() + drink.getTotalPrice()) +"                                                                      |");
			System.out.println("***********************************************************************************************");
			
			int foodOption = input.nextInt();
			if(foodOption != 1 && foodOption != 2) {
				orderList.add(food.icedLemonLoafCake);
				food.setTotalPrice(food.cakePrice);
				System.out.println("Obtained Iced Lemone Loaf Cake! ٩(･ᴗ･)و ");
				System.out.println("                                        ");
				System.out.println("Your current orders \n" + orderList.toString());
				System.out.println("                                        ");
				System.out.println("*****Total Balance: " + (food.getTotalPrice() + drink.getTotalPrice()) + " ********");
				menu();
			}
			else if(foodOption != 1 && foodOption != 3) {
				orderList.add(food.creamCheese);
				food.setTotalPrice(food.creamCheesePrice);
				System.out.println("Obtained Cream Cheese! ٩(･ᴗ･)و");
				System.out.println("                                        ");
				System.out.println("Your current orders \n" + orderList.toString());
				System.out.println("                                        ");
				System.out.println("*****Total Balance: " + (food.getTotalPrice() + drink.getTotalPrice()) + " ********");
				menu();
			}
			else if(foodOption != 2 && foodOption != 3) {
				orderList.add(food.bagel);
				food.setTotalPrice(food.bagelPrice);
				System.out.println("Obtained Plain Bagel! ٩(･ᴗ･)و");
				System.out.println("                                        ");
				System.out.println("Your current orders \n" + orderList.toString());
				System.out.println("                                        ");
				System.out.println("*****Total Balance: " + (food.getTotalPrice() + drink.getTotalPrice()) + " ********");
				menu();
			}
			
			break;
		
		case 2:
			System.out.println("***********************************************************************************************");
			System.out.println("|                                                                                             |");
			System.out.println("| 				Drink Options			                              |"); 
			System.out.println("|                                                                                             |");
			System.out.println("***********************************************************************************************");
			System.out.println("|                                                                                             |");
			System.out.println("| 1. " + drink.icedCoffee + "......................" + drink.iCoffeePrice + "                                                     |");
			System.out.println("| 2. " + drink.whiteChocolateMocha + "......................" + drink.wCMPrice + "                                           |");
			System.out.println("| 3. " + drink.water + "......................" + drink.waterPrice+ "                                                         |");
			System.out.println("|                                                                                             |");
			System.out.println("|     Total balance: " + (food.getTotalPrice() + drink.getTotalPrice()) + "                                                                      |");
			System.out.println("***********************************************************************************************");
			
			int drinkOption = input.nextInt();
			if(drinkOption != 1 && drinkOption != 2) {
				orderList.add(drink.water);
				drink.setTotalPrice(drink.waterPrice);
				System.out.println("Obtained Water! ٩(･ᴗ･)و ");
				System.out.println("                                        ");
				System.out.println("Your current orders \n" + orderList.toString());
				System.out.println("                                        ");
				System.out.println("*****Total Balance: " + (food.getTotalPrice() + drink.getTotalPrice()) + " ********");
				menu();
			}
			else if(drinkOption != 1 && drinkOption != 3) {
				orderList.add(drink.whiteChocolateMocha);
				drink.setTotalPrice(drink.wCMPrice);
				System.out.println("Obtained White Chocolate Mocha! ٩(･ᴗ･)و");
				System.out.println("                                        ");
				System.out.println("Your current orders \n" + orderList.toString());
				System.out.println("                                        ");
				System.out.println("*****Total Balance: " + (food.getTotalPrice() + drink.getTotalPrice()) + " ********");
				menu();
			}
			else if(drinkOption != 2 && drinkOption != 3) {
				orderList.add(drink.icedCoffee);
				drink.setTotalPrice(drink.iCoffeePrice);
				System.out.println("Obtained Iced Coffee! ٩(･ᴗ･)و");
				System.out.println("                                        ");
				System.out.println("Your current orders \n" + orderList.toString());
				System.out.println("                                        ");
				System.out.println("*****Total Balance: " + (food.getTotalPrice() + drink.getTotalPrice()) + " ********");
				menu();
			}
			
			break;
			
		case 3:

			System.out.println("***********************************************************************************************");
			System.out.println("|                                                                                             |");
			System.out.println("| 				Checkout																	  |"); 
			System.out.println("|                                                                                             |");
			System.out.println("***********************************************************************************************");
			System.out.println("|                                                                                             |");
			System.out.println("|      Your order:                                                                            |");

			
			for ( int i = 0; i< orderList.size(); i++) {
				System.out.println("        *" + orderList.get(i).toString());
			}
			
			System.out.println("|      Total Balance: " + (food.getTotalPrice() + drink.getTotalPrice()) + "                                                                     |");
			System.out.println("***********************************************************************************************");
			orderList.clear();
			food.setZero();
			drink.setZero();
			menu();
		}
	}

}
	
     
	 class Food{
		public String foodType;
		public double bagelPrice = 1.0;
		public double creamCheesePrice = .5;
		public double cakePrice = 2.0;
		public double totalPrice = 0.0;
		public String bagel = "Plain Bagel";
		public String creamCheese = "Cream Cheese";
		public String icedLemonLoafCake = " Iced Lemon Loaf Cake";
		
		
		
		public void setZero() {
			totalPrice = 0;
		}
		
		// Food Getters and Setters 
		public String getFoodType() {
			return foodType;
		}
		public void setFoodType(String foodType) {
			this.foodType = foodType;
		}
		public String getBagel() {
			return bagel;
		}
		public void setBagel(String bagel) {
			this.bagel = bagel;
		}
		public String getCreamCheese() {
			return creamCheese;
		}
		public void setCreamCheese(String creamCheese) {
			this.creamCheese = creamCheese;
		}
		public String getIcedLemonLoafCake() {
			return icedLemonLoafCake;
		}
		public void setIcedLemonLoafCake(String icedLemonLoafCake) {
			this.icedLemonLoafCake = icedLemonLoafCake;
		}
		public double getBagelPrice() {
			return bagelPrice;
		}
		public void setBagelPrice(double bagelPrice) {
			this.bagelPrice = bagelPrice;
		}
		public double getCreamCheesePrice() {
			return creamCheesePrice;
		}
		public void setCreamCheesePrice(double creamCheesePrice) {
			this.creamCheesePrice = creamCheesePrice;
		}public double getCakePrice() {
			return cakePrice;
		}
		public void setCakePrice(double cakePrice) {
			this.cakePrice = cakePrice;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice += totalPrice;
		}
		
		
	}
	
	
	
	
	
	class Drink{
		
		public String drinkType;
		public double wCMPrice = 4.0;
		public double iCoffeePrice = 3.0;
		public double waterPrice = 100.0;
		public double totalPrice = 0.0;
		public String whiteChocolateMocha = "White Chocolate Mocha";
		public String icedCoffee = "Iced Coffee";
		public String water = "Water";
		
		
		public void setZero() {
			totalPrice = 0;
		}
		
		
		// Drinks Getter and Setter

		public String getDrinkType() {
			return drinkType;
		}
		public void setDrinkType(String drinkType) {
			this.drinkType = drinkType;
		}
		public double getWCMPrice() {
			return wCMPrice;
		}
		public void getWCMPrice(double wCMPrice) {
			this.wCMPrice = wCMPrice;
		}
		public double getICoffeePrice() {
			return iCoffeePrice;
		}
		public void getICoffeePrice(double iCoffeePrice) {
			this.iCoffeePrice = iCoffeePrice;
		}
		public String getWhiteChocolateMocha() {
			return whiteChocolateMocha;
		}
		public void setWhiteChocolateMocha(String whiteChocolateMocha) {
			this.whiteChocolateMocha = whiteChocolateMocha;
		}
		public String getIcedCoffee() {
			return icedCoffee;
		}
		public void setIcedCoffee(String icedCoffee) {
			this.icedCoffee = icedCoffee;
		}
		public String getWater() {
			return water;
		}
		public void setWater(String water) {
			this.water = water;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice += totalPrice;
		}
		
		
		
	}


