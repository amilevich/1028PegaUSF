package com.example.dao;

import java.util.List;

import com.example.ers.Employee;

public interface EmployeeDao {
	// CREATE
	public int insertEmployee(Employee emp);

	// READ
	public Employee selectEmployeeByUsername(String username);

	public List<Employee> selectAllEmployees();

	// UPDATE
	void updateEmployee(Employee emp);

	// DELETE
	void deleteEmployee(Employee emp);

}
