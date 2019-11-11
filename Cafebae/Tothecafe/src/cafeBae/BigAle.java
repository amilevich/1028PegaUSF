package cafeBae;

public class BigAle {
String name;
int price;
String size;
boolean drink = true;


public BigAle(String name, int price, String size, boolean drink) {
	super();
	this.name = name;
	this.price = price;
	this.size = size;
	this.drink = drink;
}


@Override
public String toString() {
	return ""+ size + " " + name + " $" + price + "";
}


}