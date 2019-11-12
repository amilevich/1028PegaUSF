package com.cafe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cafe 
{
	private String food[] = {"Turkey sandwich", 
			 				 "House Salad", 
			 				 "Soup of the Day", 
			 				 "Grilled salmon", 
			 				 "Pulled Pork sandwich",
			 				 "Wings",
			 				 "Double bacon cheeseburger"}; 

	private String drink[] = {"Orange Juice",
			  				  "Coffee",
			  				  "Green Tea",	
			  				  "Hot Chocolate",
			  				  "Strawberry Lemonaid",
			  				  "Ice Water"};		 
	
	Queue<Customer> orders = new LinkedList<Customer>();
		
	boolean Update(double _timeSlice)
	{
		System.out.println("1) Take order");
		System.out.println("2) Delivery orders");
		System.out.println("3) Exit");

		Scanner sc = new Scanner(System.in); 
		int option = sc.nextInt();
		sc.nextLine();

		switch (option)
		{
			case 1:
			{
				String food = cafeMenuFood();
				System.out.println("food: " + food);
				String drink = cafeMenuDrink();
				System.out.println("drink: " + drink);
				Customer temp = new Customer();
				temp.setFood(food);
				temp.setDrink(drink);
				orders.add(temp);
			}
			break;
			
			// delivery outstanding orders to customers
			case 2:
			{
				for(int i = 0; i < orders.size(); i++)
				{
					System.out.println(orders.remove().toString());
				}
			}
			break;
			
			// quit 
			case 3:
				System.out.println("Good bye");
				sc.close();
				return false;
//				break;

			default:
			{
				System.out.println("ERROR: not valid option");
			}
			break;
		}
	//	sc.close();
		return true;
	}
	
	String cafeMenuFood()
	{
		// Print out food
		System.out.print("FOOD\n");
		for (int i = 0; i < food.length; i++)
		{
			System.out.print(i+1 + ") " + food[i] + '\n');
		}

		//Get selection
		Scanner sc = new Scanner(System.in);
//		sc.nextLine();
		int select = sc.nextInt();
		sc.nextLine();
//		sc.close();
		
		if (select < food.length+1)
		{
			return food[select-1];
		}
		else if(null == food[select-1])
		{
			return "no food";
		}
		else
			return "no food";
	}
	
	String cafeMenuDrink()
	{
		System.out.print("DRINKS\n");
		for (int i = 0; i < drink.length; i++)
		{
			System.out.print(i+1 + ") " + drink[i] + '\n');
		}


		//Get selection
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		sc.nextLine();
//		sc.close();
		
		if (select < drink.length+1)
			return drink[select-1];
		else if (null == drink[select-1])
			return "no drink";
		else
			return "no drink";
	}
	
	
}
