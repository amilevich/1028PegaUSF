package com.assignment.cafe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
    public double subTotal;
    public static double runningTotal;
    private static double itemPrice;
    static boolean ordering = true;
    static Scanner fd = new Scanner(System.in);
	static Queue<Queue<String>> customerQ = new LinkedList<>();  
	static Queue<String> orderQ = new LinkedList<>();
	static String food; 

    public static void menu() {
        System.out.println("Welcome \n1. fried rice ($4.00) \n2. chicken ($3.50)\n3. Soda ($2.00) \n4. Done");
    }

    public static double itemPrice(int foodItem) {
        if (foodItem == 1) {
            // fried rice = $4.00
            System.out.println("You've ordered a fried rice");
            itemPrice = 4.00;
            food = "Fried ricce";

        }
        if (foodItem == 2) {
            // chicken = $3.50
            System.out.println("You've ordered chicken");
            itemPrice = 3.50;
            food = "chicken";
        }
        if (foodItem == 3) {
            // soda = $2.00
            itemPrice = 2.00;
            DrinksOption drink = new DrinksOption();
            System.out.println("\nYou've ordered a soda. Choose the drink options (input integer):");
            Scanner sc = new Scanner(System.in);
            int dchoice= sc.nextInt();
            food =  drink.drinkOption[dchoice];
        }
       
        quantity();
        System.out.println("\n----------Order--------------");
        System.out.println("Orders:" + orderQ);
        System.out.println("----------Order--------------\n");
        return itemPrice;
        
    }

    public static double quantity() {
        System.out.println("Enter quantity");
        double quantity = fd.nextDouble();
        subTotal(quantity, itemPrice);
        String quant = food + ": "  + Double.toString(quantity);
        orderQ.add(quant);
        return quantity;
    }

    public static double subTotal(double quantity, double itemPrice) {
        double subTotal = quantity * itemPrice;
        System.out.println("Subtotal: " + subTotal);
        return subTotal;
    }

    public static void done(double runningTotal) {
        ordering = false;
        System.out.println(runningTotal);
        System.out.println("Enjoy your meal");
        Menu.customerQ.add(Menu.orderQ);
        System.out.println("\n------------Customers in Line------------------");
        System.out.println("Customers in line: " + Menu.customerQ);
        System.out.println("------------Customers in Line------------------\n");
        Menu.orderQ.clear();
        
    }

    public static void main(String[] args) {
        int menuOption;
        int foodItem = 0;
        fd = new Scanner(System.in);
        do {
            double runningTotal = 0;
            menu();
            menuOption = fd.nextInt();
            switch (menuOption) {
            case 1:
                foodItem = 1;
                itemPrice(foodItem);
                break;
            case 2:
                foodItem = 2;
                itemPrice(foodItem);
                break;
            case 3:
                foodItem = 3;
                itemPrice(foodItem);
                break;
            case 4:
                done(runningTotal);
                break;
            default:
                System.out.println("Invalid option.");
            }
        } while (ordering);
        {
            subTotal(quantity(), itemPrice(foodItem));
            runningTotal = runningTotal + subTotal(quantity(), itemPrice(foodItem));
        }
    }

//     public static void main(String[] args) {
//
//    	boolean open = true;  
     
    	//Create queue for order line
    	
//    	Queue<Integer> customerQ = new LinkedList<>();
//     	
//    	//Create queue for pick up order line
//	  
//    	Queue<String> orderQ = new LinkedList<>();  
//    	
//    	for(int i = customerQ.size(); i< 3; i++) {
//    		customerQ.add(i);
//
//	}
//      	System.out.println(q);
//
//		int x = q.remove();
 
		//	System.out.println("removed element is: " + x);

        //System.out.println(q);

//    	int head = q.peek();
//     }
//
//	System.out.println("head of queue is " + head);
//
//	int size = q.size();
//}
//   System.out.println("size of queue is " + size);
//
//     }

}



   
