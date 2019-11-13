package Hungry12;

public class Drink {

	
	private String drinkName; 
	private int drinkPrice;
	
	public Drink(String drinkName, int drinkPrice) {
		super();
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getDrinkPrice() {
		return drinkPrice;
	}

	public void setPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}

	@Override
	public String toString() {
		return "and  your " + drinkName + " for a total of $";
	}

	
	
	
	
	

}
