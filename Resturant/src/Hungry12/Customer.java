package Hungry12;

public class Customer {

	private String customerName;
	private String drinkChoice;
	private String foodChoice;
	private int totalPrice;
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Customer(String customerName, String drinkChoice, String foodChoice, int totalPrice) {
		super();
		this.customerName = customerName;
		this.drinkChoice = drinkChoice;
		this.foodChoice = foodChoice;
		this.totalPrice = totalPrice;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDrinkChoice() {
		return drinkChoice;
	}
	public void setDrinkChoice(String drinkChoice) {
		this.drinkChoice = drinkChoice;
	}
	public String getFoodChoice() {
		return foodChoice;
	}
	public void setFoodChoice(String foodChoice) {
		this.foodChoice = foodChoice;
	}
	@Override
	public String toString() {
		return customerName + " ordered a " + drinkChoice + " to drink and a " + foodChoice + " to eat. For a total of $" + totalPrice;
	}
	
	
	
}
