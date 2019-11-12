package Hungry12;

public class Drink {
	Drink Cinnamonbrew = new Drink();
	Drink Hotchocolate = new Drink();
	Drink BlackCoffee = new Drink();
	Drink VanillaIcedCoffee = new Drink(); 
	Drink CookiesNCream = new Drink();
	
	
	String name; 
	String Drink;
	public Drink getCinnamonbrew() {
		return Cinnamonbrew;
	}
	public void setCinnamonbrew(Drink cinnamonbrew) {
		Cinnamonbrew = cinnamonbrew;
	}
	public Drink getHotchocolate() {
		return Hotchocolate;
	}
	public void setHotchocolate(Drink hotchocolate) {
		Hotchocolate = hotchocolate;
	}
	public Drink getBlackCoffee() {
		return BlackCoffee;
	}
	public void setBlackCoffee(Drink blackCoffee) {
		BlackCoffee = blackCoffee;
	}
	public Drink getVanillaIcedCoffee() {
		return VanillaIcedCoffee;
	}
	public void setVanillaIcedCoffee(Drink vanillaIcedCoffee) {
		VanillaIcedCoffee = vanillaIcedCoffee;
	}
	public Drink getCookiesNCream() {
		return CookiesNCream;
	}
	public void setCookiesNCream(Drink cookiesNCream) {
		CookiesNCream = cookiesNCream;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDrink() {
		return Drink;
	}
	public void setDrink(String drink) {
		Drink = drink;
	}
	@Override
	public String toString() {
		return "Drink [Cinnamonbrew=" + Cinnamonbrew + ", Hotchocolate=" + Hotchocolate + ", BlackCoffee=" + BlackCoffee
				+ ", VanillaIcedCoffee=" + VanillaIcedCoffee + ", CookiesNCream=" + CookiesNCream + ", name=" + name
				+ ", Drink=" + Drink + "]";
	}
	
	

}
