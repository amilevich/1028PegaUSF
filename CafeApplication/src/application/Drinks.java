package application;
import java.util.ArrayList;

public class Drinks {

	private ArrayList<String>orders = new ArrayList<>();  

	Drinks(){
		//this.orders.add("None");
	}
	
	Drinks(ArrayList<String> orders){
		this.orders = orders;
	}
	
	static ArrayList<String> addOrders(ArrayList<String>orders, String name, int amount){
		amount -= 1;  
		for (int i=amount; i>=0; i--) {
			orders.add(name);
		}
		return orders;
	}
	
    @Override
    public String toString() {
    	String s = Food.printArray(this.orders).toString();
    	return s; 
    }
    
    public ArrayList<String> getorders() {
        return orders;
      }

	public void setName(ArrayList<String>newOrder) {
	    this.orders = newOrder;
	  }
	


}
