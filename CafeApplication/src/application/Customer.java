package application;
import java.util.ArrayList;

public class Customer {
	Food food;
	Drinks drinks;
	int order_num;
	ArrayList<String>orders;
	
	Customer(){
	}
	
	Customer(int order_num, Food food){
		this.food = food;
		this.drinks = null;
		this.order_num = order_num;
		this.orders = food.getorders();
	}
	
	Customer(int order_num, Drinks drinks){
		this.drinks = drinks;
		this.order_num = order_num; 
		this.food = null;
		this.orders = drinks.getorders();
	}
	
	Customer(int order_num, Food food, Drinks drinks){
		this.drinks = drinks;
		this.food = food; 
		this.order_num = order_num; 
	}
	
    @Override
    public String toString() {
    	String o = "Order " + Integer.toString(this.order_num); 
    	return o; 
    }
	
}
