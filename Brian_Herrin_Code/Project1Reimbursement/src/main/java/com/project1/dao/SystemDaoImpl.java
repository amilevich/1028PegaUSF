package com.project1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project1.model.Employee;
import com.project1.model.Manager;
import com.project1.model.Reimbursement;

public class SystemDaoImpl implements EmployeeDao, ManagerDao, ReimbursementDao  {
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static String url = "jdbc:oracle:thin:@revaturepega1028.c6hcjsxpeox2.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Project1";
	private static String password = "p4ssw0rd";
	
	@Override
	public int insertReimbursement(Reimbursement r) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Reimbursements VALUES(?,?,?,?,?)");
			
			ps.setString(1, r.getExpense().name());
			ps.setString(2, r.getStatus().name());
			ps.setDouble(3,r.getAmount());
			ps.setString(4, r.getDescription());
			ps.setString(5, r.getImageData());
			System.out.println(r);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Reimbursement selectReimbursementByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int insertManager(Manager m) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Manager selectManagerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateManager(Manager m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int insertEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Employee selectEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
