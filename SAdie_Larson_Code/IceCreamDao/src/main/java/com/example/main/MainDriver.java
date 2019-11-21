package com.example.main;

import com.example.dao.IceCreamDaoImpl;
import com.example.model.IceCream;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IceCream one = new IceCream("Mint Chip", 10);
		IceCream two = new IceCream("Dark Chocolate", 10);
		IceCream three = new IceCream("Black Coal", 10);

		IceCreamDaoImpl iceCreamDaoImpl = new IceCreamDaoImpl();
		// iceCreamDaoImpl.insertIceCream(one);
		// iceCreamDaoImpl.insertIceCream(two);
		// iceCreamDaoImpl.insertIceCream(three);
		//
		// System.out.println(iceCreamDaoImpl.selectByFlavor("Mint Chip"));

		// System.out.println(iceCreamDaoImpl.selectAllIceCream());

		// three.setSprinkles(500);
		// iceCreamDaoImpl.updateIceCream(three);
		// System.out.println(iceCreamDaoImpl.selectByFlavor("Black Coal"));

		iceCreamDaoImpl.deleteIceCream(two);
		System.out.println(iceCreamDaoImpl.selectAllIceCream());
		System.out.println("Done!!!");

	}

}
