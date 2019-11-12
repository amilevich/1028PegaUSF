package com.assignment.cafe;

import java.util.Scanner;

public class Menu {
	
	
	Scanner sc = new Scanner(System.in);
//	private Object orderSelection;
	
	public void viewMenu() {
		System.out.println("May I take your order?");
		System.out.println();
		System.out.println("        ~ Menu ~  ");
		System.out.println(" 1. Coffee.........$2 ");
		System.out.println(" 2. Tea............$2 ");
		System.out.println(" 3. Pastry.........$2 ");
		System.out.println(" 4. Sandwich.......$4 ");
		
		
		int orderSelection = sc.nextInt();
		do {
//			System.out.println("May I take your order?");
			
			System.out.println();
			
			switch(orderSelection) {
			case 1:
				System.out.println("You ordered coffee");
				break;
			case 2:
				System.out.println("You ordered tea");
				break;
			case 3:
				System.out.println("You ordered a pastry");
				break;
			case 4:
				System.out.println("You ordered a sandwich");
				break;
			default:
				System.out.println("We do not carry that item at this location");
			
			}
			System.out.println();
			System.out.println("Thank you for your order");
			
		}while(orderSelection > 4);
		
	}
}


//nested classes






