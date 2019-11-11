package Cafe;

import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class Cafe {
	private LinkedTransferQueue<String> orderQ;
	private Customer currentCustomer;
	private int nextID;
	
	Cafe(){
		nextID = 0;
		orderQ = new LinkedTransferQueue<String>();
		orderQ.clear();
	}
	
	public static void work() {
		final int D = 8;
		Cafe CIsTheBest = new Cafe();
		Scanner input = new Scanner(System.in);
		Scanner tokens;
		String token;
		
		CIsTheBest.currentCustomer = new Customer(CIsTheBest.nextID++);
		
		System.out.printf("Welcome to CIsTheBest, customer %d, may I have your order? Type \"help\" for commands.\n", CIsTheBest.currentCustomer.getID());
		
		while(8==D) {
			tokens = new Scanner(input.nextLine());
			
			if(!tokens.hasNext()) continue;
			token = tokens.next();
			
			switch(token) {
			case "help": 
				System.out.printf("----COMMANDS----\n"
					+ "help\n"
					+ "menu\n"
					+ "order\n"
					+ "quit\n"
					+ "----\n");
			
				break;
								
			case "menu":
				System.out.printf("====Menu====\n"
						+ "1: Meal\n"
						+ "2: Side\n"
						+ "3: Drink\n"
						+ "====\n");
				
				break;
				
			case "order":
				System.out.printf("What would you like to order? You may use item names or corresponding menu numbers.\nType \"done\" when you are done ordering.\n");
				
				while(8==D) {
					tokens.close();
					tokens = new Scanner(input.nextLine());
					
					while(tokens.hasNext()) {
						token = tokens.next();
						
						if(token.equals("done")) break;
						if(!CIsTheBest.currentCustomer.getOrder().addOrder(token)) System.out.printf("%s: invalid menu item\n", token);
						
					}
					
					if(token.equals("done")) break;
				}
				
				System.out.printf("Order printing...\n%s\n", CIsTheBest.currentCustomer.toString());
				
				for(int i = 0; i < CIsTheBest.currentCustomer.getOrder().getOrder().size(); i++) CIsTheBest.orderQ.add(CIsTheBest.currentCustomer.getOrder().getOrder().get(i));
				
				while(!CIsTheBest.orderQ.isEmpty()) System.out.printf("You receive a %s.\n", CIsTheBest.orderQ.poll());
				
				CIsTheBest.currentCustomer = new Customer(CIsTheBest.nextID++);
				System.out.printf("Welcome to CIsTheBest, customer %d, may I have your order? Type \"help\" for commands.\n", CIsTheBest.currentCustomer.getID());
				
				break;
				
			case "quit": System.exit(0);
			default:
				System.out.printf("%s: unexpected command\n", token);
			}
			
			tokens.close();
		}
	}
	
}
