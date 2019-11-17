package reveture.home.work;

public class FoodAndDrink {
	protected String menu;
	protected String name;
	protected double price;
	
	public FoodAndDrink(String menu,String name,double price) {
	this.menu = menu;
	this.name =name;
	this.price =price;
	
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
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
		return "FoodAndDrink [menu=" + menu + ", name=" + name + ", price=" + price + "]";
	}

}
