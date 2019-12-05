package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.users.Employees;



public class DaoUserTmpl implements DaoUserInterface {
	
	static{

	       try {

	           Class.forName("oracle.jdbc.driver.OracleDriver");

	       } catch (ClassNotFoundException e) {

	           e.printStackTrace();

	       }

	   }
	
	private static String url = "jdbc:oracle:thin:@db1028.cnv5m4h5vxru.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String userName = "ReimbursementDB";
	private static String password = "password123";
	

	


	@Override
	public ArrayList<Employees> getAllEmployees() {
		ArrayList<Employees> allUsers = new ArrayList<Employees>();

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_users");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				allUsers.add(new Employees(rs.getString(4), rs.getString(5), rs.getString(2), rs.getString(3), rs.getString(6), rs.getInt(1), rs.getInt(7)));
			}
			
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return  allUsers;
	}


	@Override
	public void addUsers(Employees employee) {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO ers_users VALUES(?,?,?,?,?, ?, ?)");
			ps.setInt(1, 0);
			ps.setString(2, employee.getUserName());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getFirstName());
			ps.setString(5, employee.getLastName());
			ps.setString(6, employee.getEmail());
			ps.setInt(7, employee.getUserRole());
			ps.executeUpdate();
			conn.close();
			System.out.println("It was hit here");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
		
	}


	@Override
	public Employees selectUserByName(String name) {
		Employees employee = null;
		System.out.println("jere in dao");
		System.out.println(name);
		try (Connection conn = DriverManager.getConnection(url, userName, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_users WHERE ERS_USERSNAME=?");
			System.out.println("prepared statement worked");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employee = new Employees(rs.getString(4),rs.getString(5), rs.getString(2), rs.getString(3), rs.getString(6), rs.getInt(1), rs.getInt(7) );
				
			}
			System.out.println("this is employee in try" + employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("this is emplpyee after try" + employee);
		return employee;
	}
}
