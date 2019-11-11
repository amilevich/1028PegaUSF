package cafe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CafeDriver {
	public static void main(String[] args) {
		
		boolean open = true;
		//create queue for order line
		Queue<String> customerQ = new LinkedList<>();
		//create queue for pick up line
		Queue<String> orderQ = new LinkedList<>();
		
		//loop check to see if there are customers looking to order
		while(open) {
			open = work(customerQ, orderQ);
		}		
	}
	
	public static String getName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to RevCafe!\n");
		menu();
		System.out.println("What is your name for your order?");
		return sc.nextLine();

	}
	public static String takeFoodOrder(String name) {
		Scanner sc = new Scanner(System.in);
		FoodOrder fo = new FoodOrder(name);
		menu();
		System.out.println("Entree? ");
		fo.setEntree(sc.nextLine());
		System.out.println("Side? ");
		fo.setSide(sc.nextLine());
		System.out.println("Dessert? ");
		fo.setDessert(sc.nextLine());
		return fo.toString();
	}
	public static String takeDrinkOrder(String name) {
		Scanner sc = new Scanner(System.in);
		DrinkOrder d = new DrinkOrder(name);
		menu();
		d.setName(name);
		System.out.println("Beverage? ");
		d.setBeverage(sc.nextLine());
		System.out.println("Size? (S, M, L)");
		d.setSize(sc.nextLine());
		System.out.println("Add-ons? ");
		d.setAddOns(sc.nextLine());		
		return d.toString();
		
	}
	
	public static void menu() {
		System.out.println("\t\tRevCafe Menu\n   Entrees:\t\t\t   Beverages:\nSandwich\t\t\tSoft Drinks: cola, diet cola, lemon/lime, lemonade\nSoup\t\t\t\tCoffee (milk, cream, sugar)\n"
				+ "Salad\t\t\t\tTea (milk, lemon, honey)\n\n   Sides:\t\t\t   Desserts:\nFries\t\t\t\tBrownie\nChips\t\t\t\tCookies\nFruit Cup\t\t\tIce Cream Sundae\n\n");
	}
	
	public static boolean work(Queue<String> cust, Queue<String> order) {
		Scanner sc = new Scanner(System.in);
		boolean b=true;
		
		System.out.println("\n\nLine: "+ cust.toString() +"\nOrders: "+order.toString());
		System.out.println("\n0. Walk In\n1. Take Food Order\n2. Take Drink Order\n3. Take Mixed Order\n4. Order Up\n5. Quit\nPlease enter the number of your selection.");
		int option = sc.nextInt();
		
		switch (option) {
		case 0:
			cust.add(getName());	//add person to the line waiting to order
			break;
		case 1:
			order.add(takeFoodOrder(cust.peek()));	//gets the name of the next customer in the line to order and passes that to the take order method to label their order
			cust.remove();		//remove customer from line waiting to order
			break;
		case 2:
			order.add(takeDrinkOrder(cust.peek()));//gets the name of the next customer in the line to order and passes that to the take order method to label their order
			cust.remove();		//remove customer from line waiting to order
			break;
		case 3:
			order.add(takeFoodOrder(cust.peek()));		//take the food portion of the order
			order.add(takeDrinkOrder(cust.peek()));	//take the drink portion of the order
			cust.remove();		//remove customer from line waiting to order
			break;
		case 4:
			System.out.println(order.peek());		//displays a confirmation of the order contents
			order.remove();			//remove item from queue when it is given to the customer
			break;
		case 5:
			b = false;
			System.out.println("Goodbye.");
			break;
		default: System.out.println("\nInvalid option, please try again.");
			break;
		}
		return b;
	}

}
