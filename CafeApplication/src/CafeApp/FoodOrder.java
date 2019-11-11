package CafeApp;

public class FoodOrder implements Order {

	public String foodName;
	public double foodCost;

	public FoodOrder(String foodName, double foodCost) {
		super();
		this.foodName = foodName;
		this.foodCost = foodCost;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodCost() {
		return foodCost;
	}

	public void setFoodCost(Float foodCost) {
		this.foodCost = foodCost;
	}

	@Override
	public String getCustomerBill() {

		return "You ordered the " + this.foodName + " and it costs $" + this.foodCost;
	}
}
