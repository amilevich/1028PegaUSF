package com.cafe.app;

import java.util.LinkedList;
import java.util.Queue;

public class CashRegister {

	public static void main(String[] args) {
		//FoodOrder fo = new FoodOrder();
		Queue<DrinkOrder> orderLine = new LinkedList<DrinkOrder>();
		for (int i = 0; i < 3; i++) {
			DrinkOrder dro = new DrinkOrder();
			dro.cusDrinkOrder();
			orderLine.add(dro);
			System.out.println(" ");
			System.out.println(" ");
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(orderLine.peek().toString());
			System.out.println(orderLine.peek().fd.toString());
			System.out.println(" ");
			orderLine.remove();
		}
	}
}
