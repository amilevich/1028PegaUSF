package Cafe;

public class Customer {
	private Order order;
	private int id;
	
	Customer(int i){ id = i; order = new Order();}

	public Order getOrder() { return order; }
	public void setOrder(Order o) { order = o; }
	
	public int getID() { return id; }
	
	public String toString() {
		String s = String.format("ID: %d Order:", id);
		
		s += String.format(" %s", order.toString());
		
		return s;
	}
}
