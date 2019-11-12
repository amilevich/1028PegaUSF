package com.assignments.day15;

import java.util.ArrayList;

public class Order {
	private ArrayList<Item> itemList;

	public Order(){
		itemList = new ArrayList<Item>();
	} 
	
	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	
	public String toString() {
		String fullOrder = "";
		for(int i = 0; i < itemList.size(); i++) {
			fullOrder = fullOrder.concat(" " + this.itemList.get(i).toString());
		}

		return fullOrder;
	}
}
