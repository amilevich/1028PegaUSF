package com.customers.dao;

import java.util.List;

import com.employee.Employee;


public interface EmployeeDao {
	
	//Create
    public int insertEmployee(Employee e);
	
	//read
	public Employee selectEmployeeByEmplID(int emplID);// select your primary key
	public List<Employee> selectAllEmployee();
	
	//update
	public int update(Employee e);
	
	//delete
	public int deleteEmployee(Employee e);


}// end interface
