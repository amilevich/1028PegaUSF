package com.project.dao;
import java.util.ArrayList;
import com.project.pt1.Admin;
import com.project.pt1.Employee;

public interface AdminDAO {
	
	public ArrayList<Admin> selectAllAdmin();
	public void deleteEmployee(Employee x);
	public void updateEmployee(Employee x);
	public ArrayList<Employee> selectAllEmployees();

}
