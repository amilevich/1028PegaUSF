package home.cafe.proj;
import java.util.ArrayList;

import java.util.Scanner;

public class Cafe {

	public static void main(String[] args) {
	
		// create a queue
	//	Queue<Integer> q = new LinkedList<>();
		//Add element to the queue
	//	queue.q("Sandwich");
		//System.out .println("(1)"  + queue);
		
		
		Scanner sc = new Scanner(System.in);	
		{
		System.out.println("\n Well come to Cafe !\n Please choose one option : \n 1.Add drink to order \n 2. Add Food to order \n 3.Pay the Total Amount \n 4.EXit \n");
		//String yourOrder =sc.nextLine();
		}
		
		
		{
	System.out.println(" please  order your Drink , Coke or Sprite: " );
	String yourDrink = sc.next();
	System.out.println("you Drink order is:" + yourDrink  );
		}
		
		{
	System.out.println("please order your food, Sandwich  or Donat: " );
	String yourFood = sc.next();
	System.out.println("you food order is:" + yourFood );
		}
	{
	System.out.println(" please pay the price, $8.50:");
    double yourPrice = sc.nextDouble();
    System.out.println("Your total is:" + yourPrice);
	
	}
	
	{
	System.out. println(" Please Exit ");
	String youDone = sc.nextLine();
	System.out.println("you done !" + youDone);
	}
	
	}
}


