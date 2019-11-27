package com.bank.simulation.dao;	
import java.util.List;
import com.bank.simulation.Account;

public interface BankDao{
	/* 
	 * DAO Design Pattern - Data Access Object
	 * the prupose of it is to introoduce a data base layer
	 * to seperate our bdb interactions away from our business logic
	 * 
	 * the da interface will provde us with the guidiline for our CRUD operations to be
	 *  performed on objects of type Model/Bean (Pet)
	 * 
	 */
	public int Allow(String name);
	public int Deny(String name);
	public int Cancel(String name);
	//CREATE
	//public int insertAcc(Account p);
	public int insertAcc(int auth, String name, String pwd);
	//READ
	public Account selectPetByName(String name); 
	public List<Account> selectAllPets();
	//UPDATE
	public int updatePet(String name, double balance);
	//DELETE
	public int deletePet(Account p);
}
