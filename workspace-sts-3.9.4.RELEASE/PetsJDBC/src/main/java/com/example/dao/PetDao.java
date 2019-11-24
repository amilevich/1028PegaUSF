package com.example.dao;

import java.util.List;

import com.example.model.Pet;

public interface PetDao {

	/*
	 * DAO Design Pattern - Data Access Object
	 * the purpose of it is to introduce a database layer to separate our db interactions away from our business logic
	 * 
	 * The DAO interface will provide us with the guideline for our CRUD operations to be performed on objects of type Model/Bean (Pet)
	 
	 */

	// CREATE 
	public int insertPet(Pet P);
	
	// READ 
	public Pet selectPetByName(String name);
	public List<Pet> SelectAllPets();

	
	//UPDATE
	public int updatePet(Pet p);
	
	//DELETE
	public int deletePet(Pet p);}