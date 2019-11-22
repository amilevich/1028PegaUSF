package davidsCafe;

public class CustomerFoodEntry {
	
	private String itemsList; 
	private int amount;
	// private int sumOfGoods;
    final String CYAN = "\033[1;96m";
    final String WHITE = "\033[0;97m";
    final String YELLOW = "\033[1;93m";
    final String BWHITE = "\033[1;97m";
    final String RED = "\033[1;95m";
	private static final String[] itemSelection = {  "    \t \t   1: PIZZA:$5", "2: HOT DOG:$3", "3: BURGER:$6","4: DONUT:$3","5: BANANA:$1" };

	
	public String getitemsList() {
		return itemsList; 
	}

	public void setitemsList(String itemsList) {
		this.itemsList = itemsList;
	}

	public int getamount() {
		return amount;
	}

	public void setamount(int amount) {
		this.amount = amount;
	}

	public CustomerFoodEntry() {
		
	    final String CYAN = "\033[1;96m";
	    final String WHITE = "\033[0;97m";
	    final String YELLOW = "\033[1;93m";
	    final String BWHITE = "\033[1;97m";
	    final String RED = "\033[1;95m";
		System.out.println( BWHITE + "\t\t MENU: ");

		for (int i = 0; i < itemSelection.length - 1; i++) {
			System.out.print(itemSelection[i] + "\n\t\t   ");
		}
		System.out.println(itemSelection[itemSelection.length - 1]);
	    System.out.println(CYAN + "============================================================");
	    System.out.println(CYAN + "============================================================");
	}

//the to string operation that converts different data types into different amounts);
	@Override
	public String toString() {
		return "Thanks come again! hope you enjoy your" + itemsList;
	}


}
