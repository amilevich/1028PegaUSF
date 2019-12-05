package com.project1.dao;

import com.project1.model.Employee;

public interface EmployeeDao {
	public int insertEmployee(Employee e);
	public Employee selectEmployeeByName(String name);
	public void updateEmployee(Employee e);
	
}
