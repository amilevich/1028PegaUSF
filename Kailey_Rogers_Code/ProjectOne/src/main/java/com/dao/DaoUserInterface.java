package com.dao;

import java.util.ArrayList;


import com.users.Employees;

public interface DaoUserInterface {
	
	public abstract Employees selectUserByName(String name);
	public abstract ArrayList<Employees> getAllEmployees();
	public abstract void addUsers(Employees employee);

}
