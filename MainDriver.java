package thecannabiscafe;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MainDriver {

	
	static final Cannabis_and_Coffee jack_and_icedcoffee = new Cannabis_and_Coffee();
	static final Cannabis_and_Coffee skywalker_and_latte = new Cannabis_and_Coffee();
	static final Cannabis_and_Coffee gorillaglue_and_frappuccino = new Cannabis_and_Coffee();
	static final Cannabis_and_Coffee bluedream_and_cappuccino = new Cannabis_and_Coffee();
	
	static List<Cannabis_and_Coffee> ccList = new ArrayList<>();
	
	
	
	
	public static void main(String[] args) {
		
		//Beginning of Scanner object
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Cannabis Cafe! To start off, What is your name? So that we may best accomadate you: ");
		
		
		String name = sc.nextLine();
		System.out.println("Hello, " + name + "!"  + ", What can I get for you?");
		// = new Scanner(System.in);
		
		
		
		for(Cannabis_and_Coffee i : ccList) {
			System.out.println("Selling"  + i.hashCode());
			
			boolean customers = true;
			while(customers) {
				boolean each_customer_ordering = true;
				while(each_customer_ordering) {
					ccList.add(jack_and_icedcoffee);
					ccList.add(skywalker_and_latte);
					ccList.add(gorillaglue_and_frappuccino);
					ccList.add(bluedream_and_cappuccino);
				}
				{
			
				
			}
		}
	

	
		
		
		
		 
		Queue<List<Cannabis_and_Coffee>> orders = new LinkedList<>();
		orders.add(ccList);
		
		}
		
	}
	
}
		
		
		
		
	
	


