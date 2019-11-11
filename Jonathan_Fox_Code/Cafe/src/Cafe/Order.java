package Cafe;

import java.util.ArrayList;

public class Order {
	private static ArrayList<String> ORDERS = initializeOrders();
	private ArrayList<String> orderList;
	
	Order(){ orderList = new ArrayList<String>(0); }
	
	Order(ArrayList<String> o) throws InstantiationException{
		orderList = new ArrayList<String>(0);
		
		for(String s : o) {
			if(!isOrder(s)) throw new InstantiationException();
			orderList.add(s);
		}
	}
	
	public ArrayList<String> getOrder(){ return orderList; }
	
	public boolean addOrder(String o) {
		try {
			int i = Integer.valueOf(o);
			orderList.add(ORDERS.get(i-1));
			return true;
		}
		catch(NumberFormatException e) {
			if(!isOrder(o)) return false;
			return orderList.add(o);
		}
		catch(NullPointerException e) { return false; }
		catch(IndexOutOfBoundsException e) { return false; }
	}
	
	public static boolean isOrder(String o) { return ORDERS.contains(o); }
	
	public String toString() {
		String s = "";
		
		for(String o : orderList) s += String.format("%s ", o);
		
		if(s.equals("")) return s;
		return s.substring(0, s.length()-1);
	}
	
	private static ArrayList<String> initializeOrders(){
		ArrayList<String> o = new ArrayList<String>();
		
		o.add("Meal"); o.add("Side"); o.add("Drink");
		
		return o;
	}
}
