package com.customers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accounts.AccountMenu;
import com.customers.Customers;


public class CustomersDaoImpl  implements CustomersDao{
	
	private static String url ="jdbc:oracle:thin:@db1028.ckr66dqj6oqb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "project0";
	private static String password = "passw0rd";
	
	

	@Override
	public int insertCustomers(Customers c) {
		
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Customers VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, c.getCustFname());
			ps.setString(2, c.getCustLname());
			ps.setString(3, c.getUserName());
			ps.setString(4, c.getPassword());
			ps.setInt(5, c.getCustID());
			ps.setString(6, c.getStatus());
			ps.setDouble(7, c.getBal());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
		
	}

	@Override
	public Customers selectCustomersByCustID(int custID) {
		
		Customers cust = null;

		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE custID=?");
			ps.setInt(1, custID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cust = new Customers(rs.getString("CustFname"), rs.getString("CustLname"), rs.getString("UserName"), rs.getString("Password"), rs.getInt("CustID"), rs.getString("Status"), rs.getDouble("Bal"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		return null;

		
		
	}

	@Override
	public List<Customers> selectAllCustomers() {
		List<Customers> cust = new ArrayList<Customers>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cust.add(new Customers(rs.getNString(1), rs.getNString(2),rs.getNString(3),rs.getNString(4),rs.getInt(5),rs.getNString(6),rs.getDouble(7)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return cust;
	}

	@Override
	public int updateCustomers(Customers c) {
	try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Customers SET custFname=?, CustLname=?,UserName=?,Password=?,Status=?,Bal=? WHERE custID=?");
			ps.setString(1, c.getCustFname());
			ps.setString(2, c.getCustLname());
			ps.setString(3, c.getUserName());
			ps.setString(4, c.getPassword());
			ps.setInt(5, c.getCustID());
			ps.setString(6, c.getStatus());
			ps.setDouble(7, c.getBal());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCustomers(Customers c) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Customers WHERE custID=?");
			ps.setInt(1, c.getCustID());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static boolean custExist(String userName ) {
		boolean custUsernameTaken = false;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE userName=?");
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(rs.getString(3).equals(userName)) {
				custUsernameTaken = true;
				break;
			}
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return custUsernameTaken;
	}

	public static boolean custExist1(String passWord) {
		boolean custUsernameTaken = false;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE password=?");
		ps.setString(1, passWord);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(rs.getString(4).equals(passWord)) {
				custUsernameTaken = true;
				AccountMenu.bankingMenu();
				break;
			}
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return custUsernameTaken;
	}// end cust1
	
	
		
}// end customers daoImpl
