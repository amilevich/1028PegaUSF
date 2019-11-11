package cafe;

public class DrinkOrder {
	
	String name;
	String beverage;
	String size;
	String addOns;
	
	public DrinkOrder(String name, String beverage, String size, String addOns) {
		super();
		this.name = name;
		this.beverage = beverage;
		this.size = size;
		this.addOns = addOns;
	}
	public DrinkOrder(String n) {
		this.name = n;
		this.beverage = " ";
		this.size = " ";
		this.addOns = " ";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeverage() {
		return beverage;
	}
	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getAddOns() {
		return addOns;
	}
	public void setAddOns(String addOns) {
		this.addOns = addOns;
	}
	@Override
	public String toString() {
		return "DrinkOrder [name=" + name + ", beverage=" + beverage + ", size=" + size + ", addOns=" + addOns + "]";
	}
	
	

}
