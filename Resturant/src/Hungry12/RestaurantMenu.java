package Hungry12;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class RestaurantMenu{
	
	static Queue<Customer> customerList = new LinkedList<Customer>();

	
	static Drink cinammonLatte = new Drink("Cinammon Latte", 4);
	static Drink caramelBrew = new Drink ("Caramel Latte", 6);
	static Drink cookiesnCream = new Drink ("CookiesNCream", 3);
	static Drink vanillaCrisp = new Drink ("Vanilla Crisp",2);
	
	static Food baconEggBiscuit = new Food ("BaconNEgg",2);
	static Food eggMcMuffin = new Food ("Egg McMuffin",2);
	static Food eggOmelet = new Food ("Egg Omelet",3);
	static Food chickenBiscuit = new Food ("Chicken Biscuit", 5);
	
	static Scanner sc = new Scanner(System.in);
	private static Drink drinkChoice;
	private static Food foodChoice;
//	int foodPrice = 0;
	
	static String foodName;
	static String drinkName;
	static int foodPrice;
	static int drinkPrice;
	//static int orderTotal = chickenBiscuit.getFoodPrice() + caramelBrew.getDrinkPrice();;
	
	static int totalPrice = (+ caramelBrew.getDrinkPrice());
	//static Customer example = new Customer("David", drinkName, foodName, orderTotal);
	
	static String customerName;
	
	public static void main(String[] args) {

		//System.out.println(example);
		
		createOrder();
		}
	
	static void createOrder() {
		int userChoice;

		System.out.println("What would you like to drink?");
		System.out.println("1.cinammonLatte");
        System.out.println("2.caramelBrew");
        System.out.println("3.cookiesnCream ");
        System.out.println("4.vanillaCrisp");
        System.out.println("0.Finish");
        
        userChoice = sc.nextInt();
        
        switch (userChoice) {
        case 1:
        	//cinnamonLatte
        	//drinkList.add(cinammonLatte);
        	drinkName = cinammonLatte.getDrinkName();
        	drinkPrice = cinammonLatte.getDrinkPrice();
        	break;
        case 2:
        	//caramelBrew
        	//drinkList.add(caramelBrew);
        	break;
        case 3:
        	//cookiesnCream
        	//drinkList.add(cookiesnCream);
        	break;
        case 4:
        	//vanillaCrisp
        	//drinkList.add(vanillaCrisp);
        	break;
        case 0:
        	//Finish
        	break;
        default: 
      	System.out.println("Wrong choice");
        	break; 
        }   //If user wants more drinks
        

        
        System.out.println("What would you like to eat?");
        System.out.println("1.baconEggBiscuit");
        System.out.println("2.eggMcMuffin");
        System.out.println("3.eggOmelet");
        System.out.println("4.chickenBiscuit");
        
        //System.out.println("What would you like to eat?");
        userChoice = sc.nextInt();
        
        switch (userChoice) {
        case 1:
        	//baconEggBiscuit
        	//foodList.add(baconEggBiscuit);
        	foodName = baconEggBiscuit.getFoodName();
        	foodPrice = baconEggBiscuit.getFoodPrice();
        	break;
        case 2:
        	//eggMucMuffin
        	//foodList.add(eggMcMuffin);
        	break;
        case 3:
        	///eggOmelet
        	//foodList.add(eggMcMuffin);
        	break;
        case 4:
        	//chickenBiscuit
        	//foodList.add(chickenBiscuit);
        	 //= chickenBiscuit;
        	break;
        case 0:
        	//Finish
        	break;
        default: 
      	System.out.println("Wrong choice");
        	break;
        	
       // System.out.println("Can I get a name for the order?");
        //String customerName = sc.nextLine();
        
        //       customerName = new Customer (customerName, drinkChoice, foodChoice);
        //Customer currentCustomer = new Customer(customerName, drinkChoice, foodChoice);
        	
        }
        
        System.out.println("Can I get a name for the order?");
        customerName = sc.next();
        int orderTotal = drinkPrice + foodPrice;
        Customer currentCustomer = new Customer(customerName, drinkName, foodName, orderTotal);
        
        
        customerList.add(currentCustomer);
        
        System.out.println(customerList);
        
        System.out.println(currentCustomer);
        	 //createOrder();

	}
}
  
	
	
