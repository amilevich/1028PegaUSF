package com.Assign.coffe;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
	//declaring the variables
    public static double subTotal=0.0;
    public static double runningTotal;
    private static double price;
    static boolean ordering = true;
    static int counter=0;
    static int total=0;
    
    static Scanner input = new Scanner(System.in);
    
   public static String  foodType;
   
   //instatiated object with queue
    
    static Queue<String>orderList=new LinkedList<String>();
    
    //menu method
    public static void menu() {
    	System.out.println("*******************************************");
		System.out.println("This the menu choose one of the following:");
		System.out.println("1. Hot coffees:--------------------> $3.99");
		System.out.println("2. Cold coffees:-------------------> $5.99");
		System.out.println("3. hot teas:-----------------------> $3.89");
		System.out.println("4. Ice tea:------------------------> $4.99");
		System.out.println("5. Sandwitches:--------------------> 4.69 ");
   
		
    
    }
    
    //Price method
    public static double price(int foodItem) {
    	//validation for fooditems
        if (foodItem == 1) {
        	foodType="hotCoffe";
            
            System.out.println("Your selection is Hot coffee");
            System.out.println("*******************************************");
            price = 3.99;
            orderList.add(foodType);
        }
        if (foodItem == 2) {
        	foodType="coldCoffe";
            
            System.out.println("Your selection is Cold coffee");
            System.out.println("*******************************************");
            price = 5.99;
            orderList.add(foodType);
        }
        if (foodItem == 3) {
        	foodType="hotTea";
            
            System.out.println("your selection is hot teas");
            System.out.println("*******************************************");
            price = 4.99;
            orderList.add(foodType);
        }
        if (foodItem == 4) {
        	foodType="iceTea";
        	
        	System.out.println("your selection is ice tea");
        	System.out.println("*******************************************");
        	price = 3.89;
        	orderList.add(foodType);
        }
        if (foodItem == 5) {
        	foodType="Sandwitch";
        	
        	System.out.println("your selection is sandwitches");
        	System.out.println("*******************************************");
        	price = 4.69;
        	orderList.add(foodType);
        	System.out.println(foodType);
        }
        
        quantity();
        return price;
    }

    public static double quantity() {
        System.out.println("Enter quantity");
        double quantity = input.nextDouble();
        
        subTotal(quantity, price);
        return quantity;
    }

    public static double subTotal(double quantity, double itemPrice) {
        double subTotal = quantity * itemPrice;
     System.out.println("Your total is: " +  subTotal);
        return subTotal;
    }
    
    public static void done(double runningTotal) {
        ordering = false;
        System.out.println(runningTotal);
        System.out.println("Enjoy your meal");
        String myTotal = String.valueOf(subTotal);
        orderList.add(myTotal);
        Object[] obj = {myTotal};
        for (int i =0; i<obj.length; i++) {
        	counter++;
        	System.out.println("Total " + myTotal);
        	System.out.println(obj[i].toString());
        	 
        }
        
        
     
		
        System.out.println("your total is: " + subTotal);
        
        System.out.println();
        
    }
    //main method
    public static void main(String[] args) {
    	
    	
        int menuOption;
        int foodItem1 = 0;
        input = new Scanner(System.in);
        
        
        do {
            double runningTotal = 0;
            menu();
            menuOption = input.nextInt();
            switch (menuOption) {
            case 1:
                foodItem1 = 1;
                price(foodItem1);
                break;
            case 2:
                foodItem1 = 2;
                price(foodItem1);
                break;
            case 3:
                foodItem1 = 3;
                price(foodItem1);
                break;
            case 4:
            	foodItem1 = 4;
            	price(foodItem1);
            	break;
            case 5:
            	foodItem1 = 5;
            	price(foodItem1);
            	break;
            case 6:
            	foodItem1 = 6;
            	price(foodItem1);
            	break;
                
                case 7:
                done(runningTotal);
                break;
            default:
                System.out.println("Invalid option.");
            }
        
        } while (ordering);
        {
            
        }
    }
}