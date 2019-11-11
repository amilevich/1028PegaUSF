package CafeApp;

public class DrinkOrder implements Order {

	public String name;
	public double drinkCost;

	public DrinkOrder(String name, double drinkCost) {
		super();
		this.name = name;
		this.drinkCost = drinkCost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDrinkCost() {
		return drinkCost;
	}

	public void setDrinkCost(Float drinkCost) {
		this.drinkCost = drinkCost;
	}

	@Override
	public String getCustomerBill() {
		return "You ordered a " + this.name + " and it costs $" + this.drinkCost;
	}

}
