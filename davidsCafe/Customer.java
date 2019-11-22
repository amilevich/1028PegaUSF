package davidsCafe;

import java.util.Stack;

//using the class as the main user object for the whole single page application

public class Customer {
    final String CYAN = "\033[1;96m";
    final String WHITE = "\033[0;97m";
    final String YELLOW = "\033[1;93m";
    final String BWHITE = "\033[1;97m";
    final String RED = "\033[1;95m";

	Stack<CustomerFoodEntry> eatsOptions = new Stack<CustomerFoodEntry>();
	Stack<CustomerDrinkEntry> orderedDrinks = new Stack<CustomerDrinkEntry>();

	private String CustomerName;
	private int z1;

	
	public String getCustomerName() {
		return CustomerName; // getters and setters available
	}

	public void setCustomerName(String CustomerName) {
		this.CustomerName = CustomerName;
	}

	public int getz1() {
		return z1;
	}

	public void setz1(int z1) {
		this.z1 = z1;
	}



	public Customer() {
		super();
		System.out.println( YELLOW + "\t\t GET STARTED \n\t\t1:"+BWHITE+" ORDER FOOD "+YELLOW+"\n\t\t2: " + BWHITE + "ORDER DRINKS " + YELLOW + " \n\t\t"+YELLOW+"3: "+BWHITE+"EXIT APP");
	    System.out.println(CYAN + "============================================================");
	    System.out.println(CYAN + "============================================================");
		AppRoot.toggle = AppRoot.chex.nextLine();
		
		while (!AppRoot.toggle.equals("3")) {
			if ((AppRoot.toggle).equals("1")) { 
				eats();
			} else if ((AppRoot.toggle).equals("2")) {
				dObj();
			} else { 
				System.out.println("OOF TRY AGAIN");
			}
			
			System.out.println("THANKS"+CustomerName+" FOR BEING LOYAL A CUSTOMER!");
			System.out.println("PRESS 3 TO CHECK OUT NOW \n");
			AppRoot.toggle = AppRoot.chex.nextLine();
		}
	}

	
	private void eats() {
		String x;
		String lit = "";
		CustomerFoodEntry yum = new CustomerFoodEntry();
	    final String CYAN = "\033[1;96m";
	    final String WHITE = "\033[0;97m";
	    final String YELLOW = "\033[1;93m";
	    final String BWHITE = "\033[1;97m";
	    final String RED = "\033[1;95m";
		while (true) {
			x = AppRoot.chex.nextLine();
			if (x.equals("1") || x.equals("2")|| x.equals("3")|| x.equals("4")|| x.equals("5")) {
				break;
			} else {
				System.out.println("Sorry try 1,2,3,4, or 5");
			}
		}
		switch (x) {
		case "1":
			lit = "PIZZA";
			break;
		case "2":
			lit = "HOT DOG";
			break;
		case "3":
			lit = "BURGER";
			break;
		case "4":
			lit = "DONUT";
			break;
		case "5":
			lit = "BANANA";
			break;
		default:
			lit = "Error";
		}

		int roo = 0;
		while (true) {
			System.out.println("AWESOME! Great choice! I love " +lit+"'s! How many would you like ?");
			x = AppRoot.chex.nextLine();
			int h = 0;
			roo = 0;
			if (x.equals("0")) {
				break;
			}
			try { // trying the roo value of x integer
				roo = Integer.valueOf(x);
			} catch (Exception e) {
				System.out.println("Hey hey hey! Numerical Value's only :)");
				continue;
			}
			if (!eatsOptions.empty()) { 
				for (int i = 0; i < eatsOptions.size(); i++) {
					if (h == 0) { 
						if (eatsOptions.elementAt(i).getitemsList() == lit) { 
							roo = Integer.valueOf(x) + (eatsOptions.elementAt(i).getamount());
							h = eatsOptions.elementAt(i).getamount();
						}
					} else { 
						if (eatsOptions.elementAt(i).getitemsList() == lit) { 
							roo = roo + (eatsOptions.elementAt(i).getamount());
							System.out.println(roo);
							h = h + eatsOptions.elementAt(i).getamount();
						}
					}
				}
			}
			if (roo > 200) {
				System.out.println("Wow!, lets try a new number");
				// the number being typed in is too large of a feasible amount displaying the code
				System.out.println("Your order should be out soon. " + h);
			} else {
				break;
			}
		}
		if(roo > 0) { //pushing into the queue
		yum.setitemsList(lit);
		yum.setamount(Integer.valueOf(x)); 
		eatsOptions.push(yum); // pushing the yum variable value into the eatsOptions variable
		}
	}

	private void dObj() {
		String x;
		String lit = "";
		int Sum = 0;//trying to figure out the amount of the sum for the customer
		CustomerDrinkEntry liquids = new CustomerDrinkEntry();
		System.out.println("Please enter the number of the drink item you want");
		while (true) {
			x = AppRoot.chex.nextLine();
			if (x.equals("1") || x.equals("2")|| x.equals("3")|| x.equals("4")|| x.equals("5")) {
				break;
			} else {
				System.out.println("TRY ONCE MORE");
			}
		}
		switch (x) {
		case "1":
			lit = "WINE";
			break;
		case "2":
			lit = "WATER";
			break;
		case "3":
			lit = "SODA";
			break;
		case "4":
			lit = "BEER";
			break;
		case "5":
			lit = "COFFEE";
			break;
		default:
			lit = "Sorry there's been an error";
			//when there is an error the program will display this error
		}

		int roo = 0;
		while (true) { // creating a while loop checking system to provide a protection against exceptions
			System.out.println("Great! How many would you like? \n Please enter amount:");
			x = AppRoot.chex.nextLine();
			int h = 0;
			roo = 0;
			if (x.equals("0")) {
				break;
			}
			try {
				roo = Integer.valueOf(x);
			} catch (Exception e) { // syso replying for catching an exception variable e
				System.out.println("... Try a smaller number maybe?");
				continue;
			}
			if (!orderedDrinks.empty()) {
				for (int i = 0; i < orderedDrinks.size(); i++) {
					if (h == 0) { 
						if (orderedDrinks.elementAt(i).getdObj() == lit) { 
							roo = Integer.valueOf(x) + (orderedDrinks.elementAt(i).getamount());
							h = orderedDrinks.elementAt(i).getamount();
						}
					} else {
						if (orderedDrinks.elementAt(i).getdObj() == lit) { 
							roo = roo + (orderedDrinks.elementAt(i).getamount());
							System.out.println(roo);
							h = h + orderedDrinks.elementAt(i).getamount();
						}
					}
				}
			}
			if (roo > 100) {
				System.out.println("Thanks!");
				System.out.println("You have already ordered " + h);
			} else {
				break;
			}
		}
		if(roo > 0) { 
		liquids.setdObj(lit);
		liquids.setamount(Integer.valueOf(x)); 
		orderedDrinks.push(liquids);
		}
//checking if the liquids variable is declared
	}

}
