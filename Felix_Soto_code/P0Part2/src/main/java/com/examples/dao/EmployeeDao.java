package com.examples.dao;

import java.util.List;

import com.examples.employeesandadmins.Employees;


public interface EmployeeDao {
	
	//Create
    public int insertEmployee(Employees e);
	
	//read
	public Employees selectEmployeeByEmpID(int emplID);// select your primary key
	public List<Employees> selectAllEmployees();
	
	//update
	public int updateEmployee(Employees e);
	
	//delete
	public int deleteEmployee(Employees e);


}// end interface
