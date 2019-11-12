package cafe;

public class Order {
	
	private int num;
	private Customer custumer;
	private Food food;
	private Drink drink;
	
	public Order(int num, Customer custumer, Food food, Drink drink) {
		super();
		this.num = num;
		this.custumer = custumer;
		this.food = food;
		this.drink = drink;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Customer getCustumer() {
		return custumer;
	}

	public void setCustumer(Customer custumer) {
		this.custumer = custumer;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	@Override
	public String toString() {
		return "\n Order num = " + num + "\n " + custumer + "\n " + food + "\n " + drink + "\n Total: ----------------------------" + (food.getPrice() + drink.getPrice());
	}
	
	
	
	

}
