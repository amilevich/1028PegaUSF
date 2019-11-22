package davidsCafe;

//hello welcome to the cafe need to enter  some objects for the drink array
public class CustomerDrinkEntry {
    final String CYAN = "\033[1;96m";
    final String WHITE = "\033[0;97m";
    final String YELLOW = "\033[1;93m";
    final String BWHITE = "\033[1;97m";
    final String RED = "\033[1;95m";

	private String dObj;
	private int amount;
	private static final String[] dCustomer = {"1: WINE:$6", "2: WATER:$4", "3: SODA:$3","4: BEER:$7","5: COFFEE:$5"  };


	public String getdObj() {
		return dObj; // the drink object chosen by the user
	}

	public void setdObj(String dObj) {
		this.dObj = dObj;
	}

	public int getamount() {
		return amount;
	}

	public void setamount(int amount) {
		this.amount = amount; // setting the amount variable important in determing the amount of things someone buys at the cafe
	}

	public CustomerDrinkEntry() {
		super();
	    final String CYAN = "\033[1;96m"; // setting the java style variables to private as they 
	    //provide some colorful UI from the consoles view
	    final String WHITE = "\033[0;97m";
	    final String YELLOW = "\033[1;93m";
	    final String BWHITE = "\033[1;97m";
	    final String RED = "\033[1;95m";
		System.out.println(RED + "\t\t D R I N K   O P T I O N S: ");

		for (int i = 0; i < (dCustomer.length + 1) - 1; i++) {
			System.out.print(BWHITE + "\t\t\t");
			System.out.print(dCustomer[i] + "\n ");
		}
	

	}

	@Override
	public String toString() {
		return "[" + amount + " " + dObj + "]";
	}
	
	// setting the to String method to Override
}
