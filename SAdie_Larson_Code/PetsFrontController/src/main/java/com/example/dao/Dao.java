package com.example.dao;

import java.util.List;

import com.example.main.Pet;

public interface Dao {

	/*
	 * DAO Design Pattern - dAta Access Object
	 * the purpose of it is to introduce a database layer to separate our db interactions away from our business logic
	 * 
	 * The DAO interface will provide us with the guideline for our CRUD operation to be performed on objects of type Mdol/Bean(pet)
	 */
	
	//CREATE
	public int insertPet(Pet p); //return type does not matter
	
	//READ
	public Pet selectPetByName(String name);
	public List<Pet> selectAllPets(); //will go to database select all from pets and will then go to java 
	
	//UPDATE
	public int updatePet(Pet p); //return type does not matter
	
	//DELETE
	public int deletePet(Pet p);
	
}