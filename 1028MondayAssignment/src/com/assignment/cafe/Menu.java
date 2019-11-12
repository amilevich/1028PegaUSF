package com.assignment.cafe;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class Menu{	 

	

	
	
public  void CafeMenu() {
	
	boolean ordering = true;
	do {
	//food name array list
	Food food = new Food();
	ArrayList array = new ArrayList();
	
	//food price array list
	Drinks foodName = new Drinks();
	ArrayList foodPrice = new ArrayList();
	
	//drink name array list
	Drinks drink = new Drinks();
	ArrayList arrDrinks = new ArrayList();
	
	//drink price array list
	Drinks price = new Drinks();
	ArrayList arrPrice = new ArrayList();	
	

	Scanner scanner = new Scanner(System.in);
	System.out.println();
	System.out.println("|==================================================|");
	System.out.println("|==================================================|");
	System.out.println("|******** WELCOME TO CRISTIAN'S CAFE **************|");
	System.out.println("|==================================================|");
	System.out.println("|                                                  |");
	System.out.println("|Please choose your preferences                    |");
	System.out.println("|==================================================|");
	System.out.println("|                                                  |");
	System.out.println("|-------------- (1)DRINKS--------------------------|");
	System.out.println("|                                                  |");
	System.out.println("|==================================================|");
	System.out.println("|                                                  |");
	System.out.println("|---------------(2)FOOD----------------------------|");
	System.out.println("|                                                  |");
	System.out.println("|==================================================|");
	
	// main menu
            int options = scanner.nextInt();
            
     
            switch(options) {
            case(1):
            	System.out.println("1.FRAPPUCINO");
            	System.out.println("2.HOT COFFEE");
            	System.out.println("3.ICED COFFEE");
            	System.out.println("4.JUICES");
            	System.out.println("5.HOT & COLD TEAS");
            	break;
    		
            case(2):
            	System.out.println("1.SANDWICHES");
   		        System.out.println("2.OMELETS");
   		        System.out.println("3.QUESADILLAS");
   		        break;
   		default:
       	 System.out.println("SORRY!!! youu need to select etiher option 1 or option 2!");   			
            	
            }// end of options switch 
            
            //drinks menu
            
           
            if(options == 1) {
            	int drinksOptions = scanner.nextInt();
            	switch(drinksOptions) {
            	case(1):
            		System.out.println("");
            	    System.out.println("Our Frapucinos Are: ");
            	    System.out.println("=====================");
            	    System.out.println("1.Chocolate Moca Frappucino ------------$2.35");
            	    System.out.println("2.Eggnog Frappucinno--------------------$1.75");
            	    System.out.println("3.Caramel Moca Frappucino---------------$2.50");
            	    System.out.println();
            	    
            	    //option frapuccino
            	    int drinkOptionFrappucino = scanner.nextInt();
            	    if(drinkOptionFrappucino  != 2 && drinkOptionFrappucino  !=3) {
            	    	array.add(drink.chocoMoca);
            	        array.add(drink.chocoMocaPrice);
            	    	System.out.println(array);
            	    }
            	    else if (drinkOptionFrappucino != 1 && drinkOptionFrappucino !=3) {
            	    	array.add(drink.eggFrappucino);
            	    	array.add(drink.eggFrappucinoPrice);
            	    	System.out.println(array);
            	    }
            	    else if(drinkOptionFrappucino != 2 && drinkOptionFrappucino !=1) {
            	    	array.add(drink.caramelFrappucino);
            	    	array.add(drink.caramelFrappucinoPrice);
            	    	System.out.println(array);
            	    }
            	    
            	    break;
            	    
            	case(2):
            		System.out.println();
            	    System.out.println("Our Hot Coffee Are: ");
            	    System.out.println("====================");
            	    System.out.println("1.American Coffee-------------$2.00");
            	    System.out.println("2.Dominican Coffee------------$2.15");
            	    System.out.println("3.African Coffee--------------$2.50");
            	    System.out.println();
            	    
            	    //option hot coffee
            	    int drinkOptionHotCoffee = scanner.nextInt();
            	    if(drinkOptionHotCoffee  != 2 && drinkOptionHotCoffee  !=3) {
            	    	array.add(drink.ameCofee);
            	    	array.add(drink.ameCoffePrice);
            	    	System.out.println(array);
            	    }
            	    else if (drinkOptionHotCoffee != 1 && drinkOptionHotCoffee !=3) {
            	    	array.add(drink.domCoffee);
            	    	array.add(drink.domCoffeePrice);
            	    	System.out.println(array);
            	    }
            	    else if(drinkOptionHotCoffee!= 2 && drinkOptionHotCoffee !=1) {
            	    	array.add(drink.afriCoffee);
            	    	array.add(drink.afriCoffeePrice);
            	    	System.out.println(array);
            	    }
            	    
            	    break;
            	    
            	case(3):
            		System.out.println();
            	    System.out.println("Our Iced Coffee Are: ");
            	    System.out.println("1.Iced Macchiato-------------$1.80");
            	    System.out.println("2.Iced Latte-----------------$1.60");
            	    System.out.println("3.Iced Coffee----------------$1.75");
            	    System.out.println("");
            	    
            	    //Iced Coffee
            	    int drinkOptionIcedCoffe = scanner.nextInt();
            	    if(drinkOptionIcedCoffe  != 2 && drinkOptionIcedCoffe  !=3) {
            	    	array.add(drink.icedMac);
            	    	array.add(drink.icedMacPrice);
            	    	System.out.println(array);
            	    }
            	    else if (drinkOptionIcedCoffe != 1 && drinkOptionIcedCoffe !=3) {
            	    	array.add(drink.icedLatte);
            	    	array.add(drink.icedLattePrice);
            	    	System.out.println(array);
            	    }
            	    else if(drinkOptionIcedCoffe!= 2 && drinkOptionIcedCoffe !=1) {
            	    	array.add(drink.icedCoffee);
            	    	array.add(drink.icedCoffeePrice);
            	    	System.out.println(array);
            	    }
            	    else  {
            	    	System.out.println("Please Make An Iced Coffee Selection Only");
            	    }
            	    break;
            	    
            	case(4):
            		System.out.println("");
            	System.out.println("Our Juices Are: ");
            	System.out.println("1.Apple Juice-----------------$3.00");
            	System.out.println("2.Orange Juice----------------$2.50");
            	System.out.println("3.Mango Juice-------------------$2.75");
            	System.out.println("");
            	
                //Juices
        	    int drinkOptionJuices = scanner.nextInt();
        	    if(drinkOptionJuices  != 2 && drinkOptionJuices  !=3) {
        	    	array.add(drink.applJ);
        	    	array.add(drink.appJPrice);
        	    	System.out.println(array);
        	    }
        	    else if (drinkOptionJuices != 1 && drinkOptionJuices !=3) {
        	    	array.add(drink.OrangeJ);
        	    	array.add(drink.OrangeJPrice);
        	    	System.out.println(array);
        	    }
        	    else if(drinkOptionJuices!= 2 && drinkOptionJuices !=1) {
        	    	array.add(drink.mangoJ);
        	    	array.add(drink.mangoJPrice);
        	    	System.out.println(array);
        	    }
        	    else {
        	    	System.out.println("Please Make An Iced Coffee Selection Only");
        	    }
            	break;
            	
            	case(5):
            		System.out.println("");
            	System.out.println("Our Teas Are: ");
            	System.out.println("1.Hot Tea--------------------------$2.00");
            	System.out.println("2.Cold Tea-------------------------$2.00");
            	
                //Teas
        	    int drinkOptionTeas = scanner.nextInt();
        	    if(drinkOptionTeas  != 2 && drinkOptionTeas  !=3) {
        	    	array.add(drink.hotT);
        	    	array.add(drink.hotTPrice);
        	    	System.out.println(array);
        	    }
        	    else if (drinkOptionTeas != 1 && drinkOptionTeas !=3) {
        	    	array.add(drink.coldT);
        	    	array.add(drink.coldTPrice);
        	    	System.out.println(array);
        	    }
        	    else {
        	    	System.out.println("Please Make An Iced Coffee Selection Only");
        	    }
            	break;
            	
            	
            	
            	default: 
            		System.out.println(" You need to choose an option from the drinks ");
            		
            	
            	
            	
            	}// end of drinksOptions switch statement  
            	
            		 
            	 }// end of drinks if statement
           
            if(options == 2) {
            	int foodOptions = scanner.nextInt();
            	switch(foodOptions) {
            	
            	case(1):
            		System.out.println();
        	    System.out.println("Our Sandwiches Are: ");
        	    System.out.println("========================================");
        	    System.out.println("1.Chihcken Sandwich----------------$3.50");
        	    System.out.println("2.Ham & Cheese Sandwich------------$3.15");
        	    System.out.println("3.Turkey Sandwich-------------------$3.50");
        	    System.out.println();
        	    
        	    //option chicken
        	    int foodOptionChoice = scanner.nextInt();
        	    if(foodOptionChoice != 2 && foodOptionChoice !=3) {
        	    	array.add(food.chickenSandwich);
        	    	array.add(food.chickenSandwichPrice);
        	    	System.out.println(array);
        	    }
        	    else if (foodOptionChoice != 1 && foodOptionChoice !=3) {
        	    	array.add(food.hamCheeseSandwich);
        	    	array.add(food.hamCheesePrice);
        	    	System.out.println(array);
        	    }
        	    else if(foodOptionChoice != 2 && foodOptionChoice !=1) {
        	    	array.add(food.turkeySandwich);
        	    	array.add(food.turkeySandwichPrice);
        	    	System.out.println(array);
        	    }
        	    
        	    break;
        	    
            	case(2):
            		System.out.println();
            	    System.out.println("Our Omelets Are: ");
            	    System.out.println("===========================================");
            	    System.out.println("1.Ham & Cheese Omelet------------------$5.00");
            	    System.out.println("2.Beef Omelet--------------------------$5.25");
            	    System.out.println("3.Chicken Omelet--------------------------$5.50");
            	    
            	    //option Omelet
            	    int foodOptionOmelet = scanner.nextInt();
            	    
            	    if(foodOptionOmelet != 2 && foodOptionOmelet !=3) {
            	    	array.add(food.hamCheeseOmelet);
            	    	array.add(food.hamCheeseOmeletPrice);
            	    	System.out.println(array);
            	    }
            	    else if (foodOptionOmelet != 1 && foodOptionOmelet !=3) {
            	    	array.add(food.beefOmelet);
            	    	array.add(food.beefOmeletPrice);
            	    	System.out.println(array);
            	    }
            	    else if(foodOptionOmelet != 2 && foodOptionOmelet !=1) {
            	    	array.add(food.chickenOmelet);
            	    	array.add(food.chickenOmeletPrice);
            	    	System.out.println(array);
            	    }
            	    break;
            	    
            	case(3):
            		System.out.println();
            	    System.out.println("Our Quesadillas Are: ");
            	    System.out.println("==============================================");
            	    System.out.println("1.Ham & Cheese Qusadilla-------------------$4.50");
            	    System.out.println("2.Chicken Quesadilla-----------------------$4.25");
                    System.out.println("3.Beef Qusadilla---------------------------$4.75");
                    
                    //Quesadillas
            	    
            	    int foodOptionQuesadilla = scanner.nextInt();
            	    if(foodOptionQuesadilla != 2 && foodOptionQuesadilla !=3) {
            	    	array.add(food.hamCheeseQuesadilla);
            	    	array.add(food.hamCheeseQuesadillaPrice);
            	    	System.out.println(array);
            	    }
            	    else if (foodOptionQuesadilla != 1 && foodOptionQuesadilla !=3) {
            	    	array.add(food.chickenQuesadilla);
            	    	array.add(food.chickenQuesadillaPrice);
            	    	System.out.println(array);
            	    }
            	    else if(foodOptionQuesadilla != 2 && foodOptionQuesadilla !=1) {
            	    	array.add(food.beefQuesadilla);
            	    	array.add(food.beefQuesadillaPrice);
            	    	System.out.println(array);
            	    }
            	    break;
            	    default:
            	    	System.out.println("You need to choose an option from the food menu");
            	
            	}// end of food switch statement
            }// end of food if condition 
           
           
	}while(ordering = true);
            
            
            
          
            
           

} // end of cafe menu method

class Food{
	
	//sandwiches
	public String chickenSandwich ="Chicken Sandwich";
	public double chickenSandwichPrice = 3.50;
	
	public String hamCheeseSandwich =" Ham & Cheese Sandwich";
	public double hamCheesePrice = 3.15;
	
	public String turkeySandwich = "Turkey Sandwich";
	public double turkeySandwichPrice = 3.50;
	
	//omelets
	
	public String hamCheeseOmelet ="Ham & Cheese Omelet";
	public double hamCheeseOmeletPrice = 5.00;
	
	public String beefOmelet ="Beef Omelet";
	public double beefOmeletPrice = 5.25;
	
	public String chickenOmelet = "Chicken Omelet";
	public double chickenOmeletPrice = 5.50;
	
	//quesadillas
	public String hamCheeseQuesadilla ="Ham & Cheese Qusadilla";
	public double hamCheeseQuesadillaPrice = 4.50;
	
	public String chickenQuesadilla =" Chicken Quesadilla";
	public double chickenQuesadillaPrice = 4.25;
	
	public String beefQuesadilla = "Beef Qusadilla";
	public double beefQuesadillaPrice = 4.75;
	
	public double price;
	public String foodType;
	
	//getters and setters
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	@Override
	public String toString() {
		return "Food [chickenSandwich=" + chickenSandwich + ", chickenSandwichPrice=" + chickenSandwichPrice
				+ ", hamCheeseSandwich=" + hamCheeseSandwich + ", hamCheesePrice=" + hamCheesePrice
				+ ", turkeySandwich=" + turkeySandwich + ", turkeySandwichPrice=" + turkeySandwichPrice
				+ ", hamCheeseOmelet=" + hamCheeseOmelet + ", hamCheeseOmeletPrice=" + hamCheeseOmeletPrice
				+ ", beefOmelet=" + beefOmelet + ", beefOmeletPrice=" + beefOmeletPrice + ", chickenOmelet="
				+ chickenOmelet + ", chickenOmeletPrice=" + chickenOmeletPrice + ", hamCheeseQuesadilla="
				+ hamCheeseQuesadilla + ", hamCheeseQuesadillaPrice=" + hamCheeseQuesadillaPrice
				+ ", chickenQuesadilla=" + chickenQuesadilla + ", chickenQuesadillaPrice=" + chickenQuesadillaPrice
				+ ", beefQuesadilla=" + beefQuesadilla + ", beefQuesadillaPrice=" + beefQuesadillaPrice + ", price="
				+ price + ", foodType=" + foodType + "]";
	}
	
	
	
	
}// end of food class

class Drinks{
	
	//Frappucinos
	public String chocoMoca ="Chocolate Moca Frappucino";
	public double chocoMocaPrice = 2.35;
	
	public String eggFrappucino ="Eggnog Frappucinno";
	public double eggFrappucinoPrice = 1.75;
	
	public String caramelFrappucino = "Caramel Moca Frappucino";
	public double caramelFrappucinoPrice = 2.50;
	
	// hot coffee
	public String ameCofee ="American Coffee";
	public double ameCoffePrice = 2.00;
	
	public String domCoffee ="Dominican Coffee";
	public double domCoffeePrice = 2.15;
	
	public String afriCoffee = "African Coffee";
	public double afriCoffeePrice = 2.50;
	
	//Ice coffee
	public String icedMac ="Iced Macchiato";
	public double icedMacPrice = 1.00;
	
	public String icedLatte ="Iced Latte";
	public double icedLattePrice = 1.60;
	
	public String icedCoffee = "Iced Coffee";
	public double icedCoffeePrice = 1.75;
	
	
	//Juices
	public String applJ ="Apple Juice";
	public double appJPrice = 3.00;
	
	public String OrangeJ ="Orange Juice";
	public double OrangeJPrice = 2.50;
	
	public String mangoJ = "Mango Juice";
	public double mangoJPrice = 2.75;
	
	
	//Teas
	public String hotT ="Hot Tea";
	public double hotTPrice = 2.00;
	
	public String coldT ="Cold Tea";
	public double coldTPrice = 2.00;
	

	
	public String drinkType;
	public double price;
	
	//getters and setters
	public String getDrinkType() {
		return drinkType;
	}
	public void setDrinkType(String drinkType) {
		this.drinkType = drinkType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Drinks [chocoMoca=" + chocoMoca + ", chocoMocaPrice=" + chocoMocaPrice + ", eggFrappucino="
				+ eggFrappucino + ", eggFrappucinoPrice=" + eggFrappucinoPrice + ", caramelFrappucino="
				+ caramelFrappucino + ", caramelFrappucinoPrice=" + caramelFrappucinoPrice + ", ameCofee=" + ameCofee
				+ ", ameCoffePrice=" + ameCoffePrice + ", domCoffee=" + domCoffee + ", domCoffeePrice=" + domCoffeePrice
				+ ", afriCoffee=" + afriCoffee + ", afriCoffeePrice=" + afriCoffeePrice + ", icedMac=" + icedMac
				+ ", icedMacPrice=" + icedMacPrice + ", icedLatte=" + icedLatte + ", icedLattePrice=" + icedLattePrice
				+ ", icedCoffee=" + icedCoffee + ", icedCoffeePrice=" + icedCoffeePrice + ", applJ=" + applJ
				+ ", appJPrice=" + appJPrice + ", OrangeJ=" + OrangeJ + ", OrangeJPrice=" + OrangeJPrice + ", mangoJ="
				+ mangoJ + ", mangoJPrice=" + mangoJPrice + ", hotT=" + hotT + ", hotTPrice=" + hotTPrice + ", coldT="
				+ coldT + ", coldTPrice=" + coldTPrice + ", drinkType=" + drinkType + ", price=" + price + "]";
	}

	

}//end of drinks class
}// end of menu class
