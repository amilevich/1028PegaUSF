package home.cafe.proj;

public class Drink {

	private String name;
	public double price;
	boolean drink = true;

	public Drink(String name, double price) {
	
		
		this.name =name;
		this.price=price;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Drink [name=" + name + ", price=" + price + "]";
	}

	
	
}


