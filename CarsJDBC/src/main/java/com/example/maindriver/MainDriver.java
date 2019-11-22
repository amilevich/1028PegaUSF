package com.example.maindriver;

import com.example.cars.MyCars;
import com.example.dao.CarsDaoImpl;

public class MainDriver {

	public static void main(String[] args) {
		
		MyCars carOne = new MyCars("Toyota","Highlander", 2020, 5.256555f);
		MyCars carTwo = new MyCars("BMW","X5", 2018, 5.245455f);
		MyCars carThree = new MyCars("Honda","Civic", 2015, 5.24545455f);
		MyCars carFour = new MyCars("Nissan","Murano", 2011, 5.211455f);
		
		
		CarsDaoImpl carDaoImpl = new CarsDaoImpl();
//		carDaoImpl.insertCat(carOne);
//		carDaoImpl.insertCat(carTwo);
//		carDaoImpl.insertCat(carThree);
		carDaoImpl.insertCat(carFour);
		
		//System.out.println(carDaoImpl.insertCat(carOne));
		//System.out.println(carDaoImpl.selectCarsByMake("Toyota"));
		
	}
}
