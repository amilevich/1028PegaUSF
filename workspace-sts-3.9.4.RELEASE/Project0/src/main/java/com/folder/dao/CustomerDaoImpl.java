package com.folder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.folder.bank.Accounts;
import com.folder.bank.Customers;

public class CustomerDaoImpl {
	
	private static String urL
	= "jdbc:oracle:thin:@bankapp.c8fjsw7dnsyi.us-west-1.rds.amazonaws.com:1521:orcl";
	
	private static String username = "Victoryy";
	private static String password = "p4ssw0rd";
	
	public int insertCustomer(Customers c) {
		try (Connection conn = DriverManager.getConnection(urL,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Customers VALUES(?,?,?,?,?,?)");
			ps.setInt(1, c.getCustomerId());
			ps.setString(2, c.getAccountType());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getPassword());
			ps.setInt(5, c.getTotalBalance());
			ps.setInt(6, c.getPendingApproved());
			ps.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public Customers selectCustomerByID(int id) {
		Customers customer = null;
		try (Connection conn = DriverManager.getConnection(urL,username,password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE customerID=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer = new Customers(rs.getInt("customerID"), rs.getInt("totalBalance"), rs.getString("accountType"), rs.getString("username"), rs.getString("passwords"), rs.getInt("pendingApproved"));
			}
			System.out.println(customer);
			System.out.println("Selected by Customers username complete");
			return customer;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void  selectAllCustomers(){
		
		try(Connection conn = DriverManager.getConnection(urL,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("pendingApproved")== 0) {
					Accounts.accountsPending.add(new Customers(rs.getInt("customerID"), rs.getInt("totalBalance"), rs.getString("accountType"), rs.getString("username"), rs.getString("passwords"), rs.getInt("pendingApproved")));
				} else {
					
					Accounts.accountsApproved.add(new Customers(rs.getInt("customerID"), rs.getInt("totalBalance"), rs.getString("accountType"), rs.getString("username"), rs.getString("passwords"), rs.getInt("pendingApproved")));
				}
			}
			System.out.println("\t Accounts pending from Database: ");
			for(Customers a : Accounts.accountsPending) {
				System.out.println(a);				
			}
			System.out.println("\n");
			System.out.println("\t Accounts approved from Database: ");
			for(Customers b : Accounts.accountsApproved) {
				System.out.println(b);				
			}			
			System.out.println("Select All Customers complete");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public int updateCustomer(Customers c) {
		try (Connection conn = DriverManager.getConnection(urL,username,password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Customers SET totalBalance= (?), pendingApproved= (?) WHERE customerID=?");
			ps.setInt(3, c.getCustomerId());
//			ps.setString(2, c.getAccountType());
//			ps.setString(3, c.getUsername());
//			ps.setString(4, c.getPassword());
			ps.setInt(1, c.getTotalBalance());
			ps.setInt(2, c.getPendingApproved());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteCustomer(Customers c) {
		try(Connection conn = DriverManager.getConnection(urL,username,password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Customers WHERE customerID=?");
			System.out.println(c.getCustomerId());
			ps.setInt(1, c.getCustomerId());
			ps.executeUpdate();
			System.out.println("Deleted " + c);
			System.out.println("Delete complete");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
