<<<<<<< HEAD
package com.kitchen;

public class MenuItem {
	
	String name;
	double price;
	String description;
	
	
	public MenuItem() {
	}
	public MenuItem(String name,double price) {
		this(name,price,"This is a food item, human, with nutrition.");
	}
	public MenuItem(String name,double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
=======
package com.kitchen;

public class MenuItem {
	
	String name;
	double price;
	String description;
	
	
	public MenuItem() {
	}
	public MenuItem(String name,double price) {
		this(name,price,"This is a food item, human, with nutrition.");
	}
	public MenuItem(String name,double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
>>>>>>> 6a81e4086c1f67bbc62a37b944e316e69b960308