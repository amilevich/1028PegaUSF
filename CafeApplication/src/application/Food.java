package application;
import java.util.ArrayList;

public class Food {
	
	private ArrayList<String>orders = new ArrayList<>();  
	
	Food(){
		//this.orders.add("None");
	}

	Food(ArrayList<String> orders){
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
    	String s = printArray(this.orders).toString();
    	return s; 
    }
    
    static String printArray(ArrayList<String>arrli) {
        String s = ""; 
    	for (int i=0; i<arrli.size(); i++) 
            s += (arrli.get(i)+ " "); 
    	return s; 
    }
    
    public ArrayList<String> getorders() {
        return orders;
      }

    public void setName(ArrayList<String>newOrder) {
        this.orders = newOrder;
      }
    
}
