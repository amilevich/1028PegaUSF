package com.example.dao;

import java.util.List;

import com.example.cars.MyCars;

public interface CarsDao {
	
	    //Create
	     public int insertCat(MyCars c);
		
		//read
		public MyCars selectCarsByMake(String make);// select your primary key
		public List<MyCars> selectAllcars();
		
		//update
		public int updateMyCars(MyCars c);
		
		//delete
		public int deleteCat(MyCars c);

}
