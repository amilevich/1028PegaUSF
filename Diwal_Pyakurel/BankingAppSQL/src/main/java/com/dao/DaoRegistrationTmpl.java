package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.profiles.Customers;
import com.profiles.Profiles;

public class DaoRegistrationTmpl implements DaoRegistrationINterfaces {

	
	
	private static String url = "jdbc:oracle:thin:@db1028.cnv5m4h5vxru.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String userName = "BankDB";
	private static String password = "password123";
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void insertRegistration(Customers customer) {
		// TODO Auto-generated method stub
		
		int temp = 0;
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO regestration Values(?,?, ?, ?, ?)");
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setInt(3, customer.getSocial());
			ps.setString(4, customer.getSecondUser());
			ps.setInt(5, customer.getSecondSocial());
			ps.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Customers> getAllRegistration() {

		ArrayList<Customers> allRegistration = new ArrayList<Customers>();

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM regestration");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				allRegistration.add(new Customers("userName", "password", rs.getString(1), rs.getString(2), rs.getInt(3), true, rs.getString(4), rs.getInt(5)));

			}
			
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return  allRegistration;
	}
	

	@Override
	public void deleteRegistration() {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE regestration");
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Complete");
	}

}
