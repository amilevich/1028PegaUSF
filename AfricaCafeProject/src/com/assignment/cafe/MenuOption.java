package com.assignment.cafe;

import java.util.Scanner;

public class MenuOption {
	
	 static Scanner  input = new Scanner(System.in);
	public static double runningTotal=0;

	public static void main(String[] args) {
		  int menuOption;
		  int foodItem = 0;
		 
		 // double runningTotal=0;
	
	}
	
	public static void menuOption( int itemPrice, int foodItem) {
		Menu.menu();
	    int menuOption = input.nextInt();
	    switch(menuOption){
	      case 1:
	        foodItem = 1;
	        runningTotal += Menu.itemPrice(foodItem);
	        break;
	      case 2:
	        foodItem = 2;
	        runningTotal += Menu.itemPrice(foodItem);
	        break;
	      case 3:
	        foodItem = 3;
	        runningTotal += Menu.itemPrice(foodItem);
	        break;
	      case 4:
	        Menu.done(runningTotal);

	        break;
	      default:
	        System.out.println("Invalid option.");
	    }
	       
	}      	
 }
 