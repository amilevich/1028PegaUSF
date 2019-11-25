package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.profiles.Profiles;



public interface DaoProlilesInterface {
	
	//Will Create new profiles
	public void insertUsers(Profiles profiles);
	//Will get all the profiles from there
	public ArrayList<Profiles> getUsers();
	//Will Delete User
	public void deleteUsers();
	
	//get check authentication of user
	
	//get all accounts of user
	
	
	public int getSocial(String userName, String password);

}
