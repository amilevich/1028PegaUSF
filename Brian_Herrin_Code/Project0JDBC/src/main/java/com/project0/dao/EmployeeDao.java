package com.project0.dao;

import java.util.List;

import com.project0.model.Employee;

public interface EmployeeDao {
	
	/*
	 * DAO Design Pattern - Data Access Object
	 * the purpose of it is to introduce a database layer
	 * to separate our db interactions away from our business logic
	 * 
	 * The DAO interface will provide us with the guideline for our
	 * CRUD operations to be performed on objects of type Model/Bean (Employee)
	 */
	
	//CREATE
	public int insertEmployee(Employee e);
	//READ
	public Employee selectEmployeeByName(String name);
	public List<Employee> selectAllEmployees();
	//UPDATE
	public int updateEmployee(Employee e);
	//DELETE
	public int deleteEmployee(Employee e);
}
