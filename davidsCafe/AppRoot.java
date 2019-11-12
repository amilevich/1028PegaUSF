package davidsCafe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AppRoot {

	public static Scanner chex = new Scanner(System.in);
	public static String toggle;

	public static void main(String[] args) {
		Queue<Customer> queuedCustomers = new LinkedList<Customer>();//OUR STACK
		int guestID = 1;
		int custListPos = 0;
		
		
		/*Colors for strings and other styles*/
	    final String CYAN = "\033[1;96m";
	    final String WHITE = "\033[0;97m";
	    final String YELLOW = "\033[1;93m";
	    final String BWHITE = "\033[1;97m";
	    final String RED = "\033[1;95m";
	    
		while (true) {
			if (guestID == 300) { 
				guestID = 1;
			}
			if (custListPos == 1) { 
	         // the queued customers will be moved along in order of fifo thanks to methods like .pop and .peek
				System.out.println("Now processing the orders of the following Customer: " + queuedCustomers.peek().getz1() + ", " + queuedCustomers.peek().getCustomerName());
				while (!queuedCustomers.peek().orderedDrinks.isEmpty()) {
					System.out.print(queuedCustomers.peek().orderedDrinks.peek().toString() + " ");
					queuedCustomers.peek().orderedDrinks.pop();//removing the object at the top of the stack and then returning it
				}
				System.out.println();
				while (!queuedCustomers.peek().eatsOptions.isEmpty())//checks to see if the array is empty yeet
					{
					System.out.print(queuedCustomers.peek().eatsOptions.peek().toString() + " "); // sets the value to  a string data type
					queuedCustomers.peek().eatsOptions.pop();
				}
				System.out.println();
				System.out.println("Enjoy your order!");
				queuedCustomers.remove();
				custListPos = 0;
			} else { // Displays a header message and ushers the user further into the programs functional interface
			    System.out.println(CYAN + "============================================================");	
			    System.out.println(CYAN + "============================================================");
			    System.out.println(BWHITE + "\t\t    W E L C \uD83C\uDF69 M E ! \t\t\t "+YELLOW+"\n \n\t\t 2"+BWHITE+" D A V I D'S " + BWHITE + " C A F E \uD83D\uDE80 ");
			    System.out.println(CYAN + "============================================================");
			    System.out.println(CYAN + "============================================================");
			    System.out.println(BWHITE + "\t \t \uD83D\uDD25 PLEASE CHOOSE ONE \uD83D\uDD25");
			    System.out.println(CYAN + "============================================================");
			    System.out.println(CYAN + "============================================================");
				System.out.println(BWHITE + "\t\uD83C\uDF55:)" + YELLOW + " LOOKING FOR FOOD? PRESS KEY:" + BWHITE + "("  + CYAN + "PRESS 1" + BWHITE + ")" + " \n\t\uD83C\uDF77" + WHITE + ":) " + YELLOW + "LOOKING FOR DRINKS? PRESS KEY:" + WHITE + "(" + CYAN + "PRESS 2" + WHITE + ")");
				System.out.println(BWHITE + "\t\t\t "+YELLOW+"EXIT: "+CYAN+"PRESS 3");
				System.out.print(BWHITE + "\t\t " + CYAN + "    *** " + BWHITE +"ENTER" + CYAN + " ***\n");
			    System.out.println(CYAN + "============================================================");
			    System.out.println(CYAN +"============================================================");
			 
				toggleSelection(); // toggling allows us to better control the commands we give the compiler
				if (toggle.equals("1")) {
					Customer custID = new Customer();
					if ((custID.orderedDrinks.isEmpty()) && (custID.eatsOptions.isEmpty())) { 
																		
						System.out.println(
								"Thanks! Come Again!");
						continue;//continuing the program
					}
					custID.setz1(guestID);
					System.out.println("THANKS FOR SHOPPING AT DAVID'S CAFE, MAY I HAVE A NAME FOR THE ORDER?? ");
					custID.setCustomerName(chex.nextLine());
					queuedCustomers.add(custID);
					System.out.println("Hey Thanks!" + custID.getCustomerName());
					System.out.println("Hope you enjoyed the" + custID.orderedDrinks);
					System.out.println("So happy to see you " + custID.getCustomerName());
					System.out.println("Til we meet again friend!");
					guestID++;
					custListPos++;
				} else { 
					System.out
							.println("Please order again");
					continue;//allows the function to continue despite the occurance
				}
			}
		}
	}

	// a toggle selector variable will allow me to navigate quickly and efficiently 
	private static void toggleSelection() {
		while (true) { 
			toggle = chex.nextLine();
			if (toggle.equals("1") || toggle.equals("2")|| toggle.equals("3")|| toggle.equals("4")|| toggle.equals("5")) {
				break;
			} else {
				System.out.println("SELECT FROM THE FOLLOWING OPTIONS [1,2,3]");
			}
		}
	}

	    


}
