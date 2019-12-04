package com.example.main;

import com.example.dao.*;

public class MainDriver {

	public static void main(String[] args) {
		Pet petOne = new Pet("Oldy Yelly", "Pup");
		Pet petTwo = new Pet("Scooby Doo", "Doggo");
		Pet petThree = new Pet("Clifford", "Big Dog");

		DaoImpl petDaoImpl = new DaoImpl();
		 petDaoImpl.insertPet(petOne);
		// petDaoImpl.insertPet(petTwo);
		// petDaoImpl.insertPet(petThree);

		// System.out.println(petDaoImpl.selectPetByName("Clifford"));

		// System.out.println(petDaoImpl.selectAllPets());

		// petThree.setType("Good Boi");
		// petDaoImpl.updatePet(petThree);
		// System.out.println(petDaoImpl.selectPetByName("Clifford"));

		// petDaoImpl.deletePet(petOne);
		// System.out.println(petDaoImpl.selectAllPets());
		//System.out.println("Done!!!");
	}

}
