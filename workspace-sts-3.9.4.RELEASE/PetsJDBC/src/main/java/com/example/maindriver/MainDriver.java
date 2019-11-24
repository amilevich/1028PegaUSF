package com.example.maindriver;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class MainDriver {

	public static void main(String[] args) {

		Pet petOne = new Pet("Old Yeller","Pupper");
		Pet petTwo = new Pet("Scooby-Doo","Doggo");
		Pet petThree = new Pet("Clifford","Big Dog");
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
//		petDaoImpl.insertPet(petOne);
//		petDaoImpl.insertPet(petTwo);
//		petDaoImpl.insertPet(petThree);
//		
//		System.out.println(petDaoImpl.selectPetByName("Clifford"));
//		System.out.println(petDaoImpl.SelectAllPets());
//		
//		petThree.setType("Good Boi");
//		petDaoImpl.updatePet(petThree);
//		System.out.println(petDaoImpl.selectPetByName("Clifford"));
		System.out.println("done");
	}

}
