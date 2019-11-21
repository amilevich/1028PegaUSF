package com.example.maindriver;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class MainDriver {

	public static void main(String[] args) {
		
		Pet petOne = new Pet("Old Yeller","Pupper"); //ctrl alt down arrow
		Pet petTwo = new Pet("Scooby-Doo","Doggo");
		Pet petThree = new Pet("Clifford","Big Dog");
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
//		petDaoImpl.insertPet(petOne);
//		petDaoImpl.insertPet(petTwo);
//		petDaoImpl.insertPet(petThree);
		
		//System.out.println(petDaoImpl.selectPetByName("Clifford"));
		//System.out.println(petDaoImpl.selectAllPets());
		//System.out.println("done");
		
		//petThree.setType("Good Boi");
		//petDaoImpl.updatePet(petThree);
		//System.out.println(petDaoImpl.selectPetByName("Clifford"));
		
		petDaoImpl.deletePet(petOne);
		System.out.println(petDaoImpl.selectAllPets());
		
	}

}
